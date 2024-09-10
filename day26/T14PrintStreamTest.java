package day26;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;

/*
	프린트 기능을 제공하는 보조스트림 예제
*/

public class T14PrintStreamTest {
	public static void main(String[] args) throws IOException {
		
		// PrintStream은 모든 자료형 데이터를 출력할 수 있는 기능을 제공하는 스트림 클래스이다.
		FileOutputStream fos = new FileOutputStream("d:/D_Other/print.txt");
													//코드의 가독성을 위해 예외를 던짐 - IOException
		PrintStream out = new PrintStream(fos);
		out.print("안녕하세요. PrintStream 입니다.\n");
		out.println("안녕하세요. PrintStream 입니다2.");
		out.println("안녕하세요. PrintStream 입니다3.");
		out.println(out); // 객체 출력
		out.println(3.14);
		
		System.out.println("출력 완료...");
		
		out.close();
		
		///////////////////////////////////////////////////////////////////
		
		//PrintWriter - PrintStream보다 나중에 나왔다(기존의 PrintStream을 더 사용한다)
		//			  - 저장시에 인코딩 방식을 지정해서 저장할 수 있다.(PrintStream은 불가능)
		FileOutputStream fos2 = new FileOutputStream("d:/D_Other/print2.txt");

		PrintWriter out2 = new PrintWriter(new OutputStreamWriter(fos2, "CP949"));
		//																"UTF-8"
		out2.print("안녕하세요. PrintStream 입니다.\n");
		out2.println("안녕하세요. PrintStream 입니다2.");
		out2.println("안녕하세요. PrintStream 입니다3.");
		out2.println(out2); // 객체 출력
		out2.println(3.14);

		System.out.println("출력 완료...");

		out2.close();
	}
}