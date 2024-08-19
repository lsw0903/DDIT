package day10;

public class T02Child extends T02Parent {
	
	@Override //재정의
	public void method2() {
		System.out.println("Child-method2()");
	}
	
	public void method3() {
		System.out.println("Child-method3()");
	}
}