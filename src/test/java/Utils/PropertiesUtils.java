package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class PropertiesUtils {

    private static Properties properties = new Properties();
    private static HashMap <String, String> map = new HashMap<>();

    public static void getProperties(){
        try {
            FileInputStream fis = new FileInputStream("");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        properties.entrySet().stream()
                .forEach(e -> map.put(e.getKey().toString(), e.getValue().toString()));
    }

    public static String getValue(String key){
        return map.get(key);
    }
}
