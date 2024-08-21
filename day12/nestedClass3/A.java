package day12.nestedClass3;

public class A {
	int field1;
	void method1() {}
	
	static int field2;
	static void method2() {}
	
	
	class B {
		void method() {
			field1 = 10;
			method1();
			
			field2 = 10;
			method2();
		}
	}
	
	static class C {
		void method() {
//			field1 = 10; -> 인스턴스 필드
//			method1(); -> 인스턴스 메서드
			
			field2 = 10;
			method2();
		}
	}
}
