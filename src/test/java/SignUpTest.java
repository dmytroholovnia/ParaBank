import Pages.LoginPage;
import Pages.SignUpPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage(driver);

    @Before
    public void authorize() {
        loginPage.open(driver);
    }

    @Test
    public void signUp() {
        String firstName = data.name().firstName();
        String lastName = data.name().lastName();
        String address = data.address().streetAddress();
        String city = data.address().cityName();
        String state = data.address().state();
        String zip = RandomStringUtils.randomNumeric(5);
        String phone = data.phoneNumber().cellPhone();
        String ssn = RandomStringUtils.randomNumeric(4);
        login = firstName + lastName + ssn;
        password = RandomStringUtils.randomAlphabetic(10);
        String confirm = password;

        System.out.println("Click 'Register button' on Login page");
        SignUpPage signUpPage = loginPage.clickRegister();

        signUpPage.fillCustomerData(firstName, lastName, address, city, state, zip, phone, ssn, login, password, confirm);

        System.out.println("Click 'Register' button on SignUp page");
        signUpPage.registerCustomer();

        assertEquals("User hasn't been created!",
                "Welcome " + firstName + lastName + ssn,
                        signUpPage.getTitle().getText());

        assertEquals("Message is incorrect!",
                            signUpPage.getSignUpMessage(),
                            signUpPage.getMessage().getText());
    }
}
