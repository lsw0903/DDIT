package day21;

public class T04ThreadTest {
	public static void main(String[] args) {
	/*
	 	 1~20억 까지의 합계를 구하는 데 걸린 시간 체크해 보기
	 	 전체 합계를 구하는 작업을 단일 스레드로 처리했을 때와
	 	 여러 스레드를 분할해서 처리했을 때의 걸린 시간 확인해 보기
	 */
		// 단일 스레드를 이용한 합계 구하기
		Thread th1 = new SumThread(1L, 2000000000);
		
		long startTime = System.currentTimeMillis();
		
		th1.start();
		
		try {
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		long endTime = System.currentTimeMillis();
		
		System.out.println("단일 스레드를 이용한 처리시간 : " 
		                      + (endTime - startTime) + " (ms)");
		
		/////////////////////////////////////////////////////////
		
		// 여러 스레드가 협력해서 처리 했을 때
		Thread[] sumThs = new Thread[] {
				new SumThread(         1L,  500000000L),
				new SumThread( 500000001L, 1000000000L),
				new SumThread(1000000001L, 1500000000L),
				new SumThread(1500000001L, 2000000000L),
		};
		
		startTime = System.currentTimeMillis();
		
		for(Thread th : sumThs) {
			th.start();
		}
		
		for(Thread th : sumThs) {
			try {
				th.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		endTime = System.currentTimeMillis();
		
		System.out.println("협력 처리 했을때의 처리시간 : " 
		                     + (endTime - startTime) + " (ms)");
		
	}
}
// 범위값 합게를 구하기 위한 스레드
class SumThread extends Thread {
	
	private long min, max;
	
	public SumThread(long min, long max) {
		this.min = min;
		this.max = max;
	}
	
	@Override
	public void run() {
		long sum = 0;
		for(long i=min; i<=max; i++) {
			sum += i;
		}
		System.out.println(min + " ~ " + max + "까지의 합 : " + sum);
	}
}