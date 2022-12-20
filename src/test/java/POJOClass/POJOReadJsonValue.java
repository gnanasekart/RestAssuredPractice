package POJOClass;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class POJOReadJsonValue {

    @Test
    public void readjsonValues() throws JsonMappingException, JsonProcessingException {


        String jsonString = "{\r\n" +
                "  \"firstName\" : \"Amod\",\r\n" +
                "  \"lastName\" : \"Mahajan\",\r\n" +
                "  \"gender\" : \"M\",\r\n" +
                "  \"age\" : 29,\r\n" +
                "  \"salary\" : 10987.77,\r\n" +
                "  \"married\" : false\r\n" +
                "}";

        ObjectMapper objmap = new ObjectMapper();

        EmployeePojo emppojo = objmap.readValue(jsonString, EmployeePojo.class);
        System.out.println("first name = " + emppojo.getFirstName());
    }

    @Test
    public void postCallPojoClass(){
        String firstname = String.valueOf(new Faker().name().firstName());
        String lastname = String.valueOf(new Faker().name().lastName());
        int totalprice = new Faker().number().numberBetween(100, 999);
        boolean depositpaid = new Faker().bool().bool();
        //String additionalneeds =
        String date = String.valueOf(new Faker().date().birthday(10,20));

        Bookingdates bookingdates = new Bookingdates(date, date);
//        Bookingdates bookingdates = new Bookingdates(date, date, Arrays.asList("AM", "PM"));

        Booking booking = new Booking(firstname, lastname, totalprice, depositpaid, "lunch", bookingdates);

//        Map<Object, Object> map = new HashMap<>();
//        map.put("firstname", booking.getFirstname());
//        map.put("lastname", booking.getLastname());
//        map.put("totalprice", booking.getTotalprice());
//        map.put("depositpaid", booking.getDepositpaid());
//        map.put("bookingdates", bookingdates);
//        map.put("additionalneeds", "lunch");

        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .header("Content-type", "application/json")
                //.accept(ContentType.JSON)
                .log().all()
                .body(booking)
                .post("/booking");

        resp.prettyPrint();
    }
}
