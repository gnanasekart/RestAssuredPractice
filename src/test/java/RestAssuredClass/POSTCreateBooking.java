package RestAssuredClass;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;

public class POSTCreateBooking {


    @Test
    public void postCallCreateBooking() throws IOException {

        byte[] fileBytes = Files.readAllBytes(new File(System.getProperty("user.dir")+"/target/bookingdetails.json").toPath());
        String fileString = new String(fileBytes);
        String jsonBody = fileString.replace("111", String.valueOf(new Faker().number().numberBetween(100, 999)))
                .replace("Jim", new Faker().name().firstName())
                .replace("Brown", new Faker().name().lastName());
//                .replace(true, new Faker().bool().);

        ValidatableResponse resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .header("Content-type", "application/json")
                .log().all()
                .body(jsonBody)
                .post("/booking").then().statusCode(200);
    }


    @Test
    public void postCallMapCreateBooking() throws IOException {
        //imported Jackson API for serialization
        // serialization -> convert code object to byte stream to json
        //deserialization - reverse process
        //here in map generic types need to mentioned
        //verbose and not suitable for very big json files
        //if same params with more than one value means it does not suitable.
        // { } -> map interface
        // [ ] -> list interface

        Map<String, Object> objNode = new HashMap<>();

        objNode.put("firstname", "mathan");
        objNode.put("lastname", "kumar");
        objNode.put("totalprice", new Faker().number().numberBetween(100, 999));
        objNode.put("depositpaid", true);
        objNode.put("additionalneeds", "lunch");

        //for json object
        Map<String, Object> bookingDetails = new HashMap<>();
        bookingDetails.put("checkin", "2021-07-01");
        bookingDetails.put("checkout", "2021-08-01");

        objNode.put("bookingdates", bookingDetails);

        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .header("Content-type", "application/json")
                .log().all()
                .body(objNode)
                .post("/booking");

        resp.prettyPrint();
    }
}
