package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
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

    @FindBy(xpath = "//a[text()='Register']")
    private WebElement registerButton;

    @Step("Authorize")
    public MainPage authorize(String login, String password) {
        logger.log("Enter login");
        loginInput.sendKeys(login);

        logger.log("Enter pass");
        passwordInput.sendKeys(password);

        logger.log("Click 'Login' button");
        loginButton.click();
        return new MainPage(driver);
    }

    @Step("Click 'Register' button")
    public SignUpPage clickRegister() {
        registerButton.click();
        return new SignUpPage(driver);
    }
}
