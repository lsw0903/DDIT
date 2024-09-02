package day20;

import java.util.ArrayList;
import java.util.List;

public class T04WildCardTest {
/*
  		와일드 카드(?)에 대하여..
  		
  		와일드카드는 제너릭 타입을 이용한 타입 안전한 코드를 위해 사용되는 특별한 종류의
  		인수(Argument)로서, 변수선언, 객체생성 및 메서드 정의할 때 사용된다.
  		
  		<? extends T> ==> 와일드카드의 상한 제한. T와 그 자손들만 가능
  		<? super T>   ==> 와일드카드의 하한 제한. T와 그 조상들만 가능
  		<?>			  ==> 허용가능한 모든타입 가능
 */
	public static void main(String[] args) {
		
		List<?> myList = new ArrayList<Integer>();
		
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());
		
		System.out.println(fruitBox.getFruitList());
		
		appleBox.add(new Apple());
		appleBox.add(new Apple());
		
		Juicer.makeJuice(fruitBox);
		Juicer.makeJuice(appleBox);
		
	}
}

class Juicer {
  //public static <T extends Fruit> void makeJuice(FruitBox<T> box) {
	public static void makeJuice(FruitBox<?> box) {
		
	
		String fruitListStr = "";	// 과일목록
		
		int cnt = 0;
		for(Object obj : box.getFruitList()) {
			if(cnt == 0) {
				fruitListStr += obj;
			}else {
				fruitListStr += ", " + obj;
			}
		}
		
		System.out.println(fruitListStr + " => 쥬스 완성!");
		
	}
}

class Fruit {
	private String name; // 과일이름
	
	public Fruit(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "과일(" + name + ")";
	}
	
}

class Apple extends Fruit {

	public Apple() {
		super("사과");
		
	}
}

class Grape extends Fruit {
	
	public Grape() {
		super("포도");
	}
}

class FruitBox<T> {
	private List<T> fruitList;
	
	public FruitBox() {
		fruitList = new ArrayList<>();
	}

	public List<T> getFruitList() {
		return fruitList;
	}
	
	public void add(T fruit) {
		fruitList.add(fruit);
	}
}