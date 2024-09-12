package day28;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class T07PropertiesTest {
	public static void main(String[] args) {
	
		Properties prop = new Properties();
		
		try {
			
			FileInputStream fis = new FileInputStream("day28_res/db.properties");
			
			// properties 파일 읽기
			prop.load(fis);
			
			// 읽어온 데이터 출력하기
			
			Enumeration<String> keys = (Enumeration<String>) prop.propertyNames();
			
			while(keys.hasMoreElements()) {
				String key = keys.nextElement();
				String value = prop.getProperty(key);
				System.out.println(key + " => " + value);
			}
			
			System.out.println("출력 끝...");
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}
		
	}
}