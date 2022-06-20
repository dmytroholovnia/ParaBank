package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



@Getter

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

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

    public MainPage authorize(String login, String password) {
        System.out.println("Enter login");
        loginInput.sendKeys(login);

        System.out.println("Enter pass");
        passwordInput.sendKeys(password);

        System.out.println("Click 'Login' button");
        loginButton.click();
        return new MainPage(driver);
    }
}
