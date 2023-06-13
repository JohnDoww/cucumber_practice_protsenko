package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.SearchPageElements;

import java.time.Duration;

public class SearchPageMethods extends BasePageMethods {

    WebDriver driver;
    SearchPageElements searchPageElements;

    public SearchPageMethods(WebDriver driver, SearchPageElements searchPageElements) {
        super(driver);
        this.driver = driver;
        this.searchPageElements = searchPageElements;
    }

    /**
     * This method returns name of car which is opened from the search results page
     */
    public String makerTitleInSearchedCar() {
        driver.navigate().refresh();
        searchPageElements.getOpenCarFromSearchResults().click();
        return searchPageElements.getOpenCarTitle().getText();
    }

    /**
     * This method opens the list of used car by clicking on the button "Вживані Авто" on the home page.
     * Also, from the list add the first car to favorites and return this car name.
     */
    public String addBuCarToFavorites() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        wait.until(ExpectedConditions.elementToBeClickable(searchPageElements.getFirstCarToFavorites()));
        searchPageElements.getFirstCarToFavorites().click();

        searchPageElements.getOpenCarFromSearchResults().click();
        return searchPageElements.getNameOfCarToFavorites().getText();
    }

    /**
     * The method opens first car from search results page
     */
    public void openFirstCarFromSearch() {
        searchPageElements.getOpenCarFromSearchResults().click();
    }

    /**
     * This method opens the popup with mobile phone of seller on the car page
     */
    public void showSellerMobile() {
        searchPageElements.getButtonShowSellerNumber().click();
    }
}