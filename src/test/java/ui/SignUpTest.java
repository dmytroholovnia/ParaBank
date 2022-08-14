package ui;

import core.BaseTest;
import models.User;
import org.junit.Before;
import org.junit.Test;
import pages.LoginPage;
import pages.SignUpPage;

import static org.junit.Assert.assertEquals;

public class SignUpTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage(driver);

    @Before
    public void authorize() {
        loginPage.open(driver);
    }

    @Test
    public void signUp() {
        User user = new User();

        System.out.println("Click 'Register button' on Login page");
        SignUpPage signUpPage = loginPage.clickRegister();

        signUpPage.fillCustomerData(
                                    user.getFirstName(),
                                    user.getLastName(),
                                    user.getAddress(),
                                    user.getCity(),
                                    user.getState(),
                                    user.getZip(),
                                    user.getPhone(),
                                    user.getSsn(),
                                    user.getLogin(),
                                    user.getPassword(),
                                    user.getConfirm()
        );

        System.out.println("Click 'Register' button on SignUp page");
        signUpPage.registerCustomer();

        assertEquals("User hasn't been created!",
                "Welcome " + user.getLogin(),
                        signUpPage.getTitle().getText());

        assertEquals("Message is incorrect!",
                            signUpPage.getSignUpMessage(),
                            signUpPage.getMessage().getText());
    }
}
