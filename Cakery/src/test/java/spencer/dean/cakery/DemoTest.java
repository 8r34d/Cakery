package spencer.dean.cakery;

import java.util.Iterator;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.Assert;

import spencer.dean.cakery.Data;
import spencer.dean.cakery.Demo;

public class DemoTest {

    @BeforeTest
    public void setup() {
        //
    }

    @AfterTest
    public void teardown() {
        //
    }

    @DataProvider(name = "demoData")
    public static Iterator<String[]> demoDataProvider() {
        return Data.getIteratorCsvSkipLine("src/test/resources/demo.csv", 1);
    }

    @Test(dataProvider = "demoData")
    public void demoData(String dataLine) {
        Assert.assertFalse(dataLine.isEmpty());
    }

    @Test(dataProvider = "demoData", dependsOnMethods = { "demoData" })
    public void demoClass(String dataLine) {
        Demo demo = new Demo();
        Assert.assertTrue(demo.addDemoText(dataLine).endsWith("demo"));
    }
}