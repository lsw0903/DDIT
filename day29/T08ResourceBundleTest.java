package day29;

import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;

public class T08ResourceBundleTest {
	public static void main(String[] args) {
	/*
	 	ResourceBundle 객체를 이용하여 파일 읽어오기
	 	
	 =>	ResourceBundle 객체 생성시 파일을 지정할 때에는 '파일명'만
	 	지정하고 확장자는 지정하지 않는다.(항상 properties 이기 때문)
	 	해당 파일은 클래스패스(classpath)에 존재해야 한다.
	*/
		ResourceBundle bundle = ResourceBundle.getBundle("db", Locale.JAPANESE);
		                                                       // 로컬설정가능
		
		// 모든 키값들만 읽어오기
		Enumeration<String> keys = bundle.getKeys();
		while(keys.hasMoreElements()) {
			String key = keys.nextElement();
			String value = bundle.getString(key);
			
			System.out.println(key + " => " + value);
		}
		
		
		
		System.out.println("출력 끝...");
	}
}