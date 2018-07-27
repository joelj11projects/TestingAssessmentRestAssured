package qa.PetAssessmentRestAssured;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;


public class RunRestAssured {
	
	private RequestSpecification request; 
	
	private Response response;
	
	
@Test
	public void postOwner() {

	JSONArray petArray = new JSONArray();
	JSONArray visitArray = new JSONArray();
	
	RestAssured.baseURI = "http://10.0.10.10:9966/petclinic/api/owners";

	Map<String, Object> emptyOwner = new HashMap<>();
	Map<String, Object> emptyPet = new HashMap<>();
	Map<String, Object> nestedVisitAsMap = new HashMap<>();
	
	nestedVisitAsMap.put("date", "2018/07/27");
	nestedVisitAsMap.put("description", "check up");
	nestedVisitAsMap.put("id", 0);
	nestedVisitAsMap.put("pet", emptyPet);

	visitArray.add(nestedVisitAsMap);

	Map<String, Object> nestedPetAsMap = new HashMap<>();
	Map<String, Object> nestedTypeAsMap = new HashMap<>();

	nestedTypeAsMap.put("id", 0);
	nestedTypeAsMap.put("name", "Pikachu");
	nestedPetAsMap.put("birthDate", "2018-07-27T09:02:40.767Z");
	nestedPetAsMap.put("id", 0);
	nestedPetAsMap.put("name", "dragon");
	nestedPetAsMap.put("owner", emptyOwner);
	nestedPetAsMap.put("type", nestedTypeAsMap); // needs nested type TODO
	nestedPetAsMap.put("visits", visitArray); // needs nested type TODO
	petArray.add(nestedPetAsMap);
	JSONObject requestParams = new JSONObject();
	
	requestParams.put("address", "Manchester");
	requestParams.put("city", "This is a test");
	requestParams.put("firstName", "Joel");
	requestParams.put("id", 0);
	requestParams.put("lastName", "Finnallyy");
	requestParams.put("pets", petArray);
	requestParams.put("telephone", "433454534571");

	given().contentType(ContentType.JSON).body(requestParams).when().post("/").then().statusCode(201);
	System.out.println(requestParams.toString());;
}


	
@Test
	public void deleteOwner() {
		request = given().when().contentType(ContentType.JSON);
		response = request.delete("http://10.0.10.10:9966/petclinic/api/owners/2");
		
	}
	
	
	
@Test
	public void getOwner() {
		request = given().when().contentType(ContentType.JSON);
		response = request.get("http://10.0.10.10:9966/petclinic/api/owners");
		response.prettyPrint();
	}
	

}
