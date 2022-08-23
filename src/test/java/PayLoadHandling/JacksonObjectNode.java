package PayLoadHandling;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class JacksonObjectNode {

	@Test
	public void objtoObjMapper() throws JsonProcessingException {
		//Creating Object to Object Mapper

		ObjectMapper objMap = new ObjectMapper();

		//for main json 
		ObjectNode objNode = objMap.createObjectNode();

		objNode.put("firstname", "mathan");
		objNode.put("lastname", "kumar");
		objNode.put("totalprice", 111);
		objNode.put("depositpaid", true);
		objNode.put("additionalneeds", "lunch");

		//for json object
		ObjectNode bookingDetails = objMap.createObjectNode();
		bookingDetails.put("checkin", "2021-07-01");
		bookingDetails.put("checkout", "2021-08-01");

		objNode.set("BookingDetails", bookingDetails);

		/*
		String content = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(objNode);

		System.out.println(content);

		//getting the value from Object node

		System.out.println(objNode.get("firstname").asText());//mathan
		System.out.println(objNode.get("depositpaid").asBoolean());//true

		//to get all the field names by fieldNames() and for values by elements()

		Iterator<String> key = objNode.fieldNames();
		Iterator<JsonNode> value = objNode.elements();

		while(key.hasNext() && value.hasNext()) {
			System.out.println(key.next()+" - "+value.next());
		}

		//to get all fields and value in single call by fields()

		Iterator<Entry<String, JsonNode>> entry  = objNode.fields();

		while(entry.hasNext()) {
			Entry<String, JsonNode> ent = entry.next();
			System.out.println(ent.getKey()+" - "+ent.getValue());
		}


		//to remove

		objNode.remove("firstname");

		objNode.put("lastname", "mathan kumar");

		Passing json object as payload if it is in json or xml format
		need to pass the content type based on type we passing
		Interface RequestSpecification has multiple overloaded body() methods and 
		one of the overloaded methods is RequestSpecification body(Object object).
		This method will be automatically serialized passed object to JSON or XML and sent with the request.


		 */

		ValidatableResponse resp = RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/booking")
				.contentType(ContentType.JSON)
				.body(objNode).log().all()
				.when()
				.post()
				.then()
				.assertThat().statusCode(200)
				.log().all();

		String content = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(resp);
		System.out.println(content);


	}

}
