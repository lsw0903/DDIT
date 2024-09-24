package day33.ref;

import java.lang.reflect.Method;

/*
	클래스에 선언된 메서드의 메타정보 가져오기
*/
public class T03MethodMetadataTest {
	public static void main(String[] args) {
		
		Class<?> klass = SampleVO.class;
		
		// 클래스에 선언된 모든 메서드의 메타데이터 정보 가져오기
		Method[] methodArr = klass.getDeclaredMethods();
		
		for(Method m : methodArr) {
			System.out.println("메서드명 : " + m.getName());
			System.out.println("메서드 리턴타입 : " + m.getReturnType());
			
		}
	}
}