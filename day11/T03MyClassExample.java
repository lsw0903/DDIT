package day11;

public class T03MyClassExample {
	public static void main(String[] args) {
		
		System.out.println("1)-------------");
		
		T03MyClass myClass1 = new T03MyClass();
		myClass1.rc.turnOn();
		myClass1.rc.setVolume(5);
		
		System.out.println("2)-------------");
		
		T03MyClass myClass2 = new T03MyClass(new T02Audio());
		
		System.out.println("3)-------------");
		
		T03MyClass myClass3 = new T03MyClass();
		myClass3.methodA();
		
		System.out.println("4)-------------");
		
		T03MyClass myClass4 = new T03MyClass();
		myClass4.methodB(new T02Television());
	}
}