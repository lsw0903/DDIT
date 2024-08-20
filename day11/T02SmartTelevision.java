package day11;

public class T02SmartTelevision implements T02RemoteControl, T02Searchable {
	
	private int volume;
	
	//
	public void turnOn() {
		System.out.println("TV를 켭니다.");
	}
		
	public void turnOff() {
		System.out.println("TV를 끕니다.");
	}
		
	public void setVolume(int volume) {
		if(volume>T02RemoteControl.MAX_VOLUME) {
			this.volume = T02RemoteControl.MAX_VOLUME;
			} else if(volume<T02RemoteControl.MIN_VOLUME) {		//T02RemoteControl의 추상 메소드에 대한 실체 메소드
				this.volume = T02RemoteControl.MIN_VOLUME;
			} else {
				this.volume = volume;						
			}
		System.out.println("현재 TV 볼륨 : " + this.volume);
	}
	//
	
	public void search(String url) {
		System.out.println(url + "을 검색합니다.");		//T02Searchable의 추상 메소드에 대한 실체 메소드
	}
}