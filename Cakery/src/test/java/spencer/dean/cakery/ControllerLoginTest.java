package spencer.dean.cakery;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Dashboard;
import spencer.dean.cakery.Drivers;
import spencer.dean.cakery.Environments;
import spencer.dean.cakery.Errors;
import spencer.dean.cakery.Login;
import spencer.dean.cakery.Users;

public class ControllerLoginTest {

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
    public void loginWithGoodCredentials() {
        Login login = new Login(driver, baseUrl);
        login.load();
        Assert.assertTrue(
            login.getHeader().getText()
                .equals("Admin - Login"));
        Dashboard dashboard = login.loginWithGoodCredentials(Users.GOOD);
        Assert.assertTrue(
            dashboard.getHeader().getText()
                .equals("Admin - Dashboard - Home"));
    }

    @Test
    public void loginWithBadCredentials() {
        Login login = new Login(driver, baseUrl);
        login.load();
        Assert.assertTrue(
            login.getHeader().getText()
                .equals("Admin - Login"));
        Login login2 = login.loginWithBadCredentials(Users.BAD);
        Assert.assertTrue(
            login2.getHeader().getText()
                .equals("Admin - Login"));
        Assert.assertTrue(
            login2.getErrors().get(0).getText()
                .equals(Errors.LOGIN_CREDENTIALS_INVALID.message()));
    }
    
    @Test
    public void loginWithEmptyCredentials() {
        Login login = new Login(driver, baseUrl);
        login.load();
        Assert.assertTrue(
            login.getHeader().getText()
                .equals("Admin - Login"));
        Login login2 = login.loginWithBadCredentials(Users.EMPTY);
        Assert.assertTrue(
            login2.getHeader().getText()
                .equals("Admin - Login"));
        Assert.assertTrue(
            login2.getErrors().get(0).getText()
                .equals(Errors.LOGIN_EMAIL_REQUIRED.message()));
        Assert.assertTrue(
            login2.getErrors().get(1).getText()
                .equals(Errors.LOGIN_PASSWORD_REQUIRED.message()));
    }
}