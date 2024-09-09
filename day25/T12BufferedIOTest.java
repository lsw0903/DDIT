package day25;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
  	입출력 성능향상을 위한 보조스트림 객체 사용 예제
  	(문자기반의 Buffered스트림 객체 사용 예제)
*/
public class T12BufferedIOTest {
	public static void main(String[] args) {
		FileReader fr = null;
		BufferedReader br = null;
		
		try {
			// 이클립스에서 만든 자바프로그램이 실행되는 기본 위치는 
			// 해당 '프로젝트폴더'가 기본(현재)위치가 된다.
			fr = new FileReader("src/kr/or/ddit/basic/T11BufferedIOTest.java");
			br = new BufferedReader(fr);
			
			String tmpStr = "";
			
			int cnt = 1;
			while((tmpStr = br.readLine()) != null) {
				System.out.printf("%4d : %s\n", cnt++, tmpStr);
			}
			
			/* int data = 0;
			while((data = fr.read()) != -1) {
				System.out.print((char) data);
			} */
			
			System.out.println();
			System.out.println("읽기 작업 끝...");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}