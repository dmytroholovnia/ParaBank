import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static Core.Driver.getDriver;

public class BaseTest {

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        getDriver();
    }

    @After
    public void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }
}
