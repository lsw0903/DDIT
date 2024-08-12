package homework;

import java.util.Scanner;
import java.util.TreeSet;

public class Lotto {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

        int money = 0;

        while(true) {
            System.out.println("==========================");
            System.out.println("Lotto 프로그램");
            System.out.println("--------------------------");
            System.out.println("1. Lotto 구입");
            System.out.println("2. 프로그램 종료");
            System.out.println("==========================");
            System.out.print("메뉴선택 : ");

            int num = sc.nextInt();

            switch(num){
                case 1:
                    System.out.println("\nLotto 구입 시작\n");
                    System.out.println("(1000원에 로또번호 하나입니다.)");
                    System.out.print("금액 입력 : ");
                    money = sc.nextInt();

                    if(money > 1000){
                        System.out.println("\n행운의 로또번호는 아래와 같습니다.");

                        for(int i = 1; i < money/1000 + 1; i++){
                            TreeSet<Integer> lotto = new TreeSet<>();

                            while(lotto.size() < 6){
                                //1~45사이의 난수 만들기
                                int num2 = (int)(Math.random() * 45 + 1);
                                lotto.add(num2);
                            }

                            System.out.println("로또번호"+ i +" : " + lotto);

                        }

                        System.out.println("\n받은 금액은 "+ money + "원이고 거스름돈은 " + (money%1000) + "원입니다.\n");

                    }
                    break;

                case 2:
                    System.out.println("\n감사합니다.");
                    return;

                default:
                    System.out.println("\n잘못된 입력입니다.\n");
            }
        }
    }
}