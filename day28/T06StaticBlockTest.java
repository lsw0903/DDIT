package day28;

public class T06StaticBlockTest {
	
	public T06StaticBlockTest() {
		System.out.println("생성자 호출됨.");
	}
	
	static {
		System.out.println("첫번째 static block 호출됨.");
	}
	
	static {
		System.out.println("두번째 static block 호출됨.");
	}
	
	{
		System.out.println("첫번째 instance block 호출됨.");
	}
	
	{
		System.out.println("두번째 instance block 호출됨.");
	}
	
	public static void print() {
		System.out.println("안녕...");
	}
	
	public static void main(String[] args) {
		/*
		 	코드블럭 호출되는 순서
		 	
		 	1. static block
		 	2. instance block
		 	3. 생성자
		 	
		 	static block 은 제일 처음 한번만 호출된다.(1회성 사용에 적합하다 - ex)jdbc 드라이버 확인시 사용)
		*/
		
		//new T06StaticBlockTest(); // 첫번째 객체 생성
		//new T06StaticBlockTest(); // 두번째 객체 생성
		
		print();
		print();
		print();
	}
}