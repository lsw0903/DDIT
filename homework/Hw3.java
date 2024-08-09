package homework;

import java.util.Scanner;

public class Hw3 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		
		while(true) {
			int a = sc.nextInt();
			sum += a;
			if(a == 0) {
				break;
			}
		} 
		System.out.println("총합 = " + sum);
	}	
}