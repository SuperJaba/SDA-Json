package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by RENT on 2017-03-02.
 */
public class Main {
    ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        User user1 = new User(); //tworzenie nowego Usera -> user1
        user1.setFirstName("Jan");
        user1.setLastName("Kowalski");

        Address address1 = new Address(); //tworzenie nowego obiektu Address o nazwie address1
        address1.setCity("Poznan"); //przypisanie miasta do pola city
        address1.setPostalCode("61-100"); //przypisanie kodu pocztowego do postalCode
        address1.setStreet("Nowowiejskiego"); //przypisanie nazwy miasta do pola street

        Address address2 = new Address(); //jak wyzej dla address2
        address2.setPostalCode("61-200");
        address2.setStreet("Kurlaandzka");
        address2.setCity("Klodzko");

        Map<String, Address> adresses = new HashMap<>(); //tworzenie nowego obiektu HashMap<k,V> o nazwie addresses
        adresses.put("Home", address1);//
        adresses.put("Work", address2);

        user1.setAddresses(adresses);

        List<String> childrenNames = Arrays.asList("Marek", "Mikolaj");
        user1.setChildrenName(childrenNames);

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(user1);

        System.out.println(json);
        //TODO dopisac ArrayList i przeparsowac na JSON
    }

    public void getArrayList() {
        arrayList.add(1, "Jan");
        arrayList.add(2, "Kowalski");


    }
}
