package PayLoadHandling;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class CreatingJSON {
	
	//@Test
	public void mapToJson() {
		Map<String, String> map = new HashMap<String, String>();
	
		map.put("username", "admin");
		map.put("password", "password123");
		
		ValidatableResponse resp = RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body(map)
				.log().all()
				.when()
				.post()
				.then()
				.assertThat()
				.statusCode(200)
				.log().all();
		
	}


	/*
{
    "firstname" : "Jim",
    "lastname" : "Brown",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Breakfast"
}
	 */
	
	//@Test
	public void MapObjectToJson() {
		
		Map<String, Object> mainJson = new HashMap<String, Object>();
		Map<String, String> bookingMap = new HashMap<String, String>();
		
		mainJson.put("firstname", "Jim");
		mainJson.put("lastname", "Brown");
		mainJson.put("totalprice", 111);
		mainJson.put("depositpaid", true);
		
		bookingMap.put("checkin", "2018-01-01");
		bookingMap.put("checkout", "2019-01-01");
		
		mainJson.put("bookingdates", bookingMap);
		mainJson.put("additionalneeds", "Breakfast");
		
		ValidatableResponse resp = RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/booking")
				.contentType(ContentType.JSON)
				.body(mainJson)
				.log().all()
				.when()
				.post()
				.then()
				.assertThat()
				.statusCode(200)
				.log().all();
	}
	
	@Test
	public void JsonToArray() {
		
		Map<String, Object> firstJson = new HashMap<String, Object>();
		Map<String, String> firstbookingMap = new HashMap<String, String>();
		
		firstJson.put("firstname", "Jim");
		firstJson.put("lastname", "Brown");
		firstJson.put("totalprice", 111);
		firstJson.put("depositpaid", true);
		
		firstbookingMap.put("checkin", "2018-01-01");
		firstbookingMap.put("checkout", "2019-01-01");
		
		firstJson.put("bookingdates", firstbookingMap);
		firstJson.put("additionalneeds", "Breakfast");
		
		Map<String, Object> secondJson = new HashMap<String, Object>();
		Map<String, String> seconfBookingMap = new HashMap<String, String>();
		
		secondJson.put("firstname", "Jim");
		secondJson.put("lastname", "Brown");
		secondJson.put("totalprice", 111);
		secondJson.put("depositpaid", true);
		
		seconfBookingMap.put("checkin", "2018-01-01");
		seconfBookingMap.put("checkout", "2019-01-01");
		
		secondJson.put("bookingdates", seconfBookingMap);
		secondJson.put("additionalneeds", "Breakfast");
		
		List<Map<String, Object>> arrayJson = new ArrayList<>();
		arrayJson.add(firstJson);
		arrayJson.add(secondJson);
		
		ValidatableResponse resp = RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/booking")
				.contentType(ContentType.JSON)
				.body(arrayJson)
				.log().all()
				.when()
				.post()
				.then()
				.assertThat()
				.statusCode(200)
				.log().all();
	}	
}