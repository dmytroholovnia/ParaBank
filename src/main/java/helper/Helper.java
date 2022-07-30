package helper;

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
}
