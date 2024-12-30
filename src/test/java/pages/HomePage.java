package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{
    public String url = "https://www.wafilife.com/";
    public String title = "Buy Islamic Books - Online Book Shop in Bangladesh | Wafilife";
    public By login_signup = By.xpath("//a[@title='আমার অ্যাকাউন্ট']");
    public By author_option = By.xpath("//span[@class='menu-label-level-0'][contains(text(),'লেখক')]");
    public void loadHomePage(){
        loadAWebPage(url);
    }

}
