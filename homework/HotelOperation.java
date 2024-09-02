package homework;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HotelOperation {
    public static void main(String[] args) {

        Map<Integer, String> hotel = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("**************************");
        System.out.println("호텔 문을 열었습니다.");
        System.out.println("**************************");

        while (true) {
            System.out.println("\n*******************************************");
            System.out.println("어떤 업무를 하시겠습니까?");
            System.out.println("1.체크인 2.체크아웃 3.객실상태 4.업무종료");
            System.out.println("*******************************************");
            System.out.print("메뉴선택 => ");

            int menu = scanner.nextInt();

            switch (menu) {
                case 1:
                    checkin(hotel, scanner);
                    break;
                case 2:
                    checkout(hotel, scanner);
                    break;
                case 3:
                    room(hotel);
                    break;
                case 4:
                    System.out.println("\n**************************");
                    System.out.println("호텔 문을 닫았습니다.");
                    System.out.println("**************************");
                    break;
                default:
                    System.out.println("잘못 입력하였습니다.");
            }
            if (menu == 4) {
                break;
            }
        }
    }

    public static void checkin(Map<Integer, String> hotel, Scanner scanner) {
        System.out.print("\n어느방에 체크인 하시겠습니까?\n방번호 입력 => ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (hotel.containsKey(number)) {
            System.out.print("\n누구를 체크인 하시겠습니까?\n이름 입력 => ");
            String name = scanner.nextLine();
            System.out.println(number + "방에는 이미 사람이 있습니다.");
        } else {
            System.out.print("\n누구를 체크인 하시겠습니까?\n이름 입력 => ");
            String name = scanner.nextLine();
            hotel.put(number, name);
            System.out.println("체크인 되었습니다.");
        }
    }

    public static void checkout(Map<Integer, String> hotel, Scanner scanner) {
        System.out.print("\n어느방을 체크아웃 하시겠습니까?\n방번호 입력 => ");
        int number = scanner.nextInt();

        if (hotel.containsKey(number)) {
            hotel.remove(number);
            System.out.println("체크아웃 되었습니다.");
        } else {
            System.out.println(number + "방에는 체크인한 사람이 없습니다.");
        }
    }

    public static void room(Map<Integer, String> hotel) {
        if (hotel.isEmpty()) {
            System.out.println("현재 투숙객이 없습니다.");
        } else {
            for (Map.Entry<Integer, String> entry : hotel.entrySet()) {
                System.out.print("\n방번호 : " + entry.getKey() + ", 투숙객 : " + entry.getValue());
            }
        }
    }
}