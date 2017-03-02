package pl.sda.json;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by RENT on 2017-03-02.
 */
public class JsonMapperTest {
    @Test
    public void test1() throws IOException {
        String jsonToDeserialiaz = "{\"firstName\":\"Jan\",\"lastName\":\"Kowalski\"," +
                "\"addresses\":{\"Work\":{\"street\":\"Kurlaandzka\",\"postalCode\":\"61-200\"," +
                "\"city\":\"Klodzko\"},\"Home\":{\"street\":\"Nowowiejskiego\",\"postalCode\":\"61-100\"," +
                "\"city\":\"Poznan\"}},\"childrenName\":[\"Marek\",\"Mikolaj\"]}\n";

        //TODO dopisac Assert dla pozostałych pól

        ObjectMapper mapper = new ObjectMapper();
        User user = mapper.readValue(jsonToDeserialiaz, User.class);//

        Assert.assertEquals("Jan", user.getFirstName());
        Assert.assertNotNull(user.getChildrenName());
        Assert.assertTrue(user.getChildrenName() != null);
        Assert.assertTrue(user.getChildrenName().size() == 2);
        Assert.assertEquals(Arrays.asList("Marek", "Mikolaj"), user.getChildrenName());
    }

    @Test
    public void test2() throws IOException {
        User user1 = new UserBuilder().withFirstName("Jan").withLastName("Kowalski")
                .withAddress("Work", new AddressBuilder().withCity("Poznan").withStreet("Baraniaka").withPostalCode("61-100").build())
                .withAddress("Home", new AddressBuilder().withCity("Warszawa").withStreet("Mokotowska").withPostalCode("00-111").build())
                .withChildrenNames(Arrays.asList("Marek", "Zosia"))
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String serializedObcject = mapper.writeValueAsString(user1);
//takich maperow raczej sie nie testuje,
        Assert.assertTrue(serializedObcject.contains("\"firstName\":\"Jan\""));
        Assert.assertTrue(serializedObcject.contains("Kowalski"));
        Assert.assertTrue(serializedObcject.contains("Marek"));
    }

    @Test
    public void test3() throws IOException {
        User user2 = new UserBuilder().withFirstName("Jan").withLastName("Kowalski")
                .withAddress("Work", new AddressBuilder().withCity("Poznan").withStreet("Baraniaka").withPostalCode("61-100").build())
                .withAddress("Home", new AddressBuilder().withCity("Warszawa").withStreet("Mokotowska").withPostalCode("00-111").build())
                .withChildrenNames(null)
                .build();

        ObjectMapper mapper = new ObjectMapper();
        String serializedObcject = mapper.writeValueAsString(user2);
        System.out.println(serializedObcject);

    }

}
