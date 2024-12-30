package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import utilities.DriverSetup;

public class TestHomePage extends DriverSetup {
    HomePage homePage = new HomePage();
    @Test
    public void testHomePageURL(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getLoadedPageUrl(), homePage.url);
    }

    @Test
    public void testHomePageTitle(){
        getDriver().get(homePage.url);
        Assert.assertEquals(homePage.getLoadedPageTitle(), homePage.title);
    }
}
