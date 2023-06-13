package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePageElement {
    public WebDriver driver;

    public BasePageElement(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

}