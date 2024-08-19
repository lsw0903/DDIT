package day10;

public class T03CarExample {
	public static void main(String[] args) {
		
		T03Car car = new T03Car(); //Car 객체 생성
		
		for(int i=1; i<=5; i++) {
			int problemLocation = car.run(); //Car 객체의 run() 메소드 5번 반복 실행
			
			switch(problemLocation) {
			case 1 :
				System.out.println("앞왼쪽 HankookTire로 교체");
				car.frontLeftTire = new T03HankookTire("앞왼쪽", 15);
				break; //앞왼쪽 타이어가 펑크 났을 때 HankookTire로 교체
			case 2 :
				System.out.println("앞오른쪽 KumhoTire로 교체");
				car.frontRightTire = new T03KumhoTire("앞오른쪽", 13);
				break; //앞오른쪽 타이어가 펑크 났을 때 KumhoTire로 교체
			case 3 :
				System.out.println("뒤왼쪽 HankookTire로 교체");
				car.backLeftTire = new T03HankookTire("뒤왼쪽", 14);
				break; //뒤왼쪽 타이어가 펑크 났을 때 HankookTire로 교체
			case 4 :
				System.out.println("뒤오른쪽 KumhoTire로 교체");
				car.backRightTire = new T03KumhoTire("뒤오른쪽", 17);
				break; //뒤오른쪽 타이어가 펑크 났을 때 KumhoTire로 교체
			}
			System.out.println("-----------------------"); //1회전시 출력되는 내용을 구분
		}
	}

}
