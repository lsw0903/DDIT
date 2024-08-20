package day11;

public class T02RemoteControlExample {
	public static void main(String[] args) {
		
		T02RemoteControl rc;
		rc = new T02Television();
		rc.turnOn();
		rc.setVolume(7);
		rc.turnOff();
		System.out.println("---------------------");
		
		rc = new T02Audio();
		rc.turnOn();
		rc.setVolume(50);
		rc.turnOff();
	}
}