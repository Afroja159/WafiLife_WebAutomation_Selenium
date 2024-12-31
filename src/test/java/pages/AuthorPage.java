package pages;

import org.openqa.selenium.By;

public class AuthorPage extends BasePage{
    public String author_url = "https://www.wafilife.com/cat/books/author";

    public By right_arrow = By.xpath("//a[contains(text(),'→')]");
    public By select_random_author = By.xpath("//h3[normalize-space()='Matt Yarrington']");
    //public By select_checkbox = By.xpath("//div[@id='product_cat_str:Matt Yarrington']");
    public By select_book = By.xpath("//a[contains(text(),'Crocodile in the Water, Tiger on the Bank Common B')]");
//    public By select_dropdown = By.xpath("//select[@id='pa_binding']");
//    public By select_dropdown_option = By.xpath("(//select[@id='pa_binding'])[1]");
    public By order_btn = By.xpath("//div[@class='body-wrapper']//button[2]");
    public By complete_order_btn = By.xpath("//a[contains(@class, 'checkout-link') and span[text()='অর্ডার সম্পন্ন করুন']]");


}
