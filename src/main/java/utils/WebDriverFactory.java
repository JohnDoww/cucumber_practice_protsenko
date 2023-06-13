package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static utils.PropertiesFactory.getProperty;

public class WebDriverFactory {

    private static WebDriverFactory instance = null;
    private WebDriver driver;


    public WebDriver getDriver (final String nameOfBrowser) {
        switch (nameOfBrowser.toLowerCase()) {
            case "chrome" -> {
                System.setProperty("webdriver.chrome.driver", getProperty("path_to_chromedriver"));
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                System.setProperty("webdriver.firefox.driver", getProperty("path_to_firefoxdriver"));
                driver = new FirefoxDriver();
            }
            default -> System.setProperty("webdriver.chrome.driver", getProperty("path_to_chromedriver"));
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(35));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        return driver;
    }

    public static WebDriverFactory getInstance() {
        if (instance == null) {
            instance = new WebDriverFactory();
        }
        return instance;
    }
}