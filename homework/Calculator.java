package homework;

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("=====계산기 프로그램=====\n");
			
		do {
			System.out.println("메뉴를 선택하세요.");
			System.out.println("1. 더하기연산");
			System.out.println("2. 뺴기연산");
			System.out.println("3. 곱하기연산");
			System.out.println("4. 나누기연산");
			System.out.println("0. 프로그램 종료");
			System.out.print("번호입력 >> ");
			int a = sc.nextInt();
			
			if(a == 1) {
				System.out.printf("더하기 연산을 위한 두 수를 입력하세요.\n입력 >> ");
				int b = sc.nextInt();
				int c = sc.nextInt();
				System.out.println("== 연산결과 출력 ==");
				System.out.println(b + " + " + c + " = " + (b+c) +"\n");
				}
			
			else if(a == 2) {
				System.out.printf("빼기 연산을 위한 두 수를 입력하세요.\n입력 >> ");
				int b = sc.nextInt();
				int c = sc.nextInt();
				System.out.println("== 연산결과 출력 ==");
				System.out.println(b + " - " + c + " = " + (b-c) +"\n");
				}
			
			else if(a == 3) {
				System.out.printf("곱하기 연산을 위한 두 수를 입력하세요.\n입력 >> ");
				int b = sc.nextInt();
				int c = sc.nextInt();
				System.out.println("== 연산결과 출력 ==");
				System.out.println(b + " * " + c + " = " + (b*c) +"\n");
				}
			
			else if(a == 4) {
				System.out.printf("나누기 연산을 위한 두 수를 입력하세요.\n입력 >> ");
				int b = sc.nextInt();
				int c = sc.nextInt();
				System.out.println("== 연산결과 출력 ==");
				System.out.println(b + " / " + c + " = " + (b/c) +"\n");
				}
			
			else if(a == 0) {
				System.out.println("프로그램을 종료합니다...");
				break;
				}	
			
		} while(true); 	
	}
}