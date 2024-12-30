package pages;

import org.openqa.selenium.By;

public class MyAccountPage extends BasePage{
    public String url = "https://www.wafilife.com/my-account";
    public String title = "আমার অ্যাকাউন্ট";
    public By logout_btn = By.xpath("//a[contains(text(),'লগআউট')]");

    public By author_option = By.xpath("//span[@class='menu-label-level-0'][contains(text(),'লেখক')]");
    public void navigateToMyAccountPage(){
        HomePage homePage = new HomePage();
        homePage.loadHomePage();
    }
}
