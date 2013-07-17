package spencer.dean.cakery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

    private WebDriver driver;
    private String baseUrl;
    private String pageUrl = Pages.LOGIN.url();

    @FindBy(css=".row .twelve.columns h1")
    private WebElement header;

    @FindBy(id="user_email")
    private WebElement email;

    @FindBy(id="user_password")
    private WebElement password;

    @FindBy(name="login")
    private WebElement login;

    @FindBy(css=".alert.danger")
    private List<WebElement> errors;

    Login(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
        PageFactory.initElements(driver, this);
    }

    public void load() {
        driver.get(baseUrl + pageUrl);
    }

    public Dashboard loginWithGoodCredentials(Users user) {
        login(user);
        return new Dashboard(driver, baseUrl);
    }

    public Login loginWithBadCredentials(Users user) {
        login(user);
        return this;
    }

    public WebElement getHeader() {
        return header;
    }
    
    public List<WebElement> getErrors() {
    	return errors;
    }

    private void login(Users user) {
        email.sendKeys(user.email());
        password.sendKeys(user.password());
        login.click();
    }
}