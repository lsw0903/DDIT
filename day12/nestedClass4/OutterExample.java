package day12.nestedClass4;

public class OutterExample {
	public static void main(String[] args) {
		Outter outter = new Outter();
		Outter.Nested nested = outter.new Nested(); //인스턴스 멤버 클래스 -> 바깥 객체를 통해서 만들어야 한다.
		
		nested.print();
	}
}
