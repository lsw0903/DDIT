package day37.tcp;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TcpMultiChatClient {
	
	// 시작 메서드
	public void clientStart() {
		Socket socket = null;
		
		try {
			socket = new Socket("192.168.143.21", 7777);
			System.out.println("멀티챗 서버에 접속되었습니다...");
			
			// 송신용 스레드 생성 및 실행
			ClientSender sender = new ClientSender(socket);
			sender.start();
			
			// 수신용 스레드 생성 및 실행
			ClientReceiver receiver = new ClientReceiver(socket);
			receiver.start();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
	
	// 메시지를 전송하기 위한 스레드 클래스
	class ClientSender extends Thread {
		private DataOutputStream dos;
		private Scanner scan;
		
		public ClientSender(Socket socket) {
			
			scan = new Scanner(System.in);
			
			try {
				dos = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			
			if(dos != null) {
				// 시작하자 마자 자신의 대화명을 서버로 전송한다.
				System.out.print("대화명 >> ");
				
				try {
					dos.writeUTF(scan.nextLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			while(dos != null) {
				// 채팅 메시지를 서버로 전송한다.
				try {
					dos.writeUTF(scan.nextLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	// 수신용 스레드 클래스
	class ClientReceiver extends Thread {
		private DataInputStream dis;
		
		public ClientReceiver(Socket socket) {
			try {
				dis = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			while(dis != null) {
				try {
					// 서버로부터 수신한 메시지 콘솔에 출력하기
					System.out.println(dis.readUTF());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new TcpMultiChatClient().clientStart();
	}
}