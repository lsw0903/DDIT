package day37.tcp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpChatClient {
	public static void main(String[] args) throws IOException {
		
		Socket socket = new Socket("192.168.143.21", 7777);
		System.out.println("채팅서버에 연결되었습니다...");
		
		Sender sender = new Sender(socket);
		Receiver receiver = new Receiver(socket);
		
		sender.start();
		receiver.start();
	}
}