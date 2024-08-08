package day04;

public class BreakExample {
	public static void main(String[] args) {
		
		int num = 0;
		
		do {
			num = (int) (Math.random() * 6) + 1;
			
			System.out.println(num);
			
		} while(num != 6);
		
		System.out.println("프로그램 종료");
	}

}
