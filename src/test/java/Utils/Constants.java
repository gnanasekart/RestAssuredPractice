package Utils;

import lombok.Getter;

public class Constants {
//If the variable is not static means we can give getter at class level
    // if it is at variable level means we need to give at variable


    private static @Getter final String FilePath = System.getProperty("user.dir")+"/target/";

    private static @Getter final String RequestPath = System.getProperty("user.dir")+"/target/";

}
