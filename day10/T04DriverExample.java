package day10;

public class T04DriverExample {
	public static void main(String[] args) {
		
		T04Driver driver = new T04Driver();
		T04Bus bus = new T04Bus();
		T04Taxi taxi = new T04Taxi();
		
		driver.drive(bus); //자동 타입 변환 : T04Vehicle vehicle = bus;
		driver.drive(taxi); // 자동 타입 변환 : T04Vehicle vehicle = taxi;
	}
}