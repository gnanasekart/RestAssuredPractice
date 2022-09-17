package RestAssuredClass;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class getResponseTime {

    @Test
    public void getTime() {
        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(new File("target/userdetails.json"))
                .when()
                .post();

        System.out.println("getTime = " + resp.getTime());

        System.out.println("getTimeIn = " + resp.getTimeIn(TimeUnit.SECONDS));

        System.out.println("time = " + resp.time());

        System.out.println("getTime = " + resp.timeIn(TimeUnit.NANOSECONDS));

        System.out.println("getStatusCode = " + resp.getStatusCode());

        System.out.println("getSessionId = " + resp.getSessionId());

        System.out.println("getCookies = " + resp.getCookies().size());

        System.out.println("getBody = " + resp.getBody().asPrettyString());

        System.out.println("getHeadersDetails = " + resp.getHeaders());
    }
}