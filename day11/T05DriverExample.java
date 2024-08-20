package day11;

public class T05DriverExample {
	public static void main(String[] args) {
		
		T05Driver driver = new T05Driver();
		
		T04Bus bus = new T04Bus();
		T04Taxi taxi = new T04Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
	}

}