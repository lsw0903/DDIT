package day37.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Sender extends Thread {
	
	private Scanner scan;
	private String name;
	private DataOutputStream dos;
	
	public Sender(Socket socket) {
		
		name = "[" + socket.getLocalAddress() + " : "
				+ socket.getLocalPort() + "]";
		scan = new Scanner(System.in);
		
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while(dos != null) {
			try {
				// 콘솔로 입력받은 내용 상대방에게 전송하기
				dos.writeUTF(name + " >>> " + scan.nextLine());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}