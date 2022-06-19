import Pages.LoginPage;
import org.junit.Test;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authorization() {
        LoginPage loginPage = new LoginPage();

        final String login = Helper.getProperty("login");
        final String password = Helper.getProperty("pass");

        System.out.println("Open login page");
        loginPage.open();

        loginPage.authorize(login, password);
    }

}
