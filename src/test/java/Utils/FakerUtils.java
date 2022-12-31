package Utils;

import com.github.javafaker.Faker;

public final class FakerUtils {

    //to restrict access out of this package means change private to protected or default
    private FakerUtils(){}
    private static final Faker faker = new Faker();

    public static int getNumber(int startValue, int endValue){
        return faker.number().numberBetween(startValue,endValue);
    }

    public static String getFirstName(){
        return faker.name().firstName().toLowerCase();
    }

    public static String getLastName(){
        return faker.name().lastName().toLowerCase();
    }


}
