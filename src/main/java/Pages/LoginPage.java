package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.Driver.getDriver;

@Getter

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public static final String url = "https://www.saucedemo.com/";

    @FindBy(id = "user-name")
    private WebElement loginInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement loginButton;

    public LoginPage open() {
        getDriver().get(url);
        return new LoginPage();
    }

    public MainPage authorize() {
//        String login, String password
        System.out.println("Enter login");
        loginInput.sendKeys("standard_user");

        System.out.println("Enter pass");
        passwordInput.sendKeys("secret_sauce");

        System.out.println("Click 'Login' button");
        loginButton.click();
        return new MainPage();
    }
}
