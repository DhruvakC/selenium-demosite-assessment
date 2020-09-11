package sampleProjectThroughJSON;

import java.io.FileReader;
import org.testng.annotations.Test;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;


import java.io.FileNotFoundException;


public class D_ExtractMultilayerValueJSON {
  @Test
  public void hanleJSONfile() throws JsonIOException, JsonSyntaxException, FileNotFoundException { 

		try {
			JsonParser parser = new JsonParser();
			Object fileObj = parser.parse(new FileReader
					("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json"));
			
			JsonObject jsonObject = (JsonObject)fileObj;
			JsonElement name = jsonObject.get("registration");
			System.out.println("\n Value of browser variable is " +name);
			JsonObject obj_jsonobj = (JsonObject) name;
			
			System.out.println("\n Value of firstname variable is " +obj_jsonobj.get("firstname"));	
		}
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Something went wrong. \n");
		}
  }

/*private JsonObject JsonObject(JsonElement name) {
	// TODO Auto-generated method stub
	return null;
}*/
}
/*String fileOutput = "";
String value = "";
int resultSetIndex = 0;
JsonObject resultObj = new JsonObject();*/
//Object fileObj = parser.parse(new FileReader
//			("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json"));

// JsonObject resultSet = parser.parse(new FileReader
					//	("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json")).getAsJsonObject();
/*      Set<Map.Entry<String, JsonElement>> keyValues = resultSet.entrySet();
for (Map.Entry<String, JsonElement> key : keyValues) {
  if (key.getKey().equalsIgnoreCase("registration")) {
    value = key.getValue().toString().replace("\"", "").trim();
   
    System.out.println("Value of value is" +value);
  }
}*/

/*      if (parser.parse(new FileReader
			("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json")) instanceof JsonArray) {
    JsonArray resultSet = parser.parse(new FileReader
				("D:\\Selenium\\SeleniumInternalAssessment\\src\\test\\resources\\testdata.json")).getAsJsonArray();
    for (resultSetIndex = 0; resultSetIndex < resultSet.size(); resultSetIndex++) {
      resultObj = (JsonObject) resultSet.get(resultSetIndex);
      Set<Map.Entry<String, JsonElement>> keyValues = resultObj.entrySet();
      for (Map.Entry<String, JsonElement> key : keyValues) {
        if (key.getKey().equalsIgnoreCase("registration")) {
          value = key.getValue().toString().replace("\"", "").trim();
          break;
        }
        System.out.println("Value of value is" +value);  

      }

    }
  }*/


