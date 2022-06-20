package Pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static Core.Driver.getDriver;

@Getter

public class MainPage {

    public MainPage() {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(xpath = "//div[@ng-if='showOverview']//h1")
    private WebElement pageTitle;

    @FindBy(id = "accountTable")
    private WebElement accountTable;
}
