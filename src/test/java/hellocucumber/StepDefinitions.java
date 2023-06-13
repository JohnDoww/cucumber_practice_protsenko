package hellocucumber;

import helpers.CommonPageMethods;
import helpers.SearchPageMethods;
import helpers.UserPageMethods;
import io.cucumber.java.en.*;

import org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.WebDriver;
import pages.CommonPageElements;
import pages.SearchPageElements;
import pages.UserPageElements;
import utils.WebDriverFactory;

import static utils.PropertiesFactory.getProperty;

public class StepDefinitions {

    private WebDriver driver = ;
    private CommonPageElements commonPageElements;
    private CommonPageMethods commonPageMethods;
    private UserPageElements userPageElements;
    private UserPageMethods userPageMethods;
    private SearchPageElements searchPageElements;
    private SearchPageMethods searchPageMethods;
    private final WebDriverFactory webDriverFactory = WebDriverFactory.getInstance();

        driver = webDriverFactory.getDriver("chrome");
        driver.get(getProperty("auto_ria_url"));


    commonPageElements = new CommonPageElements(driver);
        commonPageMethods = new CommonPageMethods(driver, commonPageElements);
        userPageElements = new UserPageElements(driver);
        userPageMethods = new UserPageMethods(driver, userPageElements);
        searchPageElements = new SearchPageElements(driver);
        searchPageMethods = new SearchPageMethods(driver, searchPageElements);

    @Given("an example scenario")
    public void anExampleScenario() {
    }

    @When("all step definitions are implemented")
    public void allStepDefinitionsAreImplemented() {
    }

    @Then("the scenario passes")
    public void theScenarioPasses() {
    }

}
