package pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage{
    public By email_input_box = By.xpath("//input[@id='username']");
    public  By password_input_box = By.xpath("//input[@id='password']");
    public  By login_btn = By.xpath("//input[@name='login']");
    public  By error_msg = By.xpath("//li[contains(text(),'ইউজার নাম প্রয়োজন')]");
    public  By invalid_email_msg = By.xpath("//li[contains(text(),'Unknown email address. Check again or try your use')]");
    public  By invalid_password_msg = By.xpath("//li[contains(text(),'The password you entered for the email address')]");
    public  By invalid_credential_msg = By.xpath("//li[contains(text(),'Unknown email address. Check again or try your use')]");

    public void navigateToLoginPage(){
        HomePage homePage = new HomePage();
        homePage.loadHomePage();
        homePage.clickOnElement(homePage.login_signup);
    }
}
