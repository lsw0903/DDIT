package day38.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpFileClient {
/*
 	클라이언트는 서버에 접속하면 먼저 받고자하는 파일명을 전송하고,
 	OK 문자를 받으면 해당 파일내용을 받아서 파일로 저장한다.
*/
	private Socket socket;
	private FileOutputStream fos;
	private DataInputStream dis;
	private DataOutputStream dos;
	private Scanner scan;
	
	public TcpFileClient() {
		scan = new Scanner(System.in);
	}
	
	public void clientStart() {
		
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {
			socket = new Socket("192.168.143.3", 7777);
			
			System.out.println("파일서버에 접속되었습니다...");
			
			// 소켓접속이 성공하면 받고싶은 파일명을 보낸다.
			System.out.println("파일명 >> ");
			String fileName = scan.next();
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(fileName);
			
			// 서버로부터 결과내용 받기
			dis = new DataInputStream(socket.getInputStream());
			String resultMsg = dis.readUTF();
			
			if(resultMsg.equals("OK")) {
				
				File downDir = new File("d:/D_Other/down_files");
				
				if(!downDir.exists()) {
					downDir.mkdir(); // 폴더 생성하기
				}
				
				File file = new File(downDir, fileName);
				fos = new FileOutputStream(file);
				
				bis = new BufferedInputStream(socket.getInputStream());
				bos = new BufferedOutputStream(fos);
				
				int data = 0;
				while((data = bis.read()) != -1) {
					bos.write(data);
				}
				
				System.out.println("파일 다운로드 완료...");
				
			}else {
				System.out.println(resultMsg);
			}
			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				bis.close();
				bos.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpFileClient().clientStart();
	}
}