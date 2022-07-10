package Pages;

import Core.Waiter;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

@Getter

public class BasePage {

    protected WebDriver driver;
    protected Waiter waiter;
    protected static final String url = "https://parabank.parasoft.com/";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open platform")
    public void open(WebDriver driver) {
        this.driver = driver;
        this.waiter = new Waiter(driver);
        driver.get(url);
        PageFactory.initElements(driver, this);
        new LoginPage(driver);
    }

    @FindBy(id = "leftPanel")
    private WebElement mainMenu;

    @FindBy(id = "rightPanel")
    private WebElement rightPanel;

    @FindBy(className = "title")
    private WebElement title;

    @FindBy(xpath = "//div[@id='rightPanel']//p")
    private WebElement message;

    @Step("Open page '{0}'")
    public void goToPage(String page) {
        mainMenu.findElement(By.xpath("//ul//li//a[text()='" + page + "']")).click();
    }
}
