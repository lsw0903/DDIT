package day24;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class T03ByteArrayIOTest {
	
	public static void main(String[] args) throws IOException {
		
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		
		// 스트림 객체 생성
		ByteArrayInputStream bais = new ByteArrayInputStream(inSrc);
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		int data = 0; // 읽어온 데이터(바이트)를 저장할 변수
		
		// read() => byte단위로 데이터를 읽어와 int형으로 반환한다.
		//        => 더이상 읽을 데이터가 없으면 -1을 반환한다.
		while((data = bais.read()) != -1) {
			baos.write(data);
		}
		
		// 출력된 스트림 데이터를 배열로 변환해서 반환하는 메서드
		outSrc = baos.toByteArray();
		
		System.out.println("inSrc => " + Arrays.toString(inSrc));
		System.out.println("outSrc => " + Arrays.toString(outSrc));
		
		// 스트림 객체 닫기
		bais.close();
		baos.close();
	}
}