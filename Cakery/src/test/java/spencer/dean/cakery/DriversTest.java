package spencer.dean.cakery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Drivers;
import spencer.dean.cakery.Environments;

public class DriversTest {

    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setup() {
        baseUrl = Environments.DEVELOPMENT.url();
    }

    @AfterTest
    public void teardown() {
        //
    }

    @Test
    public void chrome() {
        System.setProperty("webdriver.chrome.driver", "/home/dean/Drivers/chromedriver");
        driver = Drivers.CHROME.newInstance();
        driver.get(baseUrl);
        Assert.assertFalse(driver.getCurrentUrl().isEmpty());
        driver.quit();
    }

    @Test
    public void firefox() {
        driver = Drivers.FIREFOX.newInstance();
        driver.get(baseUrl);
        Assert.assertFalse(driver.getCurrentUrl().isEmpty());
        driver.quit();
    }

    @Test
    public void htmlUnit() {
        driver = Drivers.HTML_UNIT.newInstance();
        driver.get(baseUrl);
        Assert.assertFalse(driver.getCurrentUrl().isEmpty());
        driver.quit();
    }
}