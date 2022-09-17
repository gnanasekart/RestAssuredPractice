package PayLoadHandling;

import java.util.Iterator;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class JacksonArrayNode {

	@Test
	public void createArrayNode() throws JsonProcessingException {

		ObjectMapper objmap = new ObjectMapper();

		ArrayNode arrayNode = objmap.createArrayNode();

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

		//----------------

		ObjectNode objNode1 = objMap.createObjectNode();

		objNode1.put("firstname", "mathan");
		objNode1.put("lastname", "gowri");
		objNode1.put("totalprice", 112);
		objNode1.put("depositpaid", false);
		objNode1.put("additionalneeds", "breakfast");

		//for json object
		ObjectNode bookingDetails1 = objMap.createObjectNode();
		bookingDetails1.put("checkin", "2021-07-04");
		bookingDetails1.put("checkout", "2021-08-04");

		objNode1.set("BookingDetails", bookingDetails1);

		//now adding the objectnode in to arraynode

		arrayNode.add(objNode);
		arrayNode.add(objNode1);
		/*
		//to get the object from array
		arrayNode.get(0);
		//String content = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode.get(0));

		//to get the value using iteration
		Iterator<JsonNode> it = arrayNode.iterator();

		while(it.hasNext()) {
			//String content = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(it.next());
			//System.out.println(content);
		}
		 */
		arrayNode.remove(0);

		String content = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode);
		System.out.println(content);		
	}
}

