package RestAssuredClass;

import Report.ExtendReport;
import Utils.ApiUtils;
import Utils.BusinessUtils;
import Utils.Crud;
import Utils.FakerUtils;
import com.aventstack.extentreports.Status;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import lombok.SneakyThrows;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class POSTCreateBooking {


    //public void postCallCreateBooking() throws IOException
    // -> can remove this IOExceptions or any type of exceptions using lombok SneakyThrows
    @SneakyThrows
    @Test
    public void postCallCreateBooking() {

//        ValidatableResponse resp = Crud.postRequestCall("bookingdetails")
//                                    .post("/booking")
//                                    .then()
//                                    .statusCode(200);//assert in hamcrust assertion

        //any one method of assertion
        Response response = Crud.postRequestCall("bookingdetails")
                .post("/booking");

        Assertions.assertThat(response.getStatusCode()).isEqualTo(200);

        //Add the response into response.json file

        ApiUtils.writeStringAsResponse("responseFile", response);

        ExtendReport.getTest().log(Status.PASS, response.asPrettyString());
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

        ExtendReport.getTest().log(Status.PASS, resp.asPrettyString());
    }
}
