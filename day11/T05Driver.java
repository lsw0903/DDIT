package day11;

public class T05Driver {
	     						
							//Bus 객체, Taxi 객체 //
	                              // ↓ //
	public void drive(T04Vehicle vehicle) {
		if(vehicle instanceof T04Bus) { 	// vehicle 매개 변수가 참조하는 객체가 Bus인지 조사
			T04Bus bus = (T04Bus) vehicle;  // Bus 객체일 경우 안전하게 강제 타입 변환
			bus.checkFare();				// Bus 타입으로 강제 타입 변환을 하는 이유
		}
		vehicle.run();
	}
}