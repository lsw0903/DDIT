package day24;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 파일 읽기 예제
 */
public class T05FileStreamTest {
	public static void main(String[] args) {
		
		FileInputStream fis = null;
		
		try {
			fis =
			new FileInputStream("d:/D_Other/text2.txt");
			
			int data = 0;
			
			while((data = fis.read()) != -1) {
				// 읽어온 데이터 콘솔에 출력하기
				System.out.print((char) data);
			}			
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fis.close(); // 작업완료 후 스트림객체 닫기
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}