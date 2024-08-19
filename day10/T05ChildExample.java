package day10;

public class T05ChildExample {
	public static void main(String[] args) {
		
		T05Parent parent = new T05Child(); //자동 타입 변환
		parent.field1 = "data1";
		parent.method1();
		parent.method2();
		
		/* 불가능
		 * parent.field2 = "data2";
		 * parent.method3();
		 */
		
		T05Child child = (T05Child) parent; //강제 타입 변환
		child.field2 = "yyy";
		child.method3();
	}

}
