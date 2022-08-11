package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Helper {

    public static String getProperty(String name) {

        try (InputStream inputStream = Helper.class.getClassLoader().getResourceAsStream("credentials.properties")) {
            Properties properties = new Properties();

            if (inputStream == null) {
                System.out.println("File credentials.properties hasn't been found!");
                return null;
            }

            properties.load(inputStream);

            return properties.getProperty(name);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return name;
    }

//    public boolean isElementPresent(String locator) {
//        List<WebElement> elements = Driver.getDriver().findElements(By.xpath(locator));
//
//        return elements.size() != 0;
//    }

    public static By getByFromElement(WebElement element) {
        By by;
        //[[ChromeDriver: chrome on XP (d85e7e220b2ec51b7faf42210816285e)] -> xpath: //input[@title='Search']]
        String[] pathVariables = (element
                .toString()
                .split("->")[1].replaceFirst("(?s)(.*)]", "$1" + ""))
                .split(":");

        String selector = pathVariables[0].trim();
        String value = pathVariables[1].trim();

        switch (selector) {
            case "id":
                by = By.id(value);
                break;
            case "className":
                by = By.className(value);
                break;
            case "tagName":
                by = By.tagName(value);
                break;
            case "xpath":
                by = By.xpath(value);
                break;
            case "cssSelector":
                by = By.cssSelector(value);
                break;
            case "linkText":
                by = By.linkText(value);
                break;
            case "name":
                by = By.name(value);
                break;
            case "partialLinkText":
                by = By.partialLinkText(value);
                break;
            default:
                throw new IllegalStateException("locator : " + selector + " not found!");
        }
        return by;
    }

    public static int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }
}
