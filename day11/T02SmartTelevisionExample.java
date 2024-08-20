package day11;

public class T02SmartTelevisionExample {
	public static void main(String[] args) {
		
		T02SmartTelevision tv = new T02SmartTelevision();
		
		T02RemoteControl rc = (T02RemoteControl)tv;
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		
		T02Searchable searchable = (T02Searchable)tv;
		searchable.search("http://www.naver.com");
	}
}