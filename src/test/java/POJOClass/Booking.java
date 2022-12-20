package POJOClass;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor()
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@JsonPropertyOrder("dates")
public class Booking {
    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additonalneeds;
    private Bookingdates dates;

    public Booking(){}

//    public Booking(String firstname, String lastname, int totalprice, boolean depositpaid, Bookingdates dates, String additonalneeds) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.totalprice = totalprice;
//        this.depositpaid = depositpaid;
//        this.additonalneeds = additonalneeds;
//        this.dates=dates;
//    }
//
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getLastname() {
//        return lastname;
//    }
//
//    public void setLastname(String lastname) {
//        this.lastname = lastname;
//    }
//
//    public int getTotalprice() {
//        return totalprice;
//    }
//
//    public void setTotalprice(int totalprice) {
//        this.totalprice = totalprice;
//    }
//
//    public boolean getDepositpaid() {
//        return depositpaid;
//    }
//
//    public void setDepositpaid(boolean depositpaid) {
//        this.depositpaid = depositpaid;
//    }
//
//    public String getAdditonaldates() {
//        return additonaldates;
//    }
//
//    public void setAdditonaldates(String additonaldates) {
//        this.additonaldates = additonaldates;
//    }

}
