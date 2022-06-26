import Pages.LoginPage;
import Pages.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogOutTest extends AuthorizationTest {

    @Before
    public void authorize() {
        authorization();
    }

    @Test
    public void logOut(){
        LoginPage loginPage = new LoginPage(driver);
        MainPage mainPage = new MainPage(driver);

        System.out.println("Click 'Log Out'");
        mainPage.goToPage("Log Out");

        System.out.println("Check that user is logged out");
        Assert.assertTrue("Login input is displayed", loginPage.getLoginInput().isDisplayed());
        Assert.assertTrue("Login input is displayed", loginPage.getPasswordInput().isDisplayed());
        Assert.assertTrue("Login input is displayed", loginPage.getLoginButton().isDisplayed());
    }
}
