package immutable;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Object> phoneNumber = new ArrayList<>();
        phoneNumber.add("531656548");
        phoneNumber.add("154151553");

        MyImmutableClass obj1 = new MyImmutableClass("myName", phoneNumber);
        obj1.getPhoneNumberList().add("2564154563");
        System.out.println(obj1.getPhoneNumberList());
    }
}
