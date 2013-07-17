package spencer.dean.cakery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Drivers;
import spencer.dean.cakery.Environments;
import spencer.dean.cakery.Logout;

public class ControllerLogoutTest {

    private WebDriver driver;
    private String baseUrl;

    @BeforeMethod
    public void setup() {
        baseUrl = Environments.DEVELOPMENT.url();
        driver = Drivers.HTML_UNIT.newInstance();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void logout() {
        Logout logout = new Logout(driver, baseUrl);
        logout.load();
        Assert.assertTrue(
            driver.getCurrentUrl()
                .equals(baseUrl));
    }
}