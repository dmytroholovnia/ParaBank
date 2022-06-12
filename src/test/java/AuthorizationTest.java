import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthorizationTest {

    private static WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void authorization() {
        LoginPage loginPage = new LoginPage();

        System.out.println("Open login page");
        loginPage.open();

        loginPage.authorize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
