package pl.sda.json;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//POJO
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class User {
    private String firstName;
    private String lastName;

    private Map<String, Address> addresses = new HashMap<>();

    private List<String> childrenName = new ArrayList<>();

    public List<String> getChildrenName() {
        return childrenName;
    }

    public void setChildrenName(List<String> childrenName) {
        this.childrenName = childrenName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Map<String, Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(Map<String, Address> addresses) {
        this.addresses = addresses;
    }
}
