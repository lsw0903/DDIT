package homework;

import java.util.Scanner;

public class Hw5 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int a = sc.nextInt();
		    int b = sc.nextInt();
		    
		    if(a+b>=100) {
		    	System.out.print(a +" "+ b + "  ");
				System.out.println(a + b);
				}
		    else if((a+b<100) && ((a!=0)&&(b!=0))) {
				System.out.println(a +" "+ b);
				}
			else if((a==0) && (b==0)) {
				break;
				}
		} 
	}
}