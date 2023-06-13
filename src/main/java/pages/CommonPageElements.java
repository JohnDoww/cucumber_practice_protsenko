package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CommonPageElements extends BasePageElement {

    public CommonPageElements(final WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@title='Use ANY Inbox you want @mailinator.com !']")
    private WebElement emailInputMailinator;

    public WebElement getEmailInputMailinator() {
        return emailInputMailinator;
    }

    @FindBy(className = "primary-btn")
    private WebElement buttonCreateEmail;

    public WebElement getButtonCreateEmail() {
        return buttonCreateEmail;
    }

    @FindBy(linkText = "Увійти в кабінет")
    private WebElement logInSignIn;

    public WebElement getLogInSignIn() {
        return logInSignIn;
    }

    @FindBy(xpath = "//iframe[@id]")
    private WebElement loginFrameRia;

    public WebElement getLoginFrameRia() {
        return loginFrameRia;
    }

    @FindBy(xpath = "//a[contains(text(), 'Зареєструватися')]")
    private WebElement registrationButton;

    public WebElement getRegistrationButton() {
        return registrationButton;
    }

    @FindBy(id = "registrationform-name")
    private WebElement nameRegistration;

    public WebElement getNameRegistration() {
        return nameRegistration;
    }

    @FindBy(id = "registrationform-second_name")
    private WebElement secondNameRegistration;

    public WebElement getSecondNameRegistration() {
        return secondNameRegistration;
    }

    @FindBy(id = "registrationform-email")
    private WebElement inputEmailRegistration;

    public WebElement getInputEmailRegistration() {
        return inputEmailRegistration;
    }

    @FindBy(xpath = "//input[@id='registrationform-agree']")
    private WebElement registrationFormAgree;

    public WebElement getRegistrationFormAgree() {
        return registrationFormAgree;
    }

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement submitRegistrationForm;

    public WebElement getSubmitRegistrationForm() {
        return submitRegistrationForm;
    }

    @FindBy(xpath = "//td[contains(text(), 'RIA')]")
    private WebElement openLetterConfirm;

    public WebElement getOpenLetterConfirm() {
        return openLetterConfirm;
    }

    @FindBy(id = "html_msg_body")
    private WebElement codeAreaFrame;

    public WebElement getCodeAreaFrame() {
        return codeAreaFrame;
    }

    @FindBy(xpath = "//h2[@style='background: #f3f3f3']")
    private WebElement codeFromEmailLetter;

    public WebElement getCodeFromEmailLetter() {
        return codeFromEmailLetter;
    }

    @FindBy(id = "login_frame")
    private WebElement loginFrame2;

    public WebElement getLoginFrame2() {
        return loginFrame2;
    }

    @FindBy(id = "secure_code")
    private WebElement inputCodeFromEmail;

    public WebElement getInputCodeFromEmail() {
        return inputCodeFromEmail;
    }

    @FindBy(xpath = "//input[@id='new_pass']")
    private WebElement inputPassword;

    public WebElement getInputPassword() {
        return inputPassword;
    }


    @FindBy(xpath = "//input[@id='confirm_new']")
    private WebElement confirmPassword;

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }


    @FindBy(tagName = "button")
    private WebElement submitRegistration;

    public WebElement getSubmitRegistration() {
        return submitRegistration;
    }


    @FindBy(id = "brandTooltipBrandAutocomplete-brand")
    private WebElement inputCarMaker;

    public WebElement getInputCarMaker() {
        return inputCarMaker;
    }


    @FindBy(xpath = "//li[@data-value='28']")
    private WebElement hondaInList;

    public WebElement getHondaInList() {
        return hondaInList;
    }


    @FindBy(xpath = "//*[@class='m-rows e-year']")
    private WebElement inputCarYear;

    public WebElement getInputCarYear() {
        return inputCarYear;
    }


    @FindBy(id = "yearFrom")
    private WebElement inputCarYearFrom;

    public WebElement getInputCarYearFrom() {
        return inputCarYearFrom;
    }


    @FindBy(id = "yearTo")
    private WebElement inputCarYearTo;

    public WebElement getInputCarYearTo() {
        return inputCarYearTo;
    }


    @FindBy(css = "button[type*=submit]")
    private WebElement buttonSearchCar;

    public WebElement getButtonSearchCar() {
        return buttonSearchCar;
    }

    @FindBy(xpath = "//*[@class='wrapping']")
    private WebElement emptySpaceHomePage;

    public WebElement getEmptySpaceHomePage() {
        return emptySpaceHomePage;
    }

    @FindBy(xpath = "//*[@for='brandTooltipBrandAutocompleteInput-brand']")
    private WebElement titleMakerInHomePager;

    public WebElement getTitleMakerInHomePager() {
        return titleMakerInHomePager;
    }

    @FindBy(id = "emailloginform-email")
    private WebElement inputEmailLogIn;

    public WebElement getInputEmailLogIn() {
        return inputEmailLogIn;
    }

    @FindBy(id = "emailloginform-password")
    private WebElement inputPasswordLogIn;

    public WebElement getInputPasswordLogIn() {
        return inputPasswordLogIn;
    }

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitLogIn;

    public WebElement getSubmitLogIn() {
        return submitLogIn;
    }


    @FindBy(xpath = "//a[@data-type='bu']")
    private WebElement buttonBuCar;

    public WebElement getButtonBuCar() {
        return buttonBuCar;
    }

    @FindBy(xpath = "//*[@class='news-personal-list unstyle']/*[1]")
    private WebElement thirdArticle;

    public WebElement getThirdArticle() {
        return thirdArticle;
    }

    @FindBy(xpath = "//*[@data-type='news']")
    private WebElement newsButton;

    public WebElement getNewsButton() {
        return newsButton;
    }

    @FindBy(xpath = "//h1")
    private WebElement titleOpenedArticle;

    public WebElement getTitleOpenedArticle() {
        return titleOpenedArticle;
    }

    @FindBy(xpath = "//*[@class='news-personal-list unstyle']/*[3]")
    private WebElement articleBox;

    public WebElement getArticleBox() {
        return articleBox;
    }
}
