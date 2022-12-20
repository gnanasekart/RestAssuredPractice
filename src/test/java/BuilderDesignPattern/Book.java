package BuilderDesignPattern;

import POJOClass.Bookingdates;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Builder(setterPrefix = "set")
public class Book {

    private String firstname;
    private String lastname;
    private int totalprice;
    private boolean depositpaid;
    private String additonalneeds;




    //static inner class
    public static class BookingBPInner{

        private String firstname;
        private String lastname;
        private int totalprice;
        private boolean depositpaid;
        private String additonalneeds;

        public static BookingBPInner builder(){
            return new BookingBPInner();
        }

        public BookingBPInner setFirstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public BookingBPInner setLastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public BookingBPInner setTotalprice(int totalprice) {
            this.totalprice = totalprice;
            return this;
        }

        public BookingBPInner setDepositpaid(boolean depositpaid) {
            this.depositpaid = depositpaid;
            return this;
        }

        public BookingBPInner setAdditonalneeds(String additonalneeds) {
            this.additonalneeds = additonalneeds;
            return this;
        }

        public Book build(){
            return new Book(this.firstname, this.lastname, this.totalprice, this.depositpaid, this.additonalneeds);
        }
    }


}
