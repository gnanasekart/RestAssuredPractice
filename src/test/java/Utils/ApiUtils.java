package Utils;

import io.restassured.response.Response;
import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiUtils {
    /*
    How to maintain a Util class
        1. don't directly implement any code into your framework
        2. try to reduce the repeating code
        3. create a separate class to have repeating code
        4. then create a business logic class to call this class
        5. main class will call this business logic methods
     */

    @SneakyThrows
    public static String readJsonToString(String filePath) {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    @SneakyThrows
    public static void writeStringAsResponse(String fileName, Response response){
        //without singleton object
        //Files.write(Paths.get(Constants.getRequestPath()+fileName+".json"), response.asByteArray());

        //using singleton object
        Files.write(Paths.get(SingletonConstants.getInstance().getFilePath()+fileName+".json"), response.asByteArray());
    }
}
