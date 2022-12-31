package Utils;

public final class BusinessUtils {

    private BusinessUtils(){}

     public static int getId(int startValue, int endName){
        return FakerUtils.getNumber(startValue, endName);
    }

    public static String getFirstName(){
        return FakerUtils.getFirstName();
    }

    public static String getLastName(){
        return FakerUtils.getLastName();
    }
}
