package day11;

public class T01AnimalExample {
	public static void main(String[] args) {
		
		T01Dog dog = new T01Dog();
		T01Cat cat = new T01Cat();
		dog.sound();
		cat.sound();
		System.out.println("-----");
		
		//변수의 자동 타입 변환
		T01Animal animal = null;
		
		//자동 타입 변환 및 재정의된 메소드 호출
		animal = new T01Dog();
		animal.sound();
		//자동 타입 변환 및 재정의된 메소드 호출
		animal = new T01Cat();
		animal.sound();
		System.out.println("-----");
		
		//메소드 파라미터의 다형성
		animalSound(new T01Dog());
		animalSound(new T01Cat());
	}
	                               //자동 타입 변환
	public static void animalSound(T01Animal animal) {
		
		//재정의된 메소드 호출
		animal.sound();
	}
}