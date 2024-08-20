package day11;

public class T03MyClass {
	
	//필드
	T02RemoteControl rc = new T02Television();
	
	//생성자
	T03MyClass() {
	}
	
	T03MyClass(T02RemoteControl rc) {
		this.rc = rc;
		rc.turnOn();
		rc.setVolume(5);
	}
	
	//메소드
	void methodA() {
		T02RemoteControl rc = new T02Audio();
		rc.turnOn();
		rc.setVolume(5);
	}
	
	void methodB(T02RemoteControl rc) {
		rc.turnOn();
		rc.setVolume(5);
	}
}