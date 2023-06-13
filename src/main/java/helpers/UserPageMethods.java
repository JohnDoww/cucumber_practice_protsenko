package helpers;

import org.openqa.selenium.WebDriver;
import pages.UserPageElements;


public class UserPageMethods extends BasePageMethods {

    WebDriver driver;
    UserPageElements userPageElements;

    public UserPageMethods(WebDriver driver, UserPageElements userPageElements) {
        super(driver);
        this.driver = driver;
        this.userPageElements = userPageElements;
    }

    /**
     * This method returns the name of car from favorites list
     */
    public String titleFirstCarFromFavorites() {
        userPageElements.getOpenFavorites().click();
        return userPageElements.getLastCarAddedToFavorites().getAttribute("title");
    }
}