package day14.exam04;

public class ClassExample {
	public static void main(String[] args) throws Exception {
		
		//첫번째 방법
		Class clazz = Car.class;
		
		//두번째 방법
		//Class clazz = Clas.forName("sec01.exam04.Car");
		
		//세번째 방법
		//Car car = new Car();
		//Class clazz = car.getClass();
		
		System.out.println(clazz.getName());
		System.out.println(clazz.getSimpleName());
		System.out.println(clazz.getPackage().getName());
		
	}
}