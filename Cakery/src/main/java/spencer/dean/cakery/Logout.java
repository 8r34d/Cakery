package spencer.dean.cakery;

import org.openqa.selenium.WebDriver;

public class Logout {

    private WebDriver driver;
    private String baseUrl;
    private String pageUrl = Pages.LOGOUT.url();

    Logout(WebDriver driver, String baseUrl) {
        this.driver = driver;
        this.baseUrl = baseUrl;
    }

    public void load() {
        driver.get(baseUrl + pageUrl);
    }
}