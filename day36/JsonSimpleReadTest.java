package day36;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleReadTest {
	public static void main(String[] args) throws IOException, ParseException {
		FileReader fr = new FileReader("./src/day36/myJsonFile.txt");
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(fr);
		
		JSONObject jsonObj = (JSONObject) obj;
		
		String name = (String) jsonObj.get("name");
		String job = (String) jsonObj.get("job");
		long age = (long) jsonObj.get("age");
		String addr = (String) jsonObj.get("addr");
		
		System.out.println("name : " + name);
		System.out.println("job : " + job);
		System.out.println("age : " + age);
		System.out.println("addr : " + addr);
		
		System.out.println("-------------------------------------");
		
		JSONArray memList = (JSONArray) jsonObj.get("memList");
		
		Iterator<JSONObject> it = memList.iterator();
		
		while(it.hasNext()) {
			JSONObject obj2 = it.next();
			
			System.out.printf("이름 : %s, \t직업 : %s, \t나이 : %d, \t주소 : %s\n",
					obj2.get("name"), obj2.get("job"),
					obj2.get("age"), obj2.get("addr"));
			
		}
	}
}