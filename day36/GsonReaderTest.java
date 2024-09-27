package day36;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonReaderTest {
	public static void main(String[] args) throws FileNotFoundException {
		
		//JSON 파일을 이용하여 자바객체 생성하기
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileReader fr = new FileReader("./src/day36/myJson2.txt");
		
		MemberVO mv = gson.fromJson(fr, MemberVO.class);
		
		String name = mv.getName();
		String job = mv.getJob();
		long age = mv.getAge();
		String addr = mv.getAddr();
		
		System.out.println("name : " + name);
		System.out.println("job : " + job);
		System.out.println("age : " + age);
		System.out.println("addr : " + addr);
		
		List<MemberVO> memList = mv.getMemList();
		System.out.println("-------------------------------");
		for(MemberVO m : memList) {
			System.out.printf("이름 : %s, \t직업 : %s, \t나이 : %d, \t주소 : %s \n",
					m.getName(), m.getJob(), m.getAge(), m.getAddr());
		}
	}
}