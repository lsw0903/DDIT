package day25;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class T10FileEncodingTest {
	public static void main(String[] args) throws IOException {
		/*
		 	키보드로 입력한 내용을 파일로 저장하는데,
		 	out_utf8.txt파일은 'UTF-8' 인코딩 방식으로...
		 	out_ansi.txt파일은 'MS949' 인코딩 방식으로 저장한다.
		*/
		    
			// OutputStreamWriter => 바이트기반 스트림을 문자기반 스트림으로 변환해주는 보조스트림
			//                    => 이 객체도 출력할 때 '인코딩방식'을 지정할 수 있다.
		
			InputStreamReader isr = new InputStreamReader(System.in);
			
			// 파일 출력용 스트림 객체 생성하기
			FileOutputStream fos1 = new FileOutputStream("d:/D_Other/out_utf8.txt");
			FileOutputStream fos2 = new FileOutputStream("d:/D_Other/out_ansi.txt");
			
			OutputStreamWriter osw1 = new OutputStreamWriter(fos1, "UTF-8");
			OutputStreamWriter osw2 = new OutputStreamWriter(fos2, "MS949");
			
			System.out.println("아무거나 입력하세요...");
			
			int data = 0;
			
			while((data = isr.read()) != -1) {
				osw1.write(data);
				osw2.write(data);
			}
			
			System.out.println("출력 작업 완료...");
			
			// 사용 다한 스트림 객체 닫기...(보조스트림만 닫아도 된다.)
			osw1.close();
			osw2.close();
			isr.close();
	}
}