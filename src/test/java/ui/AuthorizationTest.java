package ui;

import core.BaseTest;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Ignore;
import pages.LoginPage;
import pages.MainPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AuthorizationTest extends BaseTest {

    @Test
    public void authorization() {
        LoginPage loginPage = new LoginPage(driver);

        logger.log("Open login page");
        loginPage.open(driver);

        MainPage mainPage = loginPage.authorize(login, password);

        assertEquals("Title is incorrect",
                     "Accounts Overview",
                             mainPage.getPageTitle().getText());

        assertTrue("Accounts table is not present!",
                             mainPage.getAccountTable().isDisplayed());
    }

    @Test
    @Ignore
    public void authorizationFailed() {
        LoginPage loginPage = new LoginPage(driver);

        final String expectedMessage = "The username and password could not be verified.";
        login = RandomStringUtils.randomAlphabetic(10);
        password = RandomStringUtils.randomAlphabetic(10);

        logger.log("Open login page");
        loginPage.open(driver);

        loginPage.authorize(login, password);

        assertEquals("Error title is incorrect",
                     "Error!",
                     loginPage.getErrorTitle().getText());

        assertEquals("Error message is incorrect!",
                             expectedMessage,
                             loginPage.getErrorMessage().getText());
    }

}
