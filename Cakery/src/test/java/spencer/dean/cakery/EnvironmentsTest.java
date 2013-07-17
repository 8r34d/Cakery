package spencer.dean.cakery;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Environments;

public class EnvironmentsTest {

    @BeforeTest
    public void setup() {
        //
    }

    @AfterTest
    public void teardown() {
        //
    }

    @Test
    public void development() {
        Assert.assertTrue(
            Environments.DEVELOPMENT.url()
                .equals("http://development/"));
    }

    @Test
    public void testing() {
        Assert.assertTrue(
            Environments.TESTING.url()
                .equals("http://testing/"));
    }

    @Test
    public void production() {
        Assert.assertTrue(
            Environments.PRODUCTION.url()
                .equals("http://www.example.com/"));
    }
}