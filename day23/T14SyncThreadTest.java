package day23;

public class T14SyncThreadTest {
	public static void main(String[] args) {
		
		ShareObject shareObj = new ShareObject();
		WorkerThread wTh1 = new WorkerThread(shareObj);
		WorkerThread wTh2 = new WorkerThread(shareObj);
		
		wTh1.start();
		wTh2.start();
		
	}
}

// 공유객체를 위한 클래스
class ShareObject {
	
	private int sum;
	
	// 동기화 하는 방법1 : 메서드 자체에 동기화 설정하기
	//public synchronized void add() { 		// return 타입 앞에 붙여도 상관없다.
	public void add() {
		// 동기화 하는 방법2 : 동기화 블럭을 이용하여 설정하기
		// mutex => Mutual exclusion(상호배제 : 동시접근 차단)
		synchronized (this) {
			
			for(int i=0; i<1000000000; i++) {}
	
			int n = sum;
			
			n += 10;
				
			sum = n;
				
			System.out.println(Thread.currentThread().getName() 
						                + " 합계 : " + sum);
		}
	}
}

// 작업을 수행할 스레드
class WorkerThread extends Thread {
	private ShareObject sObj;
	
	public WorkerThread(ShareObject sObj) {
		this.sObj = sObj;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; i++) {
			synchronized (sObj) {
				sObj.add();
			}
		}
	}
}