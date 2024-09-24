package day33;

public class Service {
	
	@PrintAnnotation
	public void method1() {
		System.out.println("method1() 호출됨.");
	}
	
	@PrintAnnotation(value = "%")
	public void method2() {
		System.out.println("method2() 호출됨.");
	}
	
	@PrintAnnotation(value = "#", count = 25)
	public void method3() {
		System.out.println("method3() 호출됨.");
	}
}