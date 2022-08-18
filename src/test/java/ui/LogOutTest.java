package ui;

import core.BaseTest;
import pages.LoginPage;
import pages.MainPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogOutTest extends BaseTest {

    private final LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage;

    @Before
    public void authorize() {
        loginPage.open(driver);
        mainPage = loginPage.authorize(login, password);
    }

    @Test
    public void logOut(){
        logger.log("Click 'Log Out'");
        mainPage.goToPage("Log Out");

        logger.log("Check that user is logged out");
        Assert.assertTrue("Login input is displayed", loginPage.getLoginInput().isDisplayed());
        Assert.assertTrue("Login input is displayed", loginPage.getPasswordInput().isDisplayed());
        Assert.assertTrue("Login input is displayed", loginPage.getLoginButton().isDisplayed());
    }
}
