package day25;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class T09FileEncodingTest {
	public static void main(String[] args) {
		/*
		 	한글 인코딩 방식에 대하여...
		 	
		 	한글 인코딩 방식은 크게 UTF-8 과 EUC-KR 방식, 두가지로 나뉜다.
		 	
		 	원래 한글윈도우즈는 CP949방식을 사용했는데, 윈도우를 개발한 
		 	마이크로소프트사에서 EUC-KR방식에서 확장했기 때문에 MS949라고도 부른다.
		 	
		 	한글 윈도우즈의 메모장에서 말하는 ANSI인코딩이란 CP949(Code Page 949)를 의미한다.
		 	
		 	- MS949(또는 CP949) => 한글윈도우즈의 기본 한글인코딩 방식
		 	- UTF-8 => 유니코드 UTF-8 인코딩 방식(영문자 및 숫자 : 1byte, 한글 : 3byte)
		 	- US-ASCII => 영문전용 인코딩 방식
		 	
		 	참고) 인코딩 방식의 변천사
		 	
		 	ASCII => extended ASCII(ISO 8859-1) => 조합형, 완성형
		 	
		 	=> 윈도우계열 : CP949(확장 완성형) - 일부문자(8822자)를 추가함.
		 	=> 유닉스계열 : EUC-KR(확장 유닉스 코드)
		 	
		 	=> ANSI계열 => EUC-KR
		 	
		 	=> 유니코드(UTF-8)
		*/
		
		FileInputStream fis = null;
		InputStreamReader isr = null;
		
		try {
			//fis = new FileInputStream("d:/D_Other/test_ansi.txt");
			fis = new FileInputStream("d:/D_Other/test_utf8.txt");
			// 파일 인코딩 정보를 이용하여 파일내용 읽어오기
			// ex) new InputStreamReader(바이트기반스트림객체, 인코딩방식);
			isr = new InputStreamReader(fis, "UTF-8");
			
			int data = 0;
			while((data = isr.read()) != -1) {
				System.out.print((char) data);
			}
			System.out.println();
			System.out.println("출력 끝...");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				isr.close(); // 보조스트림만 닫아도 된다.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}