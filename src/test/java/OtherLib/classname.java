package OtherLib;

import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

public class classname {

    @Test
    public void ex(){


        HttpGet get = new HttpGet("https://reqres.in/api/users?page=2");


    }
}
