package day36;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

public class GsonWriterTest {
	public static void main(String[] args) throws IOException {
		
		// 1. JSON 파일을 JAVA 객체를 이용하여 생성하기
		Gson gson = new Gson();
		
		MemberVO mv = new MemberVO();
		mv.setName("홍길동");
		mv.setJob("학생");
		mv.setAge(30);
		mv.setAddr("대전시 중구 오류동");
		
		// List 데이터 생성
		List<MemberVO> memList = new ArrayList<MemberVO>();
		
		MemberVO mv2 = new MemberVO();
		mv2.setName("이순신");
		mv2.setJob("자영업");
		mv2.setAge(40);
		mv2.setAddr("서울시 영등포구");
		memList.add(mv2);
		
		mv2 = new MemberVO();
		mv2.setName("강감찬");
		mv2.setJob("회사원");
		mv2.setAge(30);
		mv2.setAddr("부산시 해운대구");
		memList.add(mv2);
		
		mv2 = new MemberVO();
		mv2.setName("이몽룡");
		mv2.setJob("무직");
		mv2.setAge(50);
		mv2.setAddr("경기도 수원시");
		memList.add(mv2);
		
		mv2 = new MemberVO();
		mv2.setName("정도전");
		mv2.setJob("농업");
		mv2.setAge(45);
		mv2.setAddr("인천시 부평구");
		memList.add(mv2);
		
		mv.setMemList(memList);
		
		//////////////////////////////////////////
		
		FileWriter fw = new FileWriter("./src/day36/myJson2.txt");
		
		String jsonStr = gson.toJson(mv, MemberVO.class);
		System.out.println(jsonStr);
		fw.write(jsonStr);
		
		fw.close();
		
	}
}