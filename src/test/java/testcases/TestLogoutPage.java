package testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MyAccountPage;
import utilities.DriverSetup;

public class TestLogoutPage extends DriverSetup {
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    @BeforeMethod
    public void setup_class(){
        loginPage.navigateToLoginPage();
    }

    @AfterMethod
    public void addTestScreenshot(){
        loginPage.addScreenshot("After test");
    }
    @Test
    public void testLogout() {
        // Login steps
        loginPage.writeOnElement(loginPage.email_input_box, "arb@gmail.com");
        loginPage.writeOnElement(loginPage.password_input_box, "123456");
        loginPage.clickOnElement(loginPage.login_btn);
        Assert.assertTrue(myAccountPage.is_element_visible(myAccountPage.logout_btn));
        myAccountPage.clickOnElement(myAccountPage.logout_btn);
    }
    }
