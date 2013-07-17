package spencer.dean.cakery;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.About;
import spencer.dean.cakery.Drivers;
import spencer.dean.cakery.Environments;
import spencer.dean.cakery.Home;
import spencer.dean.cakery.Pages;

public class ControllerPagesTest {

    private WebDriver driver;
    private String baseUrl;

    @BeforeTest
    public void setup() {
        baseUrl = Environments.DEVELOPMENT.url();
        driver = Drivers.HTML_UNIT.newInstance();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @Test
    public void four04() {
        driver.get(baseUrl + Pages.FOUR04.url());
        Assert.assertTrue(
            driver.findElement(By.cssSelector("#container h1")).getText()
                .equals("404 Page Not Found"));
        Assert.assertTrue(
            driver.findElement(By.cssSelector("#container p")).getText()
                .equals("The page you requested was not found."));
    }

    @Test
    public void base() {
        driver.get(baseUrl);
        Home home = new Home(driver, baseUrl);
        Assert.assertTrue(
            home.getHeader().getText()
                .equals("Home"));
    }

    @Test
    public void home() {
        Home home = new Home(driver, baseUrl);
        home.load();
        Assert.assertTrue(
            home.getHeader().getText()
                .equals("Home"));
    }

    @Test
    public void about() {
        About about = new About(driver, baseUrl);
        about.load();
        Assert.assertTrue(
            about.getHeader().getText()
                .equals("About"));
    }
}