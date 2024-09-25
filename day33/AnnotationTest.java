package day33;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationTest {
	public static void main(String[] args) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		
		System.out.println("상수값 접근하기 : " + PrintAnnotation.id);
		
		// Reflection API를 이용하여 메서드 정보 가져오기
		Method[] methodArr = Service.class.getDeclaredMethods();
		
		for(Method m : methodArr) {
			System.out.println(m.getName()); // 메서드명
			
			Annotation[] annos = m.getAnnotations();
			for(Annotation anno : annos) {
				//System.out.println(anno.annotationType().getSimpleName());
				if(anno.annotationType().getSimpleName()
						.equals("PrintAnnotation")) {
					PrintAnnotation printAnno = (PrintAnnotation) anno;
					
					//System.out.println(printAnno.count());
					//System.out.println(printAnno.value());
					for(int i=0; i<printAnno.count(); i++) {
						System.out.print(printAnno.value());
					}
				}
			}
			System.out.println();
			
			//m.invoke(new Service());
			
			Class<?> clazz = Service.class;
			Service svc = (Service) clazz.newInstance();
			m.invoke(svc);
			
		}
	}
}