package day10;

public class T07PhoneExample {
	public static void main(String[] args) {
		
		//T07Phone phone = new T07Phone();
		
		T07SmartPhone smartPhone = new T07SmartPhone("홍길동");
		
		smartPhone.turnOn();
		smartPhone.internetSearch();
		smartPhone.turnOff();
	}
}