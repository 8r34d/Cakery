package spencer.dean.cakery;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Pages;

public class PagesTest {

    @BeforeTest
    public void setup() {
        //
    }

    @AfterTest
    public void teardown() {
        //
    }

    @Test
    public void four04() {
        Assert.assertTrue(
            Pages.FOUR04.url()
                .equals("zzz"));
    }

    @Test
    public void home() {
        Assert.assertTrue(
            Pages.HOME.url()
                .equals("home"));
    }

    @Test
    public void about() {
        Assert.assertTrue(
            Pages.ABOUT.url()
                .equals("about"));
    }

    @Test
    public void login() {
        Assert.assertTrue(
            Pages.LOGIN.url()
                .equals("admin/login"));
    }

    @Test
    public void logout() {
        Assert.assertTrue(
            Pages.LOGOUT.url()
                .equals("admin/logout"));
    }

    @Test
    public void dashboard() {
        Assert.assertTrue(
            Pages.DASHBOARD.url()
                .equals("admin/dashboard"));
    }

    @Test
    public void motd() {
        Assert.assertTrue(
            Pages.MOTD.url()
                .equals("admin/dashboard/motd"));
    }
}