import Enums.Types;
import Pages.LoginPage;
import Pages.MainPage;
import Pages.OpenNewAccountPage;
import org.junit.Test;

import static org.junit.Assert.*;

public class OpenNewAccountTest extends BaseTest {

    @Test
    public void createCheckingAccount() {
        LoginPage loginPage = new LoginPage(driver);
        OpenNewAccountPage openNewAccountPage = new OpenNewAccountPage(driver, waiter);
        Types type = Types.SAVINGS;

        final String login = Helper.getProperty("login");
        final String password = Helper.getProperty("pass");

        System.out.println("Open login page");
        loginPage.open(driver);

        MainPage mainPage =  loginPage.authorize(login, password);

        assertEquals("Title is incorrect",
                "Accounts Overview",
                mainPage.getPageTitle().getText());

        assertTrue("Accounts table is not present!",
                mainPage.getAccountTable().isDisplayed());

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
