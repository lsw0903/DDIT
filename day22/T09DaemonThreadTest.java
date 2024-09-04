package day22;

public class T09DaemonThreadTest {
	public static void main(String[] args) {
		
		AutoSaveThread th = new AutoSaveThread();
		
		// 데몬스레드로 설정하기(start()메서드 호출전에 설정해야 한다.)
		th.setDaemon(true);
		th.start();
		
		try {
			for(int i=1; i<=20; i++) {
				System.out.println("작업 - " + i);
				Thread.sleep(1000);
			}
		}catch(InterruptedException ex) {
			ex.printStackTrace();
		}
		System.out.println("메인 스레드 종료...");
	}
}

// 자동 저장기능을 제공하는 스레드
class AutoSaveThread extends Thread {
	
	public void save() {
		System.out.println("작업 내용을 저장합니다...");
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			save(); // 저장기능 호출
		}
	}
}