package RestAssuredClass;

import Report.ExtendReport;
import com.aventstack.extentreports.Status;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class UPDATERequest {
    @Test
    public void updateData() throws IOException {
        byte[] fileBytes = Files.readAllBytes(new File(System.getProperty("user.dir")+"/target/bookingdetails.json").toPath());
        String fileString = new String(fileBytes);
        String jsonBody = fileString.replace("James", "John");

        Response resp = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("/booking/{id}")
                .pathParam("id", 111)
                .header("token", "95a52c841f99484")
                .auth()
                .basic("admin", "password123")
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .log().all()
                .body(jsonBody)
                .put();

        resp.prettyPrint();

        ExtendReport.getTest().log(Status.PASS, resp.asPrettyString());
    }



}
