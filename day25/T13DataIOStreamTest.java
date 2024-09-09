package day25;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 	기본타입(Primative)데이터 입출력을 위한 보조스트림
*/
public class T13DataIOStreamTest {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("d:/D_Other/test.dat");
		
		// DataOutputStream은 출력데이터를 자료형에 맞게 출력시켜 준다.
		DataOutputStream dos = new DataOutputStream(fos);
		dos.writeUTF("홍길동");	// 문자열 데이터 출력(UTF-8)
		dos.writeInt(17);		// 정수형으로 데이터 출력
		dos.writeFloat(3.14f);	// 실수형(Float)으로 데이터 출력
		dos.writeDouble(3.14);	// 실수형(Double)으로 데이터 출력
		dos.writeBoolean(true); // 논리형으로 데이터 출력
		
		System.out.println("출력 완료...");
		dos.close();
		///////////////////////////////////////////////////
		// 출력된 데이터 읽어오기
		FileInputStream fis = new FileInputStream("d:/D_Other/test.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		System.out.println("문자열 데이터 : " + dis.readUTF());
		System.out.println("정수형 데이터 : " + dis.readInt());
		System.out.println("실수형(Float) 데이터 : " + dis.readFloat());
		System.out.println("실수형(Double) 데이터 : " + dis.readDouble());
		System.out.println("논리형 데이터 : " + dis.readBoolean());
		
		dis.close(); // 다 사용한 스트림객체 닫기...
	}
}