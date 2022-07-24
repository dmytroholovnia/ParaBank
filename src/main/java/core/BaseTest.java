package core;

import helper.Helper;
import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Locale;

public class BaseTest {

    protected WebDriver driver;
    protected Waiter waiter;
    protected String login;
    protected String password;
    protected Faker data;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new Driver().getDriver(getOptions());
        waiter = new Waiter(driver);
        login = Helper.getProperty("login");
        password = Helper.getProperty("pass");
        data = new Faker(new Locale("en"));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private ChromeOptions getOptions() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems for Jenkins
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--headless");

        return options;
    }
}
