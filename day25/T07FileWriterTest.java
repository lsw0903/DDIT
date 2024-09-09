package day25;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class T07FileWriterTest {
	public static void main(String[] args) {
	/*
	 	사용자가 입력한 내용을 그대로 파일로 저장하기
	 	
	 	콘솔(표준 입출력장치)과 연결된 입력용 문자스트림 객체 생성
	 	InpustStreamReader => 바이트기반 스트림을 문자기반 스트림으로 
	 						  변환해주는 보조 스트림이다.
	*/
		InputStreamReader isr = new InputStreamReader(System.in);
		
		FileWriter fw = null;
		
		try {
			// 파일 출력용 문자기반 스트림 객체 생성하기
			fw = new FileWriter("d:/D_Other/testChar.txt");
			
			int data = 0;
			
		    System.out.println("아무거나 입력하세요.");
		    
		    // 콘솔에서 입력할 때 입력의 끝을 나타내는 문자는
		    // Ctrl+Z 키를 누르면 된다.
		    while((data = isr.read()) != -1) {
		    	// 콘솔에서 입력받은 값을 파일에 출력하기
		    	fw.write(data); 
		    }
			
		    System.out.println("작업 끝...");
		    
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fw.close();
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}