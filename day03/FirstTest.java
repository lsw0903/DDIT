package day03;

public class FirstTest {
	public static void main(String[] args) {
		
		byte byteValue = 10;
		int intValue = byteValue;
		
		long longValue = 5000000000L;
		float floatValue = longValue;
		double doubleValue = longValue;
		
		System.out.println("longValue : " + longValue);
		System.out.println("floatValue : " + floatValue);
		System.out.println("doubleValue : " + doubleValue);
		
		byte byteValue2 = 65;
		//char charValu = byteValue2;
		
		byte x = 10;
		byte y = 20;
		
		int result = x + y;
		
		int intValue2 = 10;
		double doubleValue2 = 5.5;
		
		int result2 = intValue2 + (int) doubleValue2;
		
		System.out.println("result = " + result2);
		
		double result3 = 1.5 + 2.3;
		//float result4 = 1.5 + 2.3; <- 컴파일 에러
		float result5 = 1.5f + 2.3f;
		
		int x2 = 1;
		int y2 = 2;
		
		double result6 = x2 / y2;
		
		System.out.println("result6 : " + result6);
		
		String str = 3 + ""; //String.valueOf(3);
		
		System.out.print("str : " + str);
		System.out.println("str2 : " + str);
		
		System.out.printf("이름 : %s     %s, 나이 : %d", "Hello", "world!!!", 32);
	}

}