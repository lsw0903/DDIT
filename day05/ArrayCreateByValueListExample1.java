package day05;

public class ArrayCreateByValueListExample1 {
	public static void main(String[] args) {
		
		/* 실제 데이터를 직접 넣어서 배열을 생성하는 방법
		 * int[] scores = { 83, 90, 87 };
		 */
		
		int[] scores = new int[3];
		scores[0] = 83;
		scores[1] = 90;
		scores[2] = 87;
		
		// 배열 데이터 접근하기
		System.out.println("scores[0] : " + scores[0]);
		System.out.println("scores[1] : " + scores[1]);
		System.out.println("scores[2] : " + scores[2]);
		
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		System.out.println("총합 : " + sum);
		double avg = (double) sum / 3;
		System.out.println("평균 : " + avg);
	}

}
