package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.Driver.getDriver;

@Getter

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(getDriver(), this);
    }

//    public static final String url = "https://parabank.parasoft.com/";

    @FindBy(name = "username")
    private WebElement loginInput;

    @FindBy(name = "password")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@value='Log In']")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@id='rightPanel']//h1")
    private WebElement errorTitle;

    @FindBy(xpath = "//div[@id='rightPanel']//p")
    private WebElement errorMessage;

//    public void open() {
//        getDriver().get(url);
//        new LoginPage();
//    }

    public MainPage authorize(String login, String password) {
        System.out.println("Enter login");
        loginInput.sendKeys(login);

        System.out.println("Enter pass");
        passwordInput.sendKeys(password);

        System.out.println("Click 'Login' button");
        loginButton.click();
        return new MainPage();
    }
}
