package RestAssuredClass;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

import static io.restassured.RestAssured.*;

public class DefaultAuthRequestSpec {

    @Test
    public void defaultRequestSpecSet() {

        RequestSpecification request = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/auth/token")
                .auth().basic("admin", "password123")
                .contentType("application/x-www-form-urlencoded");
//                .formParam("username", "")
//                .formParam("password", "")
//                .formParam("grant_type", "password")
//                .formParam("client_id", "");

        requestSpecification = request;

        //Response response = request.post();

        Response response = when().post("/auth/token");

        System.out.println(response.prettyPrint());

        //Querying the Request Specification to get the Request details

        QueryableRequestSpecification query = SpecificationQuerier.query(request);

        //System.out.println(query.getBasePath());

        //System.out.println(query.getBaseUri());

        //System.out.println(query.getContentType());//application/x-www-form-urlencoded


        //default Host

        Response req = given().log().all().when().get();
        System.out.println(req.asString().toString());

        Headers header =response.getHeaders();
        for (Header h: header){
            System.out.println(h.getName()+" - "+h.getValue());
        }

    }
}
