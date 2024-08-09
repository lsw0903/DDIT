package homework;

import java.util.Arrays;

public class Hw7 {
	public static void main(String[] args) {
		
		int[][] score = {{34, 67, 89, 23, 12},
				         {56, 23, 45, 67, 78},
				         {56, 44, 34, 21, 90},
				         {67, 34, 66, 78, 98},
				         {56, 67, 90, 56, 12}};
		
		for(int i=0; i<score.length; i++) {
			System.out.println(Arrays.toString(score[i]));
		}
		
		int cnt = 0;
		int sum = 0;
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				cnt += score[i][j];
			}
			System.out.println((i+1) + "번째 가로줄의 합 : " + cnt);
			cnt = 0;
		}
		
		System.out.println();
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				cnt += score[j][i];
			}
			System.out.println((i+1) + "번째 세로줄의 합 : " + cnt);
			cnt = 0;
		}
		
		System.out.println("");
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				cnt += score[j][i];
			}
		}
		System.out.println("가로,세로 줄의 총합 : " + cnt);
	}
}