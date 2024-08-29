package day18;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class T10HashMapTest {
	public static void main(String[] args) {
		
		Map<String, String> map = new HashMap<String,String>();
		
		// 데이터 추가하기 ==> put(key값, value값)
		map.put("name", "홍길동");
		map.put("addr", "대전");
		map.put("tel", "010-1234-5678");
		
		System.out.println("map => " + map);
		
		// 데이터 수정하기
		//  ==> 데이터를 저장(추가)할 때 key값이 같으면 나중에 입력한 값이 저장된다.
		map.put("addr", "서울");
		System.out.println("map => " + map);
		
		// 데이터 삭제하기 ==> remove(삭제할 key값)
		map.remove("name");
		System.out.println("map => " + map);
		
		// 데이터 읽기 ==> get(key값)
		System.out.println("addr = " + map.get("addr"));
		System.out.println("======================================");
		
		// key값들을 읽어와 자료를 출력하는 방법
		
		// 방법1 ==> keySet()메서드 이용하기
		//      ==> Map의 key값들만 읽어와 Set형으로 반환
		Set<String> keySet = map.keySet();
		
		System.out.println("Iterator를 이용한 방법");
		
		Iterator<String> it = keySet.iterator();
		
		while(it.hasNext()) {
			String key = it.next();
			System.out.println(key + " : " + map.get(key));
		}
		
		System.out.println("----------------------------------");
		
		// 방법2 ==> Set형의 데이터를 '향상된 for문'으로 처리하면
		//		    Iterator를 사용하지 않아도 된다.
		System.out.println("향상된 for문을 이용한 방법");
		for(String key : keySet) {
			System.out.println(key + " : " + map.get(key));
		}
		System.out.println("----------------------------------");
		
		// 방법3 ==> value값만 읽어와 출력하기 => values() 이용
		System.out.println("values() 메서드 이용한 방법");
		for(String value : map.values()) {
			System.out.println(value);
		}
		System.out.println("----------------------------------");
		
		// 방법4 ==> Map.Entry 타입의 객체를 모두 가져와 처리하기
		System.out.println("entrySet()을 이용한 방법");
		
		Set mapSet = map.entrySet();
		
		// 가져온 Entry 객체들을 순서대로 처리하기 위해 Iterator 이용
		Iterator entryIt = mapSet.iterator();
		
		while(entryIt.hasNext()) {
			Map.Entry entry = (Map.Entry) entryIt.next();
			
			System.out.println("key 값 : " + entry.getKey());
			System.out.println("value 값 : " + entry.getValue());	
		}
	}
}