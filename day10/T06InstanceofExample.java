package day10;

public class T06InstanceofExample {
	public static void method1(T06Parent parent) {
		
		if(parent instanceof T06Child) { //Child 타입으로 변환이 가능한지 확인
			T06Child child = (T06Child) parent;
			System.out.println("method1 - Child로 변환 성공");
		} else {
			System.out.println("method1 - Child로 변환되지 않음");
		}
	}
	
	public static void method2(T06Parent parent) {
		T06Child child = (T06Child) parent; //ClassCastException이 발생할 가능성 있음
		System.out.println("method2 - Child로 변환 성공");
	}
	
	public static void main(String[] args) {
		
		T06Parent parentA = new T06Child();
		
		//Child 객체를 매개값으로 전달
		method1(parentA);
		method2(parentA);
		
		T06Parent parentB = new T06Parent();
		
		//Parent 객체를 매개값으로 전달
		method1(parentB);
		method2(parentB); //예외 발생
	}
}