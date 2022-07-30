package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Driver {

    private WebDriver driver;

    public WebDriver getDriver(ChromeOptions options) {
        if(driver == null) {
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();
        }

        return driver;
    }
}
