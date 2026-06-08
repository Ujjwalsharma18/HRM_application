package genericUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class fileUtilities {
	
	public String getDataFromJsonFile(String key) throws FileNotFoundException, IOException, ParseException {
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader("./src/test/resources/commonData.json"));
		JSONObject jobj = (JSONObject) obj;
		
		String value = jobj.get(key).toString();
		return value;
	}

}
