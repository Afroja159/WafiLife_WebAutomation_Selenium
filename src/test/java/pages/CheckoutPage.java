package pages;

import org.openqa.selenium.By;

public class CheckoutPage extends BasePage{
    public By area_dropdown = By.xpath("//select[@id='billing_area']");
    public By address_field = By.xpath("//textarea[@id='billing_address_1']");
    public By ship_to_office_checkbox = By.xpath("//textarea[@id='billing_address_1']");
    public By cod_selection = By.xpath("//input[@id='payment_method_cod']");
    public By my_account_btn = By.xpath("//div[@class='login-links']//a[@title='আমার অ্যাকাউন্ট'][contains(text(),'আমার অ্যাকাউন্ট')]");

}
