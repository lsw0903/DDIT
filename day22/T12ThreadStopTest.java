package day22;

public class T12ThreadStopTest {
	public static void main(String[] args) {
		/*
		ThreadStopEx1 th1 = new ThreadStopEx1();
		th1.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		th1.setStoped(true); // 스레드 종료시키기
		//th1.stop();
		*/
		
		ThreadStopEx2 th2 = new ThreadStopEx2();
		th2.start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		th2.interrupt(); // th2스레드에 인터럽트 걸기
		
	}
}

class ThreadStopEx1 extends Thread {
	private boolean isStoped;

	public void setStoped(boolean isStoped) {
		this.isStoped = isStoped;
	}
	
	@Override
	public void run() {
		while(!isStoped) {
			System.out.println("스레드 처리 중...");
		}
		
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}

// interrupt()메서드를 이용하여 스레드를 멈추기
class ThreadStopEx2 extends Thread {
	@Override
	public void run() {
		// 방법1 => sleep()메서드나 join()메서드를 사용했을 때
		//		   interrupt()메서드를 호출하면 InterruptedException이 발생한다
		//		   이것을 이용하기 
		try {
			while(true) {
				System.out.println("스레드 처리 중...");
				Thread.sleep(1);
			}
		}catch(InterruptedException ex) {}
		
		System.out.println("자원 정리 중...");
		System.out.println("실행 종료.");
	}
}