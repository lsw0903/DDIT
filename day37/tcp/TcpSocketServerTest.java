package day37.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpSocketServerTest {
	public static void main(String[] args) throws IOException {
		
		// 소켓이란? 두 호스트간 통신을 하기 위한 양 끝단(EndPoint)을 말한다.
		// TCP 소켓통신을 위해 ServerSocket객체 생성
		ServerSocket server = new ServerSocket(7777);
		System.out.println("서버가 접속을 기다립니다...");
		
		// accept()메서드는 클라이언트에서 연결 요청이 올때까지 계속 기다린다.
		// 연결 요청이 오면 Socket객체를 생성하여 반환한다.
		Socket socket = server.accept();
		
		//----------------------------------------------------
		// 이 이후는 클라이언트의 연결된 후의 작업을 진행하면 된다.
		System.out.println("접속한 클라이언트 정보");
		System.out.println("주소 : " + socket.getInetAddress());
		
		// 클라이언트에게 메시지 보내기
		OutputStream out = socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(out);
		dos.writeUTF("어서오세요..."); // 메시지 보내기...
		System.out.println("메시지를 보냈습니다.");
		
		dos.close(); // 스트림 닫기
		
		server.close(); // 소켓 닫기
		
	}
}