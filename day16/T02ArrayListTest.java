package day16;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class T02ArrayListTest {
	public static void main(String[] args) {
		/*
		 * 문제) 5명의 사람이름을 입력받아 ArrayList에 저장한 후,
		 * 이 중에 '김'씨 성을 가진 이름을 출력하시오
		 */
		Scanner sc = new Scanner(System.in);
		List<String> nameList = new ArrayList<String>();
		
		for (int i = 1; i <= 5; i++) {
			System.out.print(i + "번째 이름: ");
			String name = sc.nextLine();
			nameList.add(name);
		}
		
		System.out.println(nameList + " 중에서");
		System.out.println("김씨 성을 가진 사람은");
		
		for (String name : nameList) {
			if (name.substring(0,1).equals("김")) {
				System.out.println(name);
			} else {
				continue;
			};
			
			
			//김씨 성을 조회하는 방법
//			if (name.indexOf("김")==0) {
//			}
			
//			if (name.charAt(0)=='김') {
//			}
			
//			if (name.startsWith("김")) {
//			}
		}
		
	}
}
