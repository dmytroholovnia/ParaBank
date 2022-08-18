package models;

import com.github.javafaker.Faker;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Locale;

@Getter
@Setter

public class User {

    private int customerId;
    private int accountId;

    private final Faker data = new Faker(new Locale("en"));
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String ssn;
    private String login;
    private String password;
    private String confirm;


    public User() {
        this.customerId = 12212;
        this.accountId = 13344;
        this.firstName = data.name().firstName();
        this.lastName = data.name().lastName();
        this.address = data.address().streetAddress();
        this.address = data.address().cityName();
        this.city = data.address().cityName();
        this.state = data.address().state();
        this.zip = RandomStringUtils.randomNumeric(5);
        this.phone = data.phoneNumber().cellPhone();
        this.ssn = RandomStringUtils.randomNumeric(4);
        this.login = firstName + lastName + ssn;
        this.password = RandomStringUtils.randomAlphabetic(10);
        this.confirm = password;
    }
}
