package RestAssuredClass;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.aventstack.extentreports.utils.FileUtil;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PostRequestAuth {

    @Test
    public void postCall() {
        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .header("Content-type", "application/json")
                //.contentType(ContentType.JSON)
                .body("{\"username\":\"admin\",\"password\":\"password123\"}")
                //.body(new File("target/userdetails.json"))
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
        System.out.println("getHeadersDetails = " + resp.contentType());
        resp.prettyPrint();
    }


    String jsonBody = "{" +
            "\"username\":\"admin\"," +
            "\"password\":\"password123\"" +
            "}";

    @Test
    public void postCallByStringBody() {
        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .header("Content-type", "application/json")
                .body(jsonBody)
                .log().all()
                .when()
                .post();
        resp.prettyPrint();
    }

    @Test
    public void postCallByMap() {
        Map<String, String> map = new HashMap<>();
        map.put("username", "admin");
        map.put("password", "password123");

        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .header("Content-type", "application/json")
                .body(map)
                .log().all()
                .when()
                .post();
        resp.prettyPrint();
    }

    @Test
    public void postCallByExternalFileBody() {
        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .header("Content-type", "application/json")
                .body(new File("target/userdetails.json"))
                .log().all()//log does not work when getting data from external file
                .when()
                .post();
        resp.prettyPrint();
    }

    //getting the file and storing it as string and passing into the body
    @Test
    public void postCallByFileStringBody() throws IOException {

        //reading data from external file into array of bytes
        byte[] b = Files.readAllBytes(new File(System.getProperty("user.dir") + "/target/userdetails.json").toPath());

        //converting into string if we need to change only few params in the request body,
        // if there are more params need to change dynamically then it won't be suitable
        String newBody = new String(b);

        //replacing invalid details
        String replce = newBody.replace("admin", "ADMIN");

        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .header("Content-type", "application/json")
                .body(replce)//passing invalid details as body content
                .log().all()
                .when()
                .post();
        resp.prettyPrint();
    }
}