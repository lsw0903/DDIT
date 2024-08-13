package homework;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EnglishWordMix {
	public static void main(String[] args) {
			
		String[] arr = new String[10];
		int size = arr.length;
		
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<size; i++) {
			System.out.printf("단어를 입력하세요 : ");
			arr[i] = sc.next();
		}
		
		for(int i=0; i<size; i++) {
			if(i == 0) {
				System.out.print("[");
				System.out.printf(arr[i] + ", ");
			}
			else if(i < size-1) {
				System.out.printf(arr[i] + ", ");
			}
			else {
				System.out.printf(arr[i] + "]\n\n");
			}
		}
		
		int random = (int)(Math.random()*9 + 1);
		
		for(int j=0; j<2; j++) {
		for(int i=0; i<10; i++) {
		String temp = arr[i]; arr[i] = arr[random];
		arr[random] = temp;
		System.out.println("결과 : " + Arrays.deepToString(arr));
		}
		
		System.out.printf("결과 : " + Arrays.deepToString(arr));
		
	}
	}
}