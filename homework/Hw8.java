package homework;

public class Hw8 {
	public static void main(String[] args) {
		
		 int[][] array = {
	                {78, 89, 67},
	                {45, 67, 77},
	                {89, 99, 90},
	                {96, 56, 78},
	                {89, 67, 89}
	        };

	        int[] a = new int[5];
	        double[] b = new double[5];

	        for (int i = 0; i < 5; i++) {
	            int sum = 0;
	            for (int j = 0; j < 3; j++) {
	                sum += array[i][j];
	            }
	            a[i] = sum;
	            b[i] = sum / 3.0;
	        }

	        Object[][] result = new Object[5][2];
	        for(int i = 0; i < 5; i++) {
	            result[i][0] = a[i];
	            result[i][1] = b[i];
	        }

	        System.out.printf("무궁화의 총점 : %d 평균 : %.2f\n", result[0][0], result[0][1]);
	        System.out.printf("개나리의 총점 : %d 평균 : %.2f\n", result[1][0], result[1][1]);
	        System.out.printf("진달래의 총점 : %d 평균 : %.2f\n", result[2][0], result[2][1]);
	        System.out.printf("수선화의 총점 : %d 평균 : %.2f\n", result[3][0], result[3][1]);
	        System.out.printf("라일락의 총점 : %d 평균 : %.2f\n", result[4][0], result[4][1]);
	    }
}