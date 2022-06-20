package Pages;

import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;
    protected static final String url = "https://parabank.parasoft.com/";

    public LoginPage open(WebDriver driver) {
        this.driver = driver;
        driver.get(url);
        return new LoginPage(driver);
    }
}
