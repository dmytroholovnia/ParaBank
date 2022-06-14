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

    public void open() {
        getDriver().get(url);
        new LoginPage();
    }

    public void authorize(String login, String password) {
        System.out.println("Enter login");
        loginInput.sendKeys(login);

        System.out.println("Enter pass");
        passwordInput.sendKeys(password);

        System.out.println("Click 'Login' button");
        loginButton.click();
        new MainPage();
    }
}
