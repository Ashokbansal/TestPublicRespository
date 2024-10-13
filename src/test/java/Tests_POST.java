import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;

public class Tests_POST {

	@Test
	public void test_01_Post() {
		JSONObject request = new JSONObject();
		request.put("name", "Ashok Bansal");
		request.put("Job", "Quality Assurance");
		System.out.println(request);

		given().header("Content-Type", "application/JSON").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201);

	}
}
