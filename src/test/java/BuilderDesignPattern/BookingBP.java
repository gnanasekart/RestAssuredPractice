package BuilderDesignPattern;

import POJOClass.Booking;
import POJOClass.Bookingdates;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Setter - lombak for setter method
//@Getter - lombak for getter method
//@AllArgsConstructor - lombak for constructor
//@ToString - lombak to convert object to string
public class BookingBP {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additonalneeds;

    public BookingBP builder(){
        return this;
    }

    public BookingBP setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public BookingBP setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public BookingBP setTotalprice(int totalprice) {
        this.totalprice = totalprice;
        return this;
    }

    public BookingBP setDepositpaid(boolean depositpaid) {
        this.depositpaid = depositpaid;
        return this;
    }

    public BookingBP setAdditonalneeds(String additonalneeds) {
        this.additonalneeds = additonalneeds;
        return this;
    }

    public Book build(){
        return new Book(this.firstname, this.lastname, this.totalprice, this.depositpaid, this.additonalneeds);
    }
}
