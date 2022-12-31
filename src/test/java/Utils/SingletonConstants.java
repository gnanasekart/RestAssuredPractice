package Utils;

import lombok.Getter;

@Getter
public class SingletonConstants {

    private static SingletonConstants INSTANCE = null;

    private SingletonConstants(){}

    public static SingletonConstants getInstance(){
        if(INSTANCE==null){
            INSTANCE=new SingletonConstants();
        }
        return INSTANCE;
    }

    private final String FilePath = System.getProperty("user.dir")+"/target/";

    private final String RequestPath = System.getProperty("user.dir")+"/target/";
}
