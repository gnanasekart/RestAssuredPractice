package RestAssuredClass;

import Report.ExtendReport;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecbuilder {

    @Test
    public void RequestspecBuilders() {

        RequestSpecBuilder specbuilder = new RequestSpecBuilder()
                .setBaseUri("https://restful-booker.herokuapp.com")
                .setBasePath("/booking");
        RequestSpecification reqSpec = specbuilder.build();

        //Direct http call
        //System.out.println(reqSpec.get().asString());

        //pass to overloaded given method
        System.out.println(RestAssured.given(reqSpec).get().prettyPrint());
        System.out.println("-----------------------");
        //pass using spec method
        System.out.println(RestAssured.given().spec(reqSpec).get().prettyPrint());
    }

    @Test
    public void RequestspecificationClass() {

        RequestSpecification request = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking")
                .contentType(ContentType.JSON);

        QueryableRequestSpecification query = SpecificationQuerier.query(request);
        System.out.println(query.getBaseUri());
        System.out.println(query.getContentType());
        System.out.println(query.getHeaders());
        System.out.println(query.getHttpClient());

    }
}
