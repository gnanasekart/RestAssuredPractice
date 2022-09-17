package RestAssuredClass;

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
}
