package day39.http;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.util.StringTokenizer;

import day39.http.MyHttpServer;
import day39.http.MyHttpServer.HttpHandler;

/*
 	간단한 웹서버 예제
*/
public class MyHttpServer {
	
	private final int PORT = 80;
	private final String ENCODING = "UTF-8";
	
	public void start() {
		
		System.out.println("HTTP 서버가 시작되었습니다.");
		
		try(ServerSocket server = new ServerSocket(PORT)){
			while(true) {
				System.out.println("사용자 요청을 기다립니다...");
				Socket socket = server.accept();
				
				HttpHandler handler = new HttpHandler(socket);
				handler.start(); // 요청처리 시작...
				
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/*
		Http 요청처리를 위한 Handler 스레드
	*/
	class HttpHandler extends Thread {
		private Socket socket;
		
		public HttpHandler(Socket socket) {
			this.socket = socket;
		}
		
		@Override
		public void run() {
			BufferedOutputStream bos = null;
			BufferedReader br = null;
			
			try {
				bos = new BufferedOutputStream(
						socket.getOutputStream());
				br = new BufferedReader(
						new InputStreamReader(
								socket.getInputStream()));
				
				// Request Line (첫줄은 요청라인...)
				String reqLine = br.readLine();
				
				System.out.println("reqLine => " + reqLine);
				
				// 헤더정보(Header)
				System.out.println("============================");
				System.out.println("요청헤더정보 : ");
				while(true) {
					String str = br.readLine();
					System.out.println(str);
					
					if(str.equals("")) {
						//br.close();
						break;
					}
				}
				System.out.println("============================");
				
				// 요청경로 정보 가져오기
				String reqPath = "";
				
				StringTokenizer st = new StringTokenizer(reqLine);
				while(st.hasMoreTokens()) {
					String token = st.nextToken();
					if(token.startsWith("/")) {
						reqPath = token;
						break;
					}
				}
				
				// URLDecoder를 이용한 디코딩 처리하기
				reqPath = URLDecoder.decode(reqPath, ENCODING);
				
				System.out.println("reqPath => " + reqPath);
				
				////////////////////////////////////////////
				
				String filePath = "./webapp" + reqPath;
				
				System.out.println("filePath : " + filePath);
				
				// 해당 파일이름을 이용하여 Content-Type 정보 추출하기
				String contentType = URLConnection.getFileNameMap()
						.getContentTypeFor(filePath);
				
				// CSS파일인 경우 인식이 잘 안되서 추가함
				if(contentType == null && filePath.endsWith(".css")) {
					contentType = "text/css";
				}
				
				System.out.println("contentType => " + contentType);
				
				File reqFile = new File(filePath); 
				if(!reqFile.exists()) {
					makeErrorPage(bos, 404, "Not Found");
					return;
				}
				
				byte[] body = makeResponseBody(filePath);
				
				byte[] header = makeResponseHeader(body.length, contentType);
				
				/////////////////////////////////////////////////////////////
				
				bos.write(header); // 응답헤더 전송
				
				bos.write("\r\n\r\n".getBytes()); // Empty Line 전송
				
				bos.write(body); // 응답내용 전송
				
				bos.flush();
				
			}catch(IOException ex) {
				ex.printStackTrace();
			}finally {
				try {
					socket.close(); // 소켓 닫기(연결 끊기)
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 	응답헤더 생성하기
	 	@param contentLength 응답내용 크기
	 	@param mimeType 컨텐트 타입정보
	 	@return
	*/
	private byte[] makeResponseHeader(int contentLength, String mimeType) {
		String header = "HTTP/1.1 200 OK\r\n" + "Server : MyHttpServer 1.0\r\n"
					  + "Content-length : " + contentLength + "\r\n"
				      + "Content-type : " + mimeType + "; charset=" + ENCODING;
		
		return header.getBytes();
	}
	
	/*
	 	응답내용 생성하기
	 	@param filePath 응답내용으로 사용할 파일경로
	 	@return 응답내용을 담은 바이트배열
	*/
	private byte[] makeResponseBody(String filePath) {
		FileInputStream fis = null;
		
		byte[] data = null;
		
		try {
			File file = new File(filePath);
			data = new byte[(int) file.length()];
			
			fis = new FileInputStream(file);
			fis.read(data);
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return data;
	}
	
	private void makeErrorPage(OutputStream out,
			int statusCode, String errMsg) {
		String statusLine = "HTTP/1.1" + " " + statusCode
				+ " " + errMsg;
		
		try {
			out.write(statusLine.getBytes());
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new MyHttpServer().start();
	}
}