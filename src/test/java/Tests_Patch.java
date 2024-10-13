import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class Tests_Patch {
	
	@Test
	public void test_01_Patch()
	{
		JSONObject request =new JSONObject();
		request.put("name", "Ashok Bansal");
		request.put("Job", "Quality Assurance");
		System.out.println(request);
		
		given().header("Content-Type","application/JSON")
		.body(request.toJSONString())
		.when()
		.patch("https://reqres.in/api/users/2")
		.then()
		.statusCode(200).log().all();
		
	}

}
