import Core.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;

import static Core.Driver.getDriver;

public class BaseTest {

    protected WebDriver driver;

    @Before
//    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = getDriver();
    }

    @After
//    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
