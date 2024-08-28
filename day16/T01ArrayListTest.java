package day16;

import java.util.ArrayList;
import java.util.List;

public class T01ArrayListTest {
	public static void main(String[] args) {
		//Default Capacity 10;
		//ArrayList도 내부적으로 배열이 데이터를 인덱스로 관리하듯 인덱스로 객체를 관리한다.
		//그렇기 때문에 배열처럼 사이즈를 통해 메모리를 예약해야 하는데 기본은 10이다.
		//List list1 = new ArrayList(100); 처럼 직접 지정할 수 있다.
		
		List list1 = new ArrayList();
		
		//List는 Colletion 인터페이스를 따르기 때문에 모든 List는 아래의 메서드를 가지고 있다.
		//add() method를 이용해서 데이터를 추가한다.
		list1.add("aaa"); //모두 객체이다. auto Boxing이 되어 있는 상태.
		list1.add("bbb");
		list1.add(111);
//		list1.add(Integer.valueOf(111)); -> 위와 같다.
		list1.add('k');
		list1.add(true);
		list1.add(12.34);
		
		//size() -> 데이터의 개수
		System.out.println("size: " + list1.size());
		System.out.println("list1: " + list1);

		
		//get() method를 이용해 데이터 꺼내오기
		//get()은 매개변수로 인덱스를 요구한다.
		//해당 인덱스의 객체를 깨내온다.
		System.out.println("1번째 데이터: " + list1.get(0));
		
		//데이터 끼워넣기도 같다.
		//현재 인덱스 0에 데이터가 있어도 끼워 넣기가 가능하다.
		//add(index, data)를 이용한다.
		list1.add(0, "zzz"); //add 메서드가 over load 되어 있는 상태.
		System.out.println("list1: " + list1);
		
		//set() method를 이용해서 데이터 변경하기
		//수정을 하는 메서드로 매개변수로 index와 새로운 data를 요구한다.
		//set(index, new data)를 하면 old data를 반환하는데
		//이를 현재 temp에 담아놓은 상태이다.
		//따라서 List 객체의 0번째 객체는 YYY로 바뀌어 있고 zzz는 temp에 담아놨다.
		String temp = (String) list1.set(0, "YYY");
		System.out.println("temp: " + temp);
		System.out.println("list1: " + list1);
		
		//remove() method를 이용해서 데이터 삭제하기
		//remove(index)를 통해서 index로 객체에 접근해 해당 객체를 삭제할 수 있다.
		list1.remove(0);
		System.out.println("데이터 삭제 후: " + list1);
		
		//아래처럼 해당 객체를 직접 적어 해당하는 객체를 삭제할 수 있다.
		list1.remove("bbb");//객체를 직접 적어 삭제하는 모습
		System.out.println("bbb 삭제 후: " + list1);
		System.out.println("===========================================");
		
		//객체를 다시한번 삭제해보자
		System.out.println("<111 데이터 삭제하기>");
//		list1.remove(111); ->  java.lang.IndexOutOfBoundsException
		//나는 int 타입 111 객체를 제거하고 싶었는데 remove는 이 메서드의 매개변수를 index로 판단함.
		//따라서 111 index는 없다는 오류를 반환
		
		//따라서 아래와 같이 객체를 지워야 한다.
		list1.remove(Integer.valueOf(111));
		System.out.println("list1: " + list1);
		
		////////////////////////////////////////////////////////////////////////////
		
		//제너릭을 지정하여 선언할 수 있다.
		//제너릭: <> 안에 들어있는 거....
		//list 안에 담고있는 데이터를 아래처럼 String. 특정 타입으로 지정할 수 있다.
		System.out.println("================제너릭 사용예==================");
		List<String> list2 = new ArrayList<String>();
		
		list2.add("AAA");
		list2.add("BBB");
		list2.add("CCC");
		list2.add("DDD");
		list2.add("EEE");
//		list2.add(111); -> 제너릭이 String 이기 때문에 int타입 객체는 넣을 수 없다.
		
		//배열처럼 enhanced for 사용 가능.
		for(String a: list2) {
			System.out.println(a);
		}
		System.out.println(list2); //이렇게도 당연히 출력가능
		System.out.println("===========================================");
		
		//contains(비교객체) -> 리스트에 비교객체가 있으면 true, 없으면 false 반환
		//파라미터로 넣은 비교객체가 있는지 확인
		System.out.println(list2.contains("DDD"));
		System.out.println(list2.contains("ZZZ"));
		
		//indexOf(비교객체) -> 리스트에 비교객체를 찾아 비교객체가 존재하는 인덱스 값을 반환
		//존재하지 않으면 -1을 반환.
		System.out.println("DDD의 index: " + list2.indexOf("DDD"));
		System.out.println("ZZZ의 index: " + list2.indexOf("ZZZ"));
		
		//ArrayList 삭제 처리
		System.out.println("================list2 삭제==================");
		System.out.println("<list2를 for를 통해  삭제>");
		for (int i = 0; i < list2.size(); i++) { //일반 배열처럼 .length가 아니라 .size()
			list2.remove(i);
		}
		System.out.println("List 삭제 처리 후 데이터 개수: " + list2.size());
		//다 i로 접근해 i번째 인덱스 객체를 다 지웠는데 list2.size()는 2가 반환됨
		//ArrayList의 특징
		//ArrayList의 0번 인덱스 객체를 지우면 인덱스 1번이 0번이 되기 때문이다.
		//따라서 리스트를 삭제할때 for문을 가장 뒤쪽 인덱스부터 지우거나.
		//clear 메서드를 사용한다.
		System.out.println("<list2.clear() 사용>");
		list2.clear();
		System.out.println("list2" + list2);
	}
}
