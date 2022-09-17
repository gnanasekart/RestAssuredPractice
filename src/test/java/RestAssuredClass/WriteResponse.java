package RestAssuredClass;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.testng.annotations.Test;

import com.google.common.io.Files;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class WriteResponse {

    @Test
    public void getAuth() throws IOException {
        String jsonString = "{\"username\" : \"admin\",\"password\" : \"password123\"}";

        RequestSpecification request = RestAssured.given()
                .baseUri("https://restful-booker.herokuapp.com/auth")
                .contentType(ContentType.JSON)
                .body(jsonString).request();

        Response resp = request.post();

        //response as string and convert into byte array
        byte[] responseBytes = resp.asString().getBytes();

        //specify file name
        File target = new File("target/token.json");
        //create file if file is not available
        target.createNewFile();
        //write data into file
        Files.write(responseBytes, target);

        //response as inputstream

        InputStream istream = resp.asInputStream();
        byte[] inputStreamByte = new byte[istream.available()];

        File streamtarget = new File("target/token1.json");
        target.createNewFile();
        Files.write(inputStreamByte, streamtarget);

        //response as byteArray

        File byteArrayTarget = new File("target/token2.json");
        target.createNewFile();
        Files.write(resp.asByteArray(), byteArrayTarget);

//		File readFile = new File("target/token.json");
//		byte[] ba = new byte[(int)readFile.length()];
//		FileInputStream fis = new FileInputStream(readFile);
//		fis.read(ba);
//		
//		System.out.println(Files.);
    }
}