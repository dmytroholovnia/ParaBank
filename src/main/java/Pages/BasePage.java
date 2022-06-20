package Pages;

import static Core.Driver.getDriver;

public class BasePage {

    protected static final String url = "https://parabank.parasoft.com/";

    public LoginPage open() {
        getDriver().get(url);
        return new LoginPage();
    }
}
