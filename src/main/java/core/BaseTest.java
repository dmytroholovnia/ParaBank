package core;

import helper.Helper;
import helper.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    protected WebDriver driver;
    protected Waiter waiter;
    protected String login;
    protected String password;
    protected Logger logger;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new Driver().getDriver(getOptions());
        waiter = new Waiter(driver);
        login = Helper.getProperty("login");
        password = Helper.getProperty("pass");
        logger = new Logger();
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
