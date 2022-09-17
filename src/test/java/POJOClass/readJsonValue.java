package POJOClass;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class readJsonValue {

    @Test
    public void readjsonValues() throws JsonMappingException, JsonProcessingException {


        String jsonString = "{\r\n" +
                "  \"firstName\" : \"Amod\",\r\n" +
                "  \"lastName\" : \"Mahajan\",\r\n" +
                "  \"gender\" : \"M\",\r\n" +
                "  \"age\" : 29,\r\n" +
                "  \"salary\" : 10987.77,\r\n" +
                "  \"married\" : false\r\n" +
                "}";

        ObjectMapper objmap = new ObjectMapper();

        EmployeePojo emppojo = objmap.readValue(jsonString, EmployeePojo.class);
        System.out.println("first name = " + emppojo.getFirstName());
    }
}
