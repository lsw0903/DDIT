package day16;

import java.util.Arrays;

public class SelectionSortEx {
	public static void main(String[] args) {
		//new int array
		int[] intArr = {9,8,7,6,5,4,3,2,1};
		
		System.out.println("정렬 전: ");
		System.out.println(Arrays.toString(intArr));
		System.out.println("---------------------------");

		
		//bubble sort
		bubbleSort(intArr);
		
		
		System.out.println("정렬 후: ");
		System.out.println(Arrays.toString(intArr));
		
	}

	private static void bubbleSort(int[] intArr) {
		for (int i = 0; i < intArr.length -1; i++) {
			for (int j = 0; j < intArr.length-1-i; j++) {
				if (intArr[j] >= intArr[j+1]) {
					//swapping 
					int temp = intArr[j];
					intArr[j] = intArr[j+1];
					intArr[j+1] = temp;
				}
				System.out.println(Arrays.toString(intArr));
			}
			System.out.println("---------------------------");
		}
	}
}
