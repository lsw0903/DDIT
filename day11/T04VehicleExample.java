package day11;

public class T04VehicleExample {
	public static void main(String[] args) {
		
		T04Vehicle vehicle = new T04Bus();
		
		vehicle.run();
		//vehicle.checkFare();  <--- (x) Vehicle 인터페이스에는 checkFare()가 없음
		
		T04Bus bus = (T04Bus) vehicle; //강제 타입 변환
		
		bus.run();
		bus.checkFare(); //T04Bus 클래스에는 checkFare()가 있음
	}
}