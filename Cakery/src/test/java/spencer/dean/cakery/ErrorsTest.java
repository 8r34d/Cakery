package spencer.dean.cakery;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Errors;

public class ErrorsTest {

    @BeforeTest
    public void setup() {
        //
    }

    @AfterTest
    public void teardown() {
        //
    }

    @Test
    public void login_email_required() {
        Assert.assertTrue(
            Errors.LOGIN_EMAIL_REQUIRED.message()
                .equals("The email field is required."));
    }

    @Test
    public void login_password_required() {
        Assert.assertTrue(
            Errors.LOGIN_PASSWORD_REQUIRED.message()
                .equals("The password field is required."));
    }

    @Test
    public void login_credentials_invalid() {
        Assert.assertTrue(
            Errors.LOGIN_CREDENTIALS_INVALID.message()
                .equals("Invalid email & password combination."));
    }
}