package day23;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 은행의 입출금을 스레드로 처리하는 예제
 * (Lock 객체를 이용한 동기화 처리)
 */
public class T16LockAccountTest {
	public static void main(String[] args) {
		
		/*
		 	ReentrantLock : Read 및 Write 구분없이 사용하기 위한
		 	                락 클래스로 동기화 처리를 위해 사용된다.
		 	                Synchronized를 이용한 동기화 처리보다 부가적인 기능이 제공됨.
		 		ex) Fairness 설정 => 가장 오래 기다린 스레드가 가장 먼저 락을 획득하게 한다.
		 */
		
		ReentrantLock lock = new ReentrantLock(true);
		
		LockAccount lAcc = new LockAccount(lock);
		lAcc.deposit(10000);
		
		BankThread2 bTh1 = new BankThread2(lAcc);
		BankThread2 bTh2 = new BankThread2(lAcc);
		
		bTh1.start();
		bTh2.start();
		
	}
}

// 입출금 처리용 공유객체
class LockAccount {
	
	// Lock객체를 위한 변수 => private final로 선언한다.
	private final Lock lock;
	
	private int balance;
	
	public LockAccount(Lock lock) {
		this.lock = lock;
	}

	public int getBalance() {
		return balance;
	}
	
	public void deposit(int money) {
	/*
	 	Lock객체의 lock() 메서드가 동기화 시작이고,
	 	unlock()메서드가 동기화의 끝을 나타낸다.
	 	lock()메서드로 동기화를 설정한 곳에서는 반드시 unlock()메서드로
	 	해제 해 주어야 한다.
	 */
		lock.lock(); // 락 설정(락을 획득하기 전까지 BLOCKED 됨)
		balance += money;
		lock.unlock(); // 락 해제
	}
	
	public boolean withdraw(int money) {
		boolean chk = false;
		
		// try~catch 블럭을 사용할 경우에는
		// unlock()메서드 호출을 finally 블럭에서 해주어야 한다.
		try {
			lock.lock(); // 락 설정
			
			if(balance >= money) {	// 잔액이 충분한 경우...
				for(int i=0; i<=1000000000; i++) {};
				balance -= money;
				System.out.println("메서드 안에서 balance = " + getBalance());
			    chk = true;
			}
			
			//lock.unlock();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			lock.unlock(); // 락 해제
		}
		
		return chk;
	}
}

//은행 업무를 처리하는 스레드
class BankThread2 extends Thread {
	private LockAccount lAcc;
	public BankThread2(LockAccount lAcc) {
		this.lAcc = lAcc;
	}
	
	@Override
	public void run() {
		boolean result = lAcc.withdraw(6000); // 6000원 인출
		System.out.println("스레드 안에서 result = " + result 
				              + ", balance = " + lAcc.getBalance());
	}
}