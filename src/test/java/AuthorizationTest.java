import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static Core.Driver.getDriver;

public class AuthorizationTest {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        getDriver();
    }

    @Test
    public void authorization() {
        LoginPage loginPage = new LoginPage();

        final String login = Helper.getProperty("login");
        final String password = Helper.getProperty("pass");

        System.out.println("Open login page");
        loginPage.open();

        loginPage.authorize(login, password);
    }

    @After
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
