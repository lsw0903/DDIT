package day11;

public class T01Dog extends T01Animal {
	
	public T01Dog() {
		this.kind = "포유류";
	}
	
	//추상 메소드 재정의
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}