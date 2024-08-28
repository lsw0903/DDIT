package day17;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class T07HashSetTest {
	public static void main(String[] args) {
		
		Set hs1 = new HashSet();
		
		// Set에 데이터를 추가할 때에도 add()메서드 이용한다.
		hs1.add("DD");
		hs1.add("AA");
		hs1.add(2);
		hs1.add("CC");
		hs1.add("BB");
		hs1.add(1);
		hs1.add(3);
		
		System.out.println("Set 데이터 : " + hs1);
		System.out.println();
		
		// Set은 데이터의 순서(인덱스) 개념을 사용하지 않고 ,
		// 데이터의 중복을 허용하지 않는다. 그래서, 기존의 데이터가
		// 이미 존재하면 데이터는 추가되지 않는다
		boolean isAdded = hs1.add("FF");
		System.out.println("중복되지 않을 때 : " + isAdded);
		System.out.println("Set 데이터 : " + hs1);
		System.out.println();
		
		isAdded = hs1.add("CC");
		System.out.println("중복될 때 : " + isAdded);
		System.out.println("Set 데이터 : " + hs1);
		System.out.println();
		
		/*
		 	Set의 데이터를 수정하려면 수정하는 메서드가 따로 없기 때문에
		 	해당 데이터를 삭제한 후 새로운 데이터를 추가해 주어야 한다.
		 	
		 	삭제하는 메서드
		 	1) clear() = Set의 모든 데이터 삭제
		 	2) remove(삭제할데이터) => 해당 데이터 삭제
		 	
		 */
		 // 'FF'를 'EE'로 수정하기
		hs1.remove("FF");
		System.out.println("FF 삭제 후 Set 데이터 : " + hs1);
		System.out.println();
		
		hs1.add("EE");
		System.out.println("EE 추가 후 Set 데이터 : " + hs1);
		System.out.println();
		
		hs1.clear(); // 전체 데이터 삭제
		System.out.println("Set의 데이터 개수 : " + hs1.size());
		System.out.println();
		
		/*
		 	Set은 데이터의 인덱스 정보를 사용할 수 없기 때문에
		 	Iterator 객체를 이용하여 데이터에 접근한다.
		 */
		Iterator it = hs1.iterator();
		
		// hasNext() => 다음에 가져올 데이터가 있으면 true,
		//				없으면 false를 반환함.
		while(it.hasNext()) {
			// next() => 다음 데이터를 가져온다.
			System.out.println(it.next());
		}
		
		////////////////////////////////////////////////
		
		// 1~100 사이의 중복되지 않는 정수 5개 생성하기
		Set<Integer> intRnd = new HashSet<Integer>();
		
		while(intRnd.size() < 5) {
			int num = (int)(Math.random() * 100 + 1);
			intRnd.add(num);
		}
		
		System.out.println("만들어진 난수들");
		for(Integer i : intRnd) {
			System.out.println(i + " ");
		}
		System.out.println();
	}

}