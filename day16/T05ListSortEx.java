package day16;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import day16.Desc;

public class T05ListSortEx {
	public static void main(String[] args) {
		/*
		 * 정렬과 관련된 interfaces: Comparable Comparator
		 * 
		 * - 보통 객체 자체에 정렬기능을 구현하기 위해서는 Comparable 사용
		 * - 정렬 기준을 별도로 구현하고 싶을 때에는 Comparator 사용
		 * 
		 * - Comparable 에서는 compareTo() 메서드를 구현해야 한다
		 * - Comparator 에서는 compare() 메서드를 구현해야 한다
		 */
		
		List<String> list = new ArrayList<String>();
		list.add("일지매");
		list.add("홍길동");
		list.add("성춘향");
		list.add("변학도");
		list.add("이순신");
		System.out.println("정렬 전 list: " + list);
		
		Collections.sort(list); //정렬시키기
		
	    System.out.println("정렬 후 list: " + list);
	    
	    Collections.shuffle(list);
	    
	    System.out.println("섞은 후 : " + list);
	    
	    /*
	     * 정렬방식을 변경하려면 정렬방식을 결정하는 객체를 생성해서
	     * Collection.sort() 메서드의 파라미터값으로 넣어주면 된다.
	     */
	        
	    Collections.sort(list,new Desc());
		
	}
}

// 문자열을 내림차순으로 정렬시키기 위한 외부정렬자 클래스
class Desc implements Comparator<String> {
	
	/*
	  compare()메서드의 반환값을 결정하는 방법
	  
	  - 오름차순 정렬일 경우...
	  => 앞의 값이 크면 양수, 같으면 0, 앞의 값이 작으면 음수를 반환하도록 구현한다.
	 */
	
	@Override
	public int compare(String str1, String str2) {
		
		return str1.compareTo(str2) * -1;
	}
	
}