package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPageElements extends BasePageElement {

    public SearchPageElements(final WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@data-search-position=1]//*[@class='ticket-photo loaded']")
    private WebElement openCarFromSearchResults;

    public WebElement getOpenCarFromSearchResults() {
        return openCarFromSearchResults;
    }

    @FindBy(xpath = "//h1[@class='head']")
    private WebElement openCarTitle;

    public WebElement getOpenCarTitle() {
        return openCarTitle;
    }


    @FindBy(xpath = "//*[@data-search-position=1]//*[@class='icon-favorite-head']")
    private WebElement firstCarToFavorites;

    public WebElement getFirstCarToFavorites() {
        return firstCarToFavorites;
    }

    @FindBy(xpath = "//h1[@class='head']")
    private WebElement nameOfCarToFavorites;

    public WebElement getNameOfCarToFavorites() {
        return nameOfCarToFavorites;
    }

    @FindBy(xpath = "//a[contains(text(), 'показати')] ")
    private WebElement buttonShowSellerNumber;

    public WebElement getButtonShowSellerNumber() {
        return buttonShowSellerNumber;
    }

    @FindBy(xpath = "//*[@class='list-phone']/div[@class='bold mb-10']")
    private WebElement blockFullMobilePhone;

    public WebElement getBlockFullMobilePhone() {
        return blockFullMobilePhone;
    }


}