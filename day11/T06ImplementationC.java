package day11;

public class T06ImplementationC implements T06InterfaceC {
	
	@Override
	public void methodA() {
		System.out.println("ImplementationC-methodA() 실행"); //
	}
															 // InterfaceA와 InterfaceB의 실체 메소드도 있어야 함
	@Override                                                
	public void methodB() {
		System.out.println("ImplementationC-methodB() 실행"); //
	}
	
	@Override
	public void methodC() {
		System.out.println("ImplementationC-methodC() 실행");
	}
}