package day33.ref;

import java.lang.annotation.Annotation;
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
			
			// 해당 메서드의 파라미터타입 정보 가져오기
			Class<?>[] paramArr = m.getParameterTypes();
			System.out.println("메서드 파라미터 타입 : ");
			for(Class<?> clazz : paramArr) {
				System.out.print(clazz.getName() + " | ");
			}
			System.out.println();
			
			// 해당 메서드에서 던지는 예외타입 가져오기
			Class<?>[] exTypeArr = m.getExceptionTypes();
			System.out.println("메서드에서 던지는 예외타입 목록 : ");
			for(Class<?> clazz : exTypeArr) {
				System.out.print(clazz.getName() + " | ");
			}
			System.out.println();
			
			// 해당 메서드에 존재하는 Annotation 타입 정보 가져오기
			Annotation[] annos = m.getAnnotations();
			System.out.println("Annotation 타입 : ");
			for(Annotation anno : annos) {
				System.out.print(anno.annotationType().getName() + " | ");
			}
			System.out.println();
			System.out.println("---------------------------------");
		}
	}
}