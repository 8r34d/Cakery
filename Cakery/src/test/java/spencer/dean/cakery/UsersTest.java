package spencer.dean.cakery;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Users;

public class UsersTest {

    @BeforeTest
    public void setup() {
        //
    }

    @AfterTest
    public void teardown() {
        //
    }
    
    @Test
    public void emptyEmail() {
        Assert.assertTrue(
            Users.EMPTY.email()
                .equals(""));
    }

    @Test
    public void emptyPassword() {
        Assert.assertTrue(
            Users.EMPTY.password()
                .equals(""));
    }

    @Test
    public void goodEmail() {
        Assert.assertTrue(
            Users.GOOD.email()
                .equals("8r34d@breadbox.com"));
    }

    @Test
    public void goodPassword() {
        Assert.assertTrue(
            Users.GOOD.password()
                .equals("bread"));
    }

    @Test
    public void badEmail() {
        Assert.assertTrue(
            Users.BAD.email()
                .equals("h4ck@hackbox.com"));
    }

    @Test
    public void badPassword() {
        Assert.assertTrue(
            Users.BAD.password()
                .equals("hack"));
    }
}