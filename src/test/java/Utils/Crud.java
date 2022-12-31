package Utils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

public final class Crud {

    private Crud(){}
    public static RequestSpecification getRequestCall(){
        return RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .contentType(ContentType.JSON)
                .log()
                .all();
    }

    @SneakyThrows
    public static RequestSpecification postRequestCall(String fileName){
        /*
        byte[] fileBytes = Files.readAllBytes(Paths.get(System.getProperty("user.dir")+"/target/bookingdetails.json"));
        String fileString = new String(fileBytes);

                String jsonBody = fileString.replace("111", String.valueOf(new Faker().number().numberBetween(100, 999)))
                .replace("Jim", new Faker().name().firstName())
                .replace("Brown", new Faker().name().lastName());

        String jsonBody = fileString.replace("111", String.valueOf(BusinessUtils.getId(100, 999)))
                .replace("Jim", BusinessUtils.getFirstName())
                .replace("Brown", BusinessUtils.getLastName());

         */

        String fileString = ApiUtils.readJsonToString(Constants.getFilePath()+fileName+".json")
                .replace("111", String.valueOf(BusinessUtils.getId(100, 999)))
                .replace("Jim", BusinessUtils.getFirstName())
                .replace("Brown", BusinessUtils.getLastName());

        return RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .contentType(ContentType.JSON)
                .body(fileString)
                .log()
                .all();
    }
}
