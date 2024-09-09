package day25;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class T08FileReaderTest {
	public static void main(String[] args) {
		/*
		 	문자기반 스트림 객체를 이용한 파일내용 읽기 예제
		*/
		
		FileReader fr = null;
		//FileInputStream fis = null;
		
		try {
			fr = new FileReader("d:/D_Other/testChar.txt");
			//fis = new FileInputStream("d:/D_Other/testChar.txt");
			
			int data = 0;
			
			while((data = fr.read()) != -1) {
				System.out.print((char) data);
			}
			
			System.out.println();
			System.out.println("읽기 작업 끝...");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fr.close();
				//fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}