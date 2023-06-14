package hellocucumber;

import helpers.CommonPageMethods;
import helpers.SearchPageMethods;
import helpers.UserPageMethods;
import io.cucumber.java.After;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.openqa.selenium.WindowType;
import pages.CommonPageElements;
import pages.SearchPageElements;
import pages.UserPageElements;
import utils.WebDriverFactory;

import java.util.ArrayList;

import static utils.PropertiesFactory.getProperty;


public class StepDefinitions {


    private final WebDriverFactory webDriverFactory = WebDriverFactory.getInstance();
    WebDriver driver = webDriverFactory.getDriver("chrome");

    CommonPageElements commonPageElements = new CommonPageElements(driver);
    CommonPageMethods commonPageMethods = new CommonPageMethods(driver, commonPageElements);
    SearchPageElements searchPageElements = new SearchPageElements(driver);
    SearchPageMethods searchPageMethods = new SearchPageMethods(driver, searchPageElements);
    UserPageElements userPageElements = new UserPageElements(driver);
    UserPageMethods userPageMethods = new UserPageMethods(driver, userPageElements);


    String makerTitleFromHomePage;
    String carTitleFromSearch;
    String expectedArticleTitle;
    String actualArticleTitle;
    String codeFromEmail;
    String registrationFullName;
    String fullNamInProfile;
    String fromSellerInfo = "Телефонуйте, продавець ";
    String carFromFavorites;
    String nameCarToFavorites;


    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("created email")
    public void createEmailForRegistration() {
        commonPageMethods.createTestEmail();
    }

    @When("fill in registration form on home page")
    public void startingRegistration() {
        driver.switchTo().newWindow(WindowType.TAB);
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        commonPageMethods.fillRegistrationForm1();
        driver.switchTo().window(tabs.get(0));
        codeFromEmail = commonPageMethods.receiveRegistrationCode();
        driver.switchTo().window(tabs.get(1));
    }

    @And("submit registration form")
    public void finishedRegistration() {
        commonPageMethods.fillRegistrationForm2(codeFromEmail);
        registrationFullName = commonPageMethods.userFullName;
        fullNamInProfile = userPageElements.getUserInfo().getText();
    }

    @Then("user is created")
    public void checkUserPage() {
        assertThat(registrationFullName).containsIgnoringWhitespaces(fullNamInProfile);
    }

    @Given("open home page")
    public void openAutoRia() {
        driver.get(getProperty("auto_ria_url"));
    }

    @When("open tab with BU cars")
    public void openTabBuCars() {
        commonPageElements.getButtonBuCar().click();
    }

    @And("add car to favorites")
    public void addCarToFavorites() {
        nameCarToFavorites = searchPageMethods.addBuCarToFavorites();
    }

    @Then("added car is exist in user's favorites list")
    public void checkFavoritesList() {
        carFromFavorites = userPageMethods.titleFirstCarFromFavorites();
        assertThat(nameCarToFavorites).containsIgnoringWhitespaces(carFromFavorites);
    }

    @When("search car by using filer")
    public void searchHondaCars() {
        makerTitleFromHomePage = commonPageMethods.searchOldCarHonda();
        carTitleFromSearch = searchPageMethods.makerTitleInSearchedCar();
    }

    @Then("honda car is open")
    public void openHondaCarFromSearchResult() {
        assertThat(carTitleFromSearch).containsIgnoringWhitespaces(makerTitleFromHomePage);
    }


    @When("search random car by using filer")
    public void findAnyCar() {
        commonPageMethods.findAnyCar();
    }

    @And("open car from search list")
    public void openFirstCarFromSearch() {
        searchPageMethods.openFirstCarFromSearch();
        searchPageMethods.showSellerMobile();
    }

    @Then("mobile number is shows")
    public void openingSellerInfo() {
        String phrase = searchPageElements.getBlockFullMobilePhone().getText();
        assertThat(phrase).containsAnyOf(fromSellerInfo);
    }


    @When("follow to the article page")
    public void openArticlesPage() {
        commonPageElements.getNewsButton().click();
        expectedArticleTitle = commonPageMethods.nameAdvertisedArticle();
    }

    @And("open article")
    public void openArticle() {
        actualArticleTitle = commonPageMethods.titleOfOpenedArticle();
    }

    @Then("title and link name of article are matched")
    public void compareNameOfArticleAndTitle() {
        assertThat(expectedArticleTitle).containsIgnoringWhitespaces(actualArticleTitle);
    }


}
