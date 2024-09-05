package day23;

public class T13ThreadShareDataTest {
	public static void main(String[] args) {
		
		ShareData sd = new ShareData();
		
		CalcPIThread cTh = new CalcPIThread(sd);
		PrintPIThread pTh = new PrintPIThread(sd);
		
		cTh.start();
		pTh.start();
	}
}

// 원주율 정보를 관리하기 위한 클래스
class ShareData {
	private double result; // 계산된 원주율 저장할 변수
	
	// 원주율 계산이 완료되었는지 확인하기 위한 변수
	volatile private boolean isOk;
	
	/*
	 	volatile => 선언된 변수를 컴파일러의 최적화 대상에서 제외시킨다.
	 				즉, 값이 변경되는 즉시 변수에 적용시킨다.
	 				멀티스레드에서 하나의 변수가 완벽하게 한번에 작동하도록
	 				보장하는 키워드(일종의 동기화)
	 */

	public double getResult() {
		return result;
	}

	public void setResult(double result) {
		this.result = result;
	}

	public boolean isOk() {
		return isOk;
	}

	public void setOk(boolean isOk) {
		this.isOk = isOk;
	}
}


// 원주율을 계산하는 스레드
class CalcPIThread extends Thread {
	private ShareData sd;
	
	public CalcPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
	/*
	 	원주율 = (1/1 - 1/3 + 1/5 - 1/7 + 1/9 .....) * 4;
	 			  1  -  3  +  5  -  7  +  9  ==> 분모
	 			  0		1	  2 	3 	  4  ==> 2로 나눈 몫
	 */
		double sum = 0.0;
		for(int i=1; i<=15000000; i+=2) {
			if(((i/2) % 2) == 0 ) { // 2로 나눈 몫이 짝수이면..
				sum += (1.0/i);
			}else {
				sum -= (1.0/i);
			}
		}
		sd.setResult(sum * 4); // 원주율 저장
		sd.setOk(true); // 계산이 완료되었음을 나타냄.
	}
}

// 계산된 원주율을 출력하기 위한 스레드
class PrintPIThread extends Thread {
	private ShareData sd;
	
	public PrintPIThread(ShareData sd) {
		this.sd = sd;
	}
	
	@Override
	public void run() {
		while(true) {
			// 원주율 계산이 완료될 때까지 기다린다.
			if(sd.isOk()) {
				break;
			}
		}
		
		System.out.println();
		System.out.println("계산된 원주율 : " + sd.getResult());
		System.out.println("        PI : " + Math.PI);
	}
}