package day37.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class TcpSocketClientTest {
	public static void main(String[] args) throws IOException {
		
		String serverIp = "127.0.0.1";
		// 자기 자신 호스트를 나타내는 방법
		// IP : 127.0.0.1
		// 호스트이름 : localhost
		
		System.out.println(serverIp + "서버에 접속중 입니다...");
		
		// 소켓을 생성해서 서버에 연결을 요청한다.
		Socket socket = new Socket(serverIp, 7777);
		
		// 연결이 시작되면 이후의 내용이 실행된다.
		System.out.println("서버에 연결되었습니다...");
		
		// 서버에서 보내온 메시지 받기
		// 메시지를 받기 위해 소켓의 InputStream 객체 사용한다.
		InputStream is = socket.getInputStream();
		DataInputStream dis = new DataInputStream(is);
		
		// 서버로부터 받은 메시지 출력하기
		System.out.println("받은 메시지 : " + dis.readUTF());
		
		System.out.println("연결 종료...");
		
		dis.close();
		
		socket.close();
		
	}
}