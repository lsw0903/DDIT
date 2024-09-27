package day36;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimpleExam {
	public static void main(String[] args) throws IOException, ParseException {
		
		String apiKey = "fbedaa69bce997e934bfccccc40e5baa"; 
		URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=daejeon&lang=en&appid=" + apiKey + "&units=metric");
		
		URLConnection urlConn = url.openConnection();
		
		JSONParser parser = new JSONParser();
		
		Object obj = parser.parse(
				new InputStreamReader(urlConn.getInputStream()));
		
		/////////////////////////////////////////////////////////
		
		JSONObject jsonObj = (JSONObject) obj;
		
		JSONObject mainObj = (JSONObject) jsonObj.get("main");
		System.out.println("##### 기상정보(대전) #####");
		System.out.println("기온\t\t : " + mainObj.get("temp"));
		System.out.println("체감온도\t\t : " + mainObj.get("feels_like"));
		System.out.println("최저기온\t\t : " + mainObj.get("temp_min"));
		System.out.println("최고기온\t\t : " + mainObj.get("temp_max"));
		System.out.println("습도\t\t : " + mainObj.get("humidity"));
		System.out.println("-----------------------------------------");
		
		System.out.println();
		
		System.out.println("##### 날씨정보(대전) #####");
		JSONArray jsonArr = (JSONArray) jsonObj.get("weather");
		
		Iterator<JSONObject> it = jsonArr.iterator();
		while(it.hasNext()) {
			JSONObject weather = it.next();
			System.out.println("날씨\t: " + weather.get("main"));
			System.out.println("설명\t: " + weather.get("description"));
			System.out.println("---------------------------");
		}
	}
}