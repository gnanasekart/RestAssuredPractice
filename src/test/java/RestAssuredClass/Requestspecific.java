package RestAssuredClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class Requestspecific {

	public static void main(String[] args) {

		//RequestSpecification request = 
		ValidatableResponse val = RestAssured.given()
				.baseUri("")
				.basePath("/auth/token")
				.contentType("application/x-www-form-urlencoded")
				.formParam("username", "")
				.formParam("password", "")
				.formParam("grant_type", "password")
				.formParam("client_id", "")
				.when()
				.post()
				.then()
				.assertThat().statusCode(200);


		String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

		RequestSpecification request = RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body(jsonString).request();

		//Response resp = request.when().post();

		//ValidatableResponse val1 = resp.then();

		//System.out.println(resp.asString().toString());


		//put call

		String jsonPut = "{\r\n" + 
				"    \"firstname\" : \"Amod\",\r\n" + 
				"    \"lastname\" : \"Mahajan\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}";

		Response resp1 = RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/booking/1")
				.cookie("token", "5115bd914633b3b")
				.contentType(ContentType.JSON)
				.body(jsonPut)
				.when()
				.put();

		System.out.println(resp1.asString().toString());

		//		Response resp = request.post();
		//		String st = resp.asString();
		//		
		//		System.out.println(st.toString());
		//		
		//		System.out.println(resp.prettyPrint());
		//		
		//		ValidatableResponse vresp = resp.then().statusCode(200);

		//				.accept(ContentType.JSON).accept("application/JSON")
		//				.basePath("")
		//				.baseUri("")
		//				.body("")
		//				//.config("")
		//				.contentType("")
		//				.cookie("")
		//				//.filter(file)
		//				.formParam("parameterName, parameterValues")
		//				//.header("")
		//				//.multiPart("")
		//				.param("", "parameterValues")
		//				.pathParam("parameterName", "parameterValue")
		//				.port(56)
		//				.queryParam("", "parameterValues")
		//				.request()
		//				.sessionId("")
		//				.that()
		//				.when()
		//				.with();
	}
}