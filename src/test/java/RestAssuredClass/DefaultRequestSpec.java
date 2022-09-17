package RestAssuredClass;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class DefaultRequestSpec {

    @Test
    public void defaultRequestSpecSet() {

        RequestSpecification request = RestAssured.given()
                .baseUri("")
                //.basePath("/auth/token")
                .contentType("application/x-www-form-urlencoded")
                .formParam("username", "")
                .formParam("password", "")
                .formParam("grant_type", "password")
                .formParam("client_id", "");

        RestAssured.requestSpecification = request;

        //Response response = request.post();

        Response response = RestAssured.when().post("/auth/token");

        //System.out.println(response.prettyPrint());

        //Querying the Request Specification to get the Request details

        QueryableRequestSpecification query = SpecificationQuerier.query(request);

        //System.out.println(query.getBasePath());

        //System.out.println(query.getBaseUri());

        //System.out.println(query.getContentType());//application/x-www-form-urlencoded


        //default Host

        Response req = RestAssured.given().log().all().when().get();
        System.out.println(req.asString().toString());

    }
}
