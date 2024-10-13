import static io.restassured.RestAssured.when;

import org.testng.annotations.Test;

public class Tests_Delete {

	@Test
	public void test_01_Delete()
	{
		when()
		.delete("https://reqres.in/api/users/2")
		.then()
		.statusCode(204).log().all();
		
	}
}
