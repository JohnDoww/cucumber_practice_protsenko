package helpers;

import org.openqa.selenium.WebDriver;

public class BasePageMethods {
    WebDriver driver;

    public BasePageMethods(WebDriver driver) {
        this.driver= driver;
    }
}