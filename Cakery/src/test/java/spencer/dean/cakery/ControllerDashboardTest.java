package spencer.dean.cakery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Dashboard;
import spencer.dean.cakery.Drivers;
import spencer.dean.cakery.Environments;
import spencer.dean.cakery.Login;
import spencer.dean.cakery.Motd;
import spencer.dean.cakery.Pages;
import spencer.dean.cakery.Users;

public class ControllerDashboardTest {

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
    public void dashboardWhenLoggedIn() {
        Login login = new Login(driver, baseUrl);
        login.load();
        login.loginWithGoodCredentials(Users.GOOD);
        Dashboard dashboard = new Dashboard(driver, baseUrl);
        dashboard.load();
        Assert.assertTrue(
            driver.getCurrentUrl()
                .equals(baseUrl + Pages.DASHBOARD.url()));
    }

    @Test
    public void dashboardWhenLoggedOut() {
        Dashboard dashboard = new Dashboard(driver, baseUrl);
        dashboard.load();
        Assert.assertTrue(
            driver.getCurrentUrl()
                .equals(baseUrl + Pages.LOGIN.url()));
    }

    @Test
    public void motdWhenLoggedIn() {
        Login login = new Login(driver, baseUrl);
        login.load();
        login.loginWithGoodCredentials(Users.GOOD);
        Motd motd = new Motd(driver, baseUrl);
        motd.load();
        Assert.assertTrue(
            motd.getHeader().getText()
                .equals("Admin - Dashboard - MOTD"));
    }

    @Test
    public void motdWhenLoggedOut() {
        Motd motd = new Motd(driver, baseUrl);
        motd.load();
        Assert.assertTrue(
            driver.getCurrentUrl()
                .equals(baseUrl + Pages.LOGIN.url()));
    }
}