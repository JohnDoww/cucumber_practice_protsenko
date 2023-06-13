package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserPageElements extends BasePageElement {

    public UserPageElements(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='unlink name']")
    private WebElement userInfo;

    public WebElement getUserInfo() {
        return userInfo;
    }

    @FindBy(xpath = "//*[@id='headerBookmarksLink']")
    private WebElement openFavorites;

    public WebElement getOpenFavorites() {
        return openFavorites;
    }

    @FindBy(xpath = "//*[@class='notepad-tickets']/div[1]//*[@id='mainPhotoBlock']")
    private WebElement lastCarAddedToFavorites;

    public WebElement getLastCarAddedToFavorites() {
        return lastCarAddedToFavorites;
    }

}