package homework;

import java.util.Scanner;

public class MultiplicationTable {
	public static void main(String[] args) {
		
System.out.print("숫자를 입력하세요 : ");
		
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		
		for(int i = a; i <= a; i++) {
			System.out.println("*** " + i + "단 ***");
			for(int n = 1; n <= 9; n++) {
				System.out.println(i + " x " + n + " = " + (i*n));
			}	
		}
	}
}