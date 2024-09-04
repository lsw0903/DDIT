package day21;

import javax.swing.JOptionPane;

/*
 * 멀티스레드를 활용한 카운트다운 처리예제
 */
public class T06ThreadTest {
	
	// 사용자 입력이 완료되었는지 확인하기 위한 변수선언
	public static boolean inputCheck = false;
	
	public static void main(String[] args) {
		Thread th1 = new DataInput();
		Thread th2 = new CountDown();
		
		th1.start();
		th2.start();
	}
}

// 데이터 입력받는 스레드
class DataInput extends Thread {
	 @Override
	 public void run() {
		 String str = JOptionPane
					.showInputDialog("아무거나 입력하세요");
		 
		 T06ThreadTest.inputCheck = true;
		 
		 System.out.println("입력한 값은 " + str + "입니다.");
	 }
}

// 카운트다운 처리를 위한 스레드
class CountDown extends Thread {
	@Override
	public void run() {
		for(int i=10; i>=1; i--) {
			
			if(T06ThreadTest.inputCheck) {
				return; // run()메서드 종료
			}
			
			System.out.println(i);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}