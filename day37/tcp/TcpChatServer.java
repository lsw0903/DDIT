package day37.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpChatServer {
	public static void main(String[] args) {
		
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(7777);
			System.out.println("채팅서버 준비 완료...");
			socket = server.accept();
			
			// 소켓접속 완료 후 필요한 작업 시작...
			Sender sender = new Sender(socket);
			sender.start();
			
			Receiver receiver = new Receiver(socket);
			receiver.start();
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
	}
}