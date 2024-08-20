package day11;

public class T01Cat extends T01Animal {
	
	public T01Cat() {
		this.kind = "표유류";
	}
	
	//추상 메소드 재정의
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}