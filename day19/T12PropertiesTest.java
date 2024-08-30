package day19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class T12PropertiesTest {
	
	public static void main(String[] args) throws IOException {
	
		/*
		   Properties 객체는 Map보다 축소된 기능의 객체라고 할 수 있다.
		   Map은 모든 타입의 객체를 key와 value값으로 사용할 수 있지만
		   Properties객체는 key와 value값으로 String객체만 사용가능함.
		 */
		Properties prop = new Properties();
		
		prop.setProperty("name", "홍길동");
		prop.setProperty("tel", "010-1111-1111");
		prop.setProperty("addr", "대전시");
		
		String name = prop.getProperty("name");
		String tel = prop.getProperty("tel");
		
		System.out.println("이름 : " + name);
		System.out.println("전화 : " + tel);
		System.out.println("주소 : " 
				+ prop.getProperty("addr"));
		
		//데이터를 파일로 저장하기
//		prop.store(
//				new FileOutputStream(
//						"./src/day19/test.properties")
//				, "코멘트(comment)입니다.");
		
		//properties파일 읽기 예제
		prop.load(new FileReader(
				"./src/day19/test.properties"));
		
		System.out.println("읽어온 데이터...");
		System.out.println(prop.getProperty("fruit"));
		
	}

}