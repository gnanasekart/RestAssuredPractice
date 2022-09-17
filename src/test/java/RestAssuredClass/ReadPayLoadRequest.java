package RestAssuredClass;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ReadPayLoadRequest {

    @Test
    public void payLoad() {
        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(new File("target/userdetails.json"))
                .when()
                .post();

        System.out.println(resp.prettyPrint());
    }
}
