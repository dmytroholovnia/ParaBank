import Pages.LoginPage;
import Pages.MainPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authorization() {
        LoginPage loginPage = new LoginPage();

        final String login = Helper.getProperty("login");
        final String password = Helper.getProperty("pass");

        System.out.println("Open login page");
        loginPage.open();

        MainPage mainPage =  loginPage.authorize(login, password);

        assertEquals("Title is incorrect",
                     "Accounts Overview",
                             mainPage.getPageTitle().getText());

        assertTrue("Accounts table is not present!",
                             mainPage.getAccountTable().isDisplayed());
    }

    @Test
    public void authorizationFailed() {
        LoginPage loginPage = new LoginPage();

        final String login = RandomStringUtils.randomAlphabetic(10);
        final String password = RandomStringUtils.randomAlphabetic(10);
        final String expectedMessage = "The username and password could not be verified.";

        System.out.println("Open login page");
        loginPage.open();

        loginPage.authorize(login, password);

        assertEquals("Error title is incorrect",
                     "Error!",
                     loginPage.getErrorTitle().getText());

        assertEquals("Eror message is incorrect!",
                             expectedMessage,
                             loginPage.getErrorMessage().getText());
    }

}
