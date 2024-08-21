package day12.nestedClass;

public class A {
	//A constructor
	A() {
		System.out.println("A 객체가 생성됨");
	}
	
	//nested instance class
	class B{
		//B field
		int field1;
		static int field2;
		
		//B constructor
		B() {
			System.out.println("B 객체가 생성됨");
		}
		
		//B method
		void method1() {
			
		}
	}
	
	//nested static class
	static class C{
		//C field
		int field1;
		static int field2;
		
		//C constructor
		C() {
			System.out.println("C 객체가 생상됨");
		}
		
		//C method
		void method1() {
			
		}
		
		static void method2() {
			
		}
	}
	
	//A method
	void method() {
		//nested local class
		class D{
			//D field
			int field1;
			static int field2;
			
			//D constructor
			public D() {
				System.out.println("D 객체가 생성됨");
			}
			
			//D method
			void method1() {
				
			}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
	}
}
