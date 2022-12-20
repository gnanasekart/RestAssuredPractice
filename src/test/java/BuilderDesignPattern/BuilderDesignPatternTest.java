package BuilderDesignPattern;

import org.testng.annotations.Test;

public class BuilderDesignPatternTest {

    /*
    when we're creating new record using constructor we need to pas like
    Employee employee = new Employee(......parameters........);

    if the parameters are comes in different count means for every set of parameters we need to create new constructors in Pojo class
    to overcome that type of error we use builder design pattern

    over coming drawbacks like
    1. maintaining Immutability of class - without setter
    2. no of parameters increases the readability get decrease
    3. If you want to ignore some fields, it becomes difficult to create multi constructors.

    method 1 - creating builder design pattern using external builder class
    method 2 - static inner class
    method 3 - lombok @Builder annotation use same concept as static inner class
                lombok will call by class name.builder.method names, here no any getter or setter is shown in method name
                can change buildMethodName from build() to any name by
                @Builder(buildMethodName="perform")
                @Builder(builderMethodName="builder")//default value
                @Builder(setterPrefix="set")


     */

    //method 1 - builder design pattern using external builder
    @Test
    public void builderTest(){
        Book book = new BookingBP().builder()
                        .setFirstname("john").setDepositpaid(true)
                        .setAdditonalneeds("lunch").setTotalprice(111).build();

        System.out.println(book);
    }


    //method 2 - using static Inner class
    @Test
    public void staticBuilderTest(){
        Book inner = Book.BookingBPInner.builder()
                .setFirstname("Joses")
                .setLastname("son")
                .setDepositpaid(true)
                .setTotalprice(101).build();
        System.out.println(inner);

    }

    //method 3 - using @Builder lombak annotation
    @Test
    public void lombakBuilderTest(){
        Book book = Book.builder().setFirstname("Johnson").setLastname("son")
                    .setTotalprice(1223).setAdditonalneeds("food").build();
        System.out.println(book);
    }
}
