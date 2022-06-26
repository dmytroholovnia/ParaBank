import Core.Driver;
import Core.Waiter;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

public class BaseTest {

    protected WebDriver driver;
    protected Waiter waiter;
    protected String login;
    protected String password;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new Driver().getDriver();
        waiter = new Waiter(driver);
        login = Helper.getProperty("login");
        password = Helper.getProperty("pass");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
