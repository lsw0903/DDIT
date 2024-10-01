package day38.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UdpServer {
	private DatagramSocket ds;
	private DatagramPacket dp;
	private byte[] msg; // 패킷 송수신을 위한 바이트배열 선언
	
	public UdpServer(int port) {
		
		try {
			// 메시지 수신을 위한 포트번호 설정하기
			ds = new DatagramSocket(port);
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void serverStart() throws IOException {
		while(true) {
			
			// 데이터 수신하기 위한 패킷을 생성한다.
			msg = new byte[1];
			dp = new DatagramPacket(msg, msg.length);
			
			System.out.println("패킷수신 대기중...");
			
			// 패킷을 통해 데이터를 수신(receive)한다.
			ds.receive(dp);
			
			System.out.println("패킷 수신완료...");
			
			// 수신한 패킷으로부터 클라이언트의 IP주소와 포트번호를 알아낸다.
			InetAddress addr = dp.getAddress();
			int port = dp.getPort();
			
			// 서버의 현재시간을 시분초 형태.([hh:mm:ss])로 보내준다.
			SimpleDateFormat sdf = new SimpleDateFormat("[hh:mm:ss]");
			String timeStr = sdf.format(new Date());
			msg = timeStr.getBytes(); // 시간데이터를 바이트배열로 변환
			
			// 시간데이터를 패킷에 담아 클라이언트에 전송하기
			dp = new DatagramPacket(msg, msg.length, addr, port);
			ds.send(dp);
		}
	}
	
	public static void main(String[] args) throws IOException {
		new UdpServer(8888).serverStart();
	}
}