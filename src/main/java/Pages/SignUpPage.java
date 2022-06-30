package Pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter

public class SignUpPage extends BasePage {

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
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

        System.out.println("Enter First Name: " + firstName);
        firstNameInput.sendKeys(firstName);

        System.out.println("Enter Last Name: " + lastName);
        lastNameInput.sendKeys(lastName);

        System.out.println("Enter Address: " + address);
        addressInput.sendKeys(address);

        System.out.println("Enter City: " + city);
        cityInput.sendKeys(city);

        System.out.println("Enter State: " + state);
        stateInput.sendKeys(state);

        System.out.println("Enter ZIP: " + zip);
        zipCodeInput.sendKeys(zip);

        System.out.println("Enter phone: " + phone);
        phoneNumberInput.sendKeys(phone);

        System.out.println("Enter SSN: " + ssn);
        ssnInput.sendKeys(ssn);

        System.out.println("Enter Username: " + login);
        usernameInput.sendKeys(login);

        System.out.println("Enter password: " + password);
        passwordInput.sendKeys(password);

        System.out.println("Confirm password: " + confirm);
        confirmInput.sendKeys(confirm);
    }

    public void registerCustomer() {
        registerButton.click();
    }

}
