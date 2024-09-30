package day37.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TcpMultiChatServer {
	
	// 대화명, 클라이언트의 Socket객체를 저장하기 위한 Map 객체변수 선언
	private Map<String, Socket> clients;
	
	public TcpMultiChatServer() {
		// 동기화 처리가 가능하도록 Map객체 생성
		clients = Collections.synchronizedMap(new HashMap<>());
	}
	
	// 서버 시작 메서드
	private void serverStart() {
		Socket socket = null;
		
		try(ServerSocket serverSocket = new ServerSocket(7777)){
			System.out.println("멀티챗 서버가 시작되었습니다.");
			
			while(true) {
				// 클라이언트의 접속요청을 기다린다.
				socket = serverSocket.accept();
				
				System.out.println("[" + socket.getInetAddress()
									+ " : " + socket.getPort() 
									+ "] 에서 접속하였습니다.");
				// 사용자가 보내준 메시지를 받아 처리하기 위한 스레드 생성 및 실행
				ServerReceiver sr = new ServerReceiver(socket);
				sr.start();
			}
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	/*
	 	대화방 즉, Map에 저장된 전체 접속자에게 안내메시지를 전송하기 위한 메서드
	 	@param msg 전송할 안내 메시지
	*/
	public void sendMessage(String msg) {
		
		Iterator<String> it = clients.keySet().iterator();
		while(it.hasNext()) {
			String name = it.next(); // 대화명(key값) 가져오기
			
			// 해당 사용자에게 메시지 보내기
			try {
				DataOutputStream dos = new DataOutputStream(
						clients.get(name).getOutputStream());
				dos.writeUTF(msg);
				
			}catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
	
	/*
 		대화방 즉, Map에 저장된 전체 접속자에게 채팅메시지를 전송하기 위한 메서드
 		@param msg 채팅 메시지
 		@param from 보내는 사람 대화명
	*/
	public void sendMessage(String msg, String from) {
		sendMessage("[" + from + "] " + msg);
	}
	
	// 서버에서 클라이언트로부터 수신한 메시지를 처리하기 위한 클래스
	// Inner 클래스로 정의함.(Inner 클래스에서는 부모클래스의 멤버들을 직접 접근 할 수 있음)
	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream dis;
		private String name;
		
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				// 서버에서는 클라이언트가 보내는 최초의 메시지 즉, 대화명을 수신한다.
				name = dis.readUTF();
				
				// 대화명을 받아서 다른 모든 클라이언트에게 대화방
				// 참여 메시지를 보낸다.
				sendMessage("#" + name + "님이 입장했습니다.");
				
				// 대화명과 소켓객체를 Map에 저장한다.
				clients.put(name, socket);
				
				System.out.println("현재 서버 접속자 수는 "
						+ clients.size() + "명 입니다.");
				
				// 이후의 메시지 처리는 반복문으로 처리한다.(일반 대화)
				// 클라이언트가 보낸 메시지를 접속한 모든 사람들에게 전송한다.
				while(dis != null) {
					sendMessage(dis.readUTF(), name);
				}
				
			}catch(IOException ex) {
				ex.printStackTrace();
			}finally {
				// 이 finally 영역이 실핸된다는 것은 클라이언트의 접속이
				// 종료되었다는 의미이다.
				sendMessage("#" + name + "님이 나가셨습니다.");
				
				// Map에서 해당 대화명을 삭제한다.
				clients.remove(name);
				
				System.out.println("[" + socket.getInetAddress()
				+ " : " + socket.getPort() 
				+ "] 에서 접속을 종료하였습니다.");
				
				System.out.println("현재 서버 접속자 수는 "
						+ clients.size() + "명 입니다.");
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpMultiChatServer().serverStart();
	}
}