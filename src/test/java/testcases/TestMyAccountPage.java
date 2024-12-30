package testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import utilities.DriverSetup;

public class TestMyAccountPage extends DriverSetup {
    HomePage homePage = new HomePage();
    MyAccountPage myAccountPage = new MyAccountPage();
    @BeforeMethod
    public void setup_class(){
        myAccountPage.navigateToMyAccountPage();
    }

    @AfterMethod
    public void addTestScreenshot(){
        myAccountPage.addScreenshot("After test");
    }
    @Test
    public void testAction(){
        homePage.clickOnElement(homePage.author_option);
    }
}
