package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String url = "https://www.wafilife.com/";
    public String title = "Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
    public By login_signup = By.xpath("//a[@title='আমার অ্যাকাউন্ট']");
    public void loadHomePage(){
        loadAWebPage(url);
    }

}
