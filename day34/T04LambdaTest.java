package day34;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class T04LambdaTest {
	public static void main(String[] args) {
		
		List<String> list = new ArrayList<String>();
		list.add("한유림");
		list.add("이지용");
		list.add("이상우");
		list.add("조혜정");
		
		for(String str : list) {
			System.out.println(str);
		}
		System.out.println("----------------------");
		/////////////////////////////////
		
		// 람다식 이용 방법
		list.forEach(name -> System.out.println(name));
		
		System.out.println("----------------------");
		
		// 메서드 참조 이용하기
		list.forEach(System.out::println);
		
		/*
			메서드 참조의 다양한 형태
			
			참조변수::인스턴스메서드
			클래스명::정적메서드
			클래스명::인스턴스메서드
			생성자명::new
		*/
		
		MyPrint mp = new MyPrint();
		System.out.println("참조변수::인스턴스메서드 사용");
		list.forEach(mp::printName);
		
		System.out.println("클래스명::정적메서드 사용");
		list.forEach(MyPrint::printName2);
		
		System.out.println("생성자명::new 사용");
		list.forEach(MyPrint::new);
		
		///////////////////////////////////////////
		// 로또번호 추출하기
		System.out.println("-----------");
		new Random().ints(1, 46).distinct().limit(6)
			.sorted().forEach(n -> System.out.print(n + " "));
		
	}
}

// 메서드 참조 테스트용 클래스
class MyPrint {
	
	public MyPrint() {
		// TODO Auto-generated constructor stub
	}
	
	// 생성자
	public MyPrint(String name) {
		System.out.println("name : " + name);
	}
	
	// 인스턴스 메서드
	public void printName(String name) {
		System.out.println("name : " + name);
	}
	
	// 정적 메서드
	public static void printName2(String name) {
		System.out.println("name : " + name);
	}
}