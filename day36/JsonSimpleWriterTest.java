package day36;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class JsonSimpleWriterTest {
/*
	JSON : Javascript Object Notation
	자바스크립트 객체 표기법으로 작성된 텍스트를 의미하며, 데이터를 저장하거나
	주고받기 위한 포맷으로 널리 사용된다.
	
		-JSON에서 value값으로 사용 가능한 데이터 타입
		
		1. string
		2. number
		3. object(JSON object)
		4. array
		5. boolean
		6. null
*/

	public static void main(String[] args) throws IOException {
		// JSON 데이터 생성
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("name", "홍길동");
		jsonObj.put("job", "학생");
		jsonObj.put("age", 30);
		jsonObj.put("addr", "대전시 중구 오류동");
		
		// JSONArray 데이터 생성
		JSONArray memList = new JSONArray();
		
		JSONObject jsonObj2 = new JSONObject();
		jsonObj2.put("name", "이순신");
		jsonObj2.put("job", "자영업");
		jsonObj2.put("age", 40);
		jsonObj2.put("addr", "서울시 영등포구 여의도동");
		memList.add(jsonObj2);
		
		jsonObj2 = new JSONObject();
		jsonObj2.put("name", "강감찬");
		jsonObj2.put("job", "회사원");
		jsonObj2.put("age", 33);
		jsonObj2.put("addr", "부산시 해운대구");
		memList.add(jsonObj2);
		
		jsonObj2 = new JSONObject();
		jsonObj2.put("name", "이몽룡");
		jsonObj2.put("job", "무직");
		jsonObj2.put("age", 50);
		jsonObj2.put("addr", "경기도 수원시");
		memList.add(jsonObj2);
		
		jsonObj2 = new JSONObject();
		jsonObj2.put("name", "정도전");
		jsonObj2.put("job", "농업");
		jsonObj2.put("age", 60);
		jsonObj2.put("addr", "인천시 부평구");
		memList.add(jsonObj2);
		
		jsonObj.put("memList", memList);
		
		FileWriter fw = new FileWriter(
				"./src/day36/myJsonFile.txt");
		fw.write(jsonObj.toString());
		fw.close();
		
		System.out.println("JSON 객체 출력 : " + jsonObj);
		
	}
}