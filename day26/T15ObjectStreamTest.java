package day26;

import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 	객체 입출력 보조스트림 예제
 	(직렬화 및 역직렬화)
 	Object를 I/O 작업시키기
*/
public class T15ObjectStreamTest {
	public static void main(String[] args) {
		// Member 객체 생성
		Member mem1 = new Member("홍길동", 19, "대전");
		Member mem2 = new Member("한유림", 29, "부산");
		Member mem3 = new Member("이상우", 39, "광주");
		Member mem4 = new Member("김원빈", 49, "대구");
		
		// ↓ finally에 접근하기 위해서 바깥에 객체 변수 선언
		ObjectOutputStream oos = null;
		/*
		try {
			FileOutputStream fos = new FileOutputStream("d:/D_Other/memObj.bin");
														object 객체 정보를 담은 binary 데이터
			oos = new ObjectOutputStream(fos);
		*/
		
		try {
			// 객체를 파일에 저장하기
			oos = new ObjectOutputStream(
					new BufferedOutputStream(
						new FileOutputStream("d:/D_Other/memObj.bin")));
			
			// 객체 저장하기
			oos.writeObject(mem1); // 직렬화
			oos.writeObject(mem2); // 직렬화
			oos.writeObject(mem3); // 직렬화
			oos.writeObject(mem4); // 직렬화
			
			System.out.println("객체 저장 완료...");
			
			// 실행시 NotSerializableException 오류 발생 - 직렬화가 가능하지 않다(member)
			// Serialization 직렬 - 교재 55p
			
		}catch(IOException ex) {
			ex.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		/////////////////////////////////////////////////////////////////
		// 저장한 객체를 읽어와 내용 출력하기
		
		ObjectInputStream ois = null;
		
		try {
			ois = new ObjectInputStream(
					    new FileInputStream("d:/D_Other/memObj.bin"));
			
			Object obj = null;
			//           catch 구문 추가(ClassNotFoundException)
			while((obj = ois.readObject()) != null) {  // 역직렬화 - readObject()메소드 호출시
				// 읽어온 객체를 원래의 타입으로 변환 후 사용한다.
				Member mem = (Member) obj;
				System.out.println("이름 : " + mem.getName());
				System.out.println("나이 : " + mem.getAge());
				System.out.println("주소 : " + mem.getAddr());
				System.out.println("---------------------");
			}
			
			// 실행시 마지막 예외는 무조건 터진다.(EOFException)
			// ↓ 예외를 처리시
		}catch(EOFException ex) {
			System.out.println("출력작업 끝...");
		}catch(IOException ex) {
			ex.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
// 멤버 객체를 I/O 작업시키기
// VO 클래스는 멤버값을 담기 위해 사용
class Member implements Serializable {
//                     ↑ 직렬화가 가능하게 선언(직렬화가 가능하다고 표시해주는 인터페이스)
//          			 이러한 인터페이스들을 Tag 인터페이스라 부른다(Tag ⊃ Serializable)
	// 자바는 Serializable 인터페이스를 구현한 객체만 직렬화 할 수 있도록 제한하고 있다.
	
	/*
	   transient => 직렬화 대상에서 제외시킬 멤버변수에 지정한다.
	   				static 필드는 직렬화가 되지 않는다.
	   				직렬화가 대상이 아닌 멤버변수는 기본값으로 저장된다.
	   				(참조형 변수 : null, 숫자형변수 : 0)
	*/
	private transient String name;
	private transient int age;
	private String addr;
	public Member(String name, int age, String addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + ", addr=" + addr + "]";
	}
}