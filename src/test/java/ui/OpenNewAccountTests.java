package ui;

import core.BaseTest;
import enums.Types;
import pages.LoginPage;
import pages.MainPage;
import pages.OpenNewAccountPage;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class OpenNewAccountTests extends BaseTest {

    private final LoginPage loginPage = new LoginPage(driver);
    private MainPage mainPage;

    @Parameters
    public static Object[] accounts() {
        return new Object[]{
                Types.SAVINGS,
                Types.CHECKING
        };
    }
    @Parameter()
    public Types type;

    @Before
    public void authorize() {
        loginPage.open(driver);
        mainPage = loginPage.authorize(login, password);
    }

    @Test
    public void createAccount() {
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver, waiter);

        System.out.println("Go to page 'Open New Account'");
        mainPage.goToPage("Open New Account");

        System.out.println("Select type: " + type);
        openNewAccountPage.selectType(type);

        System.out.println("Click 'Open Account Page' button");
        openNewAccountPage.openNewAccount();

        System.out.println("Check title");
        assertEquals("Title is Incorrect!", "Account Opened!", openNewAccountPage.getTitle().getText());

        System.out.println("Check that account ID exists");
        assertNotNull("Account ID doesn't exist!", openNewAccountPage.getAccountId());
    }
}
