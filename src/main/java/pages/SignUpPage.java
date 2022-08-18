package pages;

import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final String signUpMessage = "Your account was created successfully. You are now logged in.";

    @FindBy(xpath = "//input[@id='customer.firstName']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='customer.lastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='customer.address.street']")
    private WebElement addressInput;

    @FindBy(xpath = "//input[@id='customer.address.city']")
    private WebElement cityInput;

    @FindBy(xpath = "//input[@id='customer.address.state']")
    private WebElement stateInput;

    @FindBy(xpath = "//input[@id='customer.address.zipCode']")
    private WebElement zipCodeInput;

    @FindBy(xpath = "//input[@id='customer.phoneNumber']")
    private WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@id='customer.ssn']")
    private WebElement ssnInput;

    @FindBy(xpath = "//input[@id='customer.username']")
    private WebElement usernameInput;

    @FindBy(xpath = "//input[@id='customer.password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@id='repeatedPassword']")
    private WebElement confirmInput;

    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;

    @Step("Fill customer data")
    public void fillCustomerData(String firstName,
                                 String lastName,
                                 String address,
                                 String city,
                                 String state,
                                 String zip,
                                 String phone,
                                 String ssn,
                                 String login,
                                 String password,
                                 String confirm) {

        logger.log("Enter First Name: " + firstName);
        firstNameInput.sendKeys(firstName);

        logger.log("Enter Last Name: " + lastName);
        lastNameInput.sendKeys(lastName);

        logger.log("Enter Address: " + address);
        addressInput.sendKeys(address);

        logger.log("Enter City: " + city);
        cityInput.sendKeys(city);

        logger.log("Enter State: " + state);
        stateInput.sendKeys(state);

        logger.log("Enter ZIP: " + zip);
        zipCodeInput.sendKeys(zip);

        logger.log("Enter phone: " + phone);
        phoneNumberInput.sendKeys(phone);

        logger.log("Enter SSN: " + ssn);
        ssnInput.sendKeys(ssn);

        logger.log("Enter Username: " + login);
        usernameInput.sendKeys(login);

        logger.log("Enter password: " + password);
        passwordInput.sendKeys(password);

        logger.log("Confirm password: " + confirm);
        confirmInput.sendKeys(confirm);
    }

    @Step("Click 'Register' button")
    public void registerCustomer() {
        registerButton.click();
    }

}
