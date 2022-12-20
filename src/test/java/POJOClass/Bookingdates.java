package POJOClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor()
public class Bookingdates {
    private String checkin;
    private String checkout;
    //private List<String> period;

    public Bookingdates(){}

//    public Bookingdates(String checkin, String checkout) {
//        this.checkin = checkin;
//        this.checkout = checkout;
//    }
//
//    public String getCheckin(){
//        return checkin;
//    }
//
//    public void setCheckin(String checkin){
//        this.checkin=checkin;
//    }
//
//    public String getCheckout(){
//        return checkout;
//    }
//
//    public void setCheckout(String checkout){
//        this.checkout=checkout;
//    }

}
