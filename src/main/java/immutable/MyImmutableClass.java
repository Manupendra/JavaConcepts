package immutable;

import java.util.ArrayList;
import java.util.List;

final class MyImmutableClass {
    private final String name;
    private final List<Object> phoneNumberList;


    public MyImmutableClass(String name, List<Object> phoneNumberList) {
        this.name = name;
        this.phoneNumberList = phoneNumberList;
    }

    public String getName() {
        return name;
    }

    public List<Object> getPhoneNumberList() {
        return new ArrayList<>(phoneNumberList);
    }
}
