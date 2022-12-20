package RestAssuredClass;

import POJOClass.Booking;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GETRequest {

    @Test
    public void getBookingDetails() throws IOException {
        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking/{id}")
                .pathParam("id", 344)
                .header("Content-type","application/json")
                .log().all()
                .get();
        resp.prettyPrint();

//        System.out.println(resp.jsonPath().getString("firstname"));
//        System.out.println(resp.jsonPath().getString("bookingdates.checkin"));

//        Booking booking = resp.as(Booking.class);
//        System.out.println(booking.getTotalprice());

//        ObjectMapper objMap = new ObjectMapper();
//        String getit = objMap.reader().forType(Booking.class).readValue("lastname");
//        System.out.println(getit);

        //scehma validation
//        resp.then().body(JsonSchemaValidator
//                .matchesJsonSchemaInClasspath("schema.json"));

//        schema validation
//        resp.then().body(JsonSchemaValidator
//                .matchesJsonSchema(new File(System.getProperty("user.dir")+"/src/test/resources/schema.json")));

//      write response in external file
        Files.write(Paths.get(System.getProperty("user.dir")+"/target/response.json"), resp.asByteArray());

    }
}