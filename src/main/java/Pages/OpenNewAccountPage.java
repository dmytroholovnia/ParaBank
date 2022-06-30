package Pages;

import Core.Waiter;
import Enums.Types;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

@Getter

public class OpenNewAccountPage extends BasePage {

    public OpenNewAccountPage (WebDriver driver, Waiter waiter) {
        super(driver);
        this.waiter = waiter;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "type")
    WebElement typeSelector;

    @FindBy(xpath = "//input[@class='button']")
    WebElement openAccountButton;

    public void selectType(Types type) {
        waiter.waitAllRequest();
        Select select = new Select(typeSelector);
        select.selectByVisibleText(String.valueOf(type));
        waiter.waitAllRequest();
    }

    public void openNewAccount() {
        waiter.waitAllRequest();
        openAccountButton.click();
        waiter.waitForElement(By.xpath("//div[@id='rightPanel']//a"));
    }

    public String getAccountId() {
        return getRightPanel().findElement(By.xpath("//a")).getText();
    }
}
