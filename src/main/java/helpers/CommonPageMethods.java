package helpers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPageElements;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static utils.PropertiesFactory.getProperty;

public class CommonPageMethods extends BasePageMethods {

    WebDriver driver;
    CommonPageElements commonPageElements;

    String generatedMailName = "sahopaho" + (int) (Math.random() * 10000);
    String userName = "Serho";
    String userSecondName = "Allho";
    String testMail = generatedMailName + "@mailinator.com";
    public String userFullName = userName + userSecondName;
    String userPassword = "Qwerty" + (int) (Math.random() * 200000);

    public CommonPageMethods(WebDriver driver, CommonPageElements commonPageElements) {
        super(driver);
        this.driver = driver;
        this.commonPageElements = commonPageElements;

    }

    /**
     * Method creates test email. Which will use during test - "registration"
     */
    public void createTestEmail() {
        driver.get(getProperty("service_for_email_url"));
        commonPageElements.getEmailInputMailinator().click();
        commonPageElements.getEmailInputMailinator().sendKeys(generatedMailName);
        commonPageElements.getButtonCreateEmail().click();

    }

    /**
     * Gill in registration form
     */
    public void fillRegistrationForm1() {
        driver.get(getProperty("auto_ria_url"));
        commonPageElements.getLogInSignIn().click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        driver.switchTo().frame(commonPageElements.getLoginFrameRia());

        commonPageElements.getRegistrationButton().click();
        commonPageElements.getNameRegistration().sendKeys(userName);
        commonPageElements.getSecondNameRegistration().sendKeys(userSecondName);
        commonPageElements.getInputEmailRegistration().sendKeys(testMail);
        Actions actions = new Actions(driver);
        actions.moveToElement(commonPageElements.getRegistrationFormAgree()).click().perform();
        commonPageElements.getSubmitRegistrationForm().click();
        driver.switchTo().defaultContent();
    }

    /**
     * Method return the code from email confirm letter
     */
    public String receiveRegistrationCode() {

        commonPageElements.getOpenLetterConfirm().click();
        driver.switchTo().frame(commonPageElements.getCodeAreaFrame());

        String codeToRegistration = commonPageElements.getCodeFromEmailLetter().getText();
        driver.switchTo().defaultContent();
        return codeToRegistration;
    }

    /**
     * Fill in registration form 2. Where we input email code and passwords
     */
    public void fillRegistrationForm2(String codeFromEmail) {
        driver.switchTo().frame(commonPageElements.getLoginFrame2());
        commonPageElements.getInputCodeFromEmail().sendKeys(codeFromEmail);
        commonPageElements.getInputPassword().sendKeys(userPassword);
        commonPageElements.getConfirmPassword().sendKeys(userPassword);
        commonPageElements.getSubmitRegistration().click();
    }

    /**
     * This method fill in search area on the home page. We search only Honda cars, which produced 1989-1999.
     * Method return Maker name to compare it in the test.
     */
    public String searchOldCarHonda( int from, int to) {
        commonPageElements.getInputCarMaker().click();
        commonPageElements.getHondaInList().click();
        String makerTitleOnHomePage = commonPageElements.getTitleMakerInHomePager().getAttribute("data-text");

        commonPageElements.getInputCarYear().click();
        Select inputCarYearFrom = new Select(commonPageElements.getInputCarYearFrom());
        inputCarYearFrom.selectByVisibleText(Integer.toString(from));
        Select inputCarYearTo = new Select(commonPageElements.getInputCarYearTo());
        inputCarYearTo.selectByVisibleText(Integer.toString(to));

        commonPageElements.getEmptySpaceHomePage().click();
        commonPageElements.getButtonSearchCar().click();
        return makerTitleOnHomePage;
    }

    /**
     * This method allows you to random scope of cars by using filter area from home page.
     * Filtering execute only by time range where cars were produced
     */
    public void findAnyCar() {
        {
            int from;
            int to;
            do {
                from = (int) (Math.random() * 36) + 1980;
                to = (int) (Math.random() * 33) + 1990;
            } while (to > from);
            commonPageElements.getInputCarYear().click();

            Select inputCarYearFrom = new Select(commonPageElements.getInputCarYearFrom());
            inputCarYearFrom.selectByVisibleText(Integer.toString(from));
            Select inputCarYearTo = new Select(commonPageElements.getInputCarYearTo());
            inputCarYearTo.selectByVisibleText(Integer.toString(to));

            commonPageElements.getEmptySpaceHomePage().click();
            commonPageElements.getButtonSearchCar().click();
        }
    }

    /**
     * There we opened and get the name article on the News page
     */
    public String nameAdvertisedArticle() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        wait.until(ExpectedConditions.visibilityOf(commonPageElements.getArticleBox()));
        String titleOfArticle = commonPageElements.getThirdArticle().getText();
        commonPageElements.getThirdArticle().click();
        return titleOfArticle;
    }

    /**
     * There we get the title of the opened article
     */
    public String titleOfOpenedArticle() {
        return commonPageElements.getTitleOpenedArticle().getText();
    }


}