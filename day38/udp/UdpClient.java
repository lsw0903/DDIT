package day38.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpClient {
	private DatagramSocket ds;
	private DatagramPacket dp;
	
	private byte[] msg;
	
	public UdpClient() {
		
		msg = new byte[100];
		
		try {
			// 포트번호를 명시하지 않으면 이용가능한 임의의 포트번호로 할당됨.
			ds = new DatagramSocket();
		} catch (SocketException e) {
			e.printStackTrace();
		}
	}
	
	public void start() {
		try {
			InetAddress serverAddr = InetAddress.getByName("192.168.143.3");
			dp = new DatagramPacket(msg, 1, serverAddr, 8888);
			ds.send(dp); // 패킷전송...
			
			dp = new DatagramPacket(msg, msg.length);
			ds.receive(dp); // 서버로부터 시간정보를 수신한다.
			
			System.out.println("현재 서버 시간 => " + new String(dp.getData()));
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			ds.close();
		}
	}
	
	public static void main(String[] args) {
		new UdpClient().start();
	}
}