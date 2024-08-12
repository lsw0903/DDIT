package homework;

import java.util.Random;
import java.util.Scanner;

public class RockScissorsPaper {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
        Random random = new Random();

        do {
            int computer = random.nextInt(3);
            String computerselect = " ";

            switch (computer) {
                case 0:
                    computerselect = "가위";
                    break;
                case 1:
                    computerselect = "바위";
                    break;
                case 2:
                    computerselect = "보";
                    break;
            }

            System.out.print("가위,바위,보 중 선택하세요: ");
            String userselect = sc.next();

            String result = " ";
            if (userselect.equals(computerselect)) {
                result = "비겼습니다.\n";
            } else if ((userselect.equals("가위") && computerselect.equals("보")) ||
                    (userselect.equals("바위") && computerselect.equals("가위")) ||
                    (userselect.equals("보") && computerselect.equals("바위"))) {
                result = "당신이 이겼습니다.\n";
            } else {
                result = "당신이 졌습니다.\n";
            }

            System.out.println("=== 결 과 ===");
            System.out.println("컴퓨터 : " + computerselect);
            System.out.println("당 신 : " + userselect);
            System.out.println("결 과 : " + result);

        } while (true);
    }
}