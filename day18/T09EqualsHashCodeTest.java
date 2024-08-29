package day18;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class T09EqualsHashCodeTest {
	/*
	 	해시함수(hash function)는 임의의 길이의 데이터를
	 	고정된 길이의 데이터로 매핑하는 함수이다. 해시함수를 통해 얻어지는 값은 해시값,
	 	해시코드라 부른다.
	 	
	 	HashSet, HashMap, Hashtable 과 같은 객체들을 사용할 경우
	 	객체가 서로 같은지를 비교하기 위해 equals()와 hashCode()를 호출한다.
	 	그래서 객체의 중복 여부를 결정하려면 두 메서를 재정의 해주어야 한다.
	 	중복여부 체크는 데이터를 추가할 때 검사한다.
	 	
	 	- equals()는 두 객체의 내용(값)이 같은지 비교하는 메서드이고,
	 	- hashCod()는 개체에 대한 해시코드값을 반환하는 메서드이다.
	 	 => 해시테이블 작성 및 접근시 사용됨.
	 	 
	 	- equals() 와 hashCode()메서드에 관련된 규칙
	    1. 두 객체가 같으면 반드시 같은 해시코드를 가져야 한다.
	    2. 두 객체가 같으면 equals()메서드를 호출했을떄 true를 반환해야 한다.
	       즉, 객체 a, b가 같다면 a.equals(b)와 b.equals(a) 둘 다 true 이어야 한다.
	    3. 두 객체의 해시코드가 같다고 해서 두 객체가 반드시 같은 객체는 아니다.
	       하지만, 두 객체가 같으면 반드시 해시코드가 같아야 한다.
	    4. equals() 메서드를 재정의 해야 한다면 hashCode도 재정의 해줘야 한다.
	    5. hashCode()는 기본적으로 Heap메모리에 존재하는 각 객체에 대한 메모리 주소 매핑정보를
	       기반으로 한 정수값을 반환한다.
	       그러므로, 클래스에서 hashCode()를 재정의 하지 않으면 절대로 두 객체가 같은 해시코드를
	       가질 수 없다.
	 */
	public static void main(String[] args) {
		System.out.println("Aa".hashCode());
		System.out.println("Aa".hashCode());
		
		Person p1 = new Person(1, "홍길동");
		Person p2 = new Person(1, "홍길동");
		Person p3 = new Person(1, "이순신");
		
		System.out.println("p1.equals(p2) : " + p1.equals(p2));
		System.out.println("p1 == p2 : " + (p1 ==p2));
		
		Set<Person> hSet = new HashSet<Person>();
		
		System.out.println("add(p1) 성공여부 : " + hSet.add(p1));
		System.out.println("add(p2) 성공여부 : " + hSet.add(p2));
		
		System.out.println("p1, p2 등록 후 데이터 : ");
		for(Person p : hSet) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
		System.out.println("add(p3) 성공여부 : " + hSet.add(p3));
		
		System.out.println("p3 등록 후 데이터 : ");
		for(Person p : hSet) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
		System.out.println("remove(p2) 성공여부 : " + hSet.remove(p2));
		
		System.out.println("remove(p2) 후 데이터 : ");
		for(Person p : hSet) {
			System.out.println(p.getId() + " : " + p.getName());
		}
		
	}
}
class Person {
	private int id;
	private String name;
	public Person(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id && Objects.equals(name, other.name);
	}
	
	/*
	@Override
	public boolean equals(Object obj) {
		
		Person p = (Person) obj;
		
		return this.getId() == p.getId()
				&& this.getName().equals(p.getName());
	}
	
	@Override
	public int hashCode() {
		
		return (this.name + this.id).hashCode();
	}
	*/
}