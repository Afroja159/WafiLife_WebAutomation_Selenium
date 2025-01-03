package testcases;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AuthorPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.MyAccountPage;
import utilities.DriverSetup;

import java.time.Duration;

public class TestAuthorPage extends DriverSetup {
    HomePage homePage = new HomePage();
    AuthorPage authorPage = new AuthorPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    MyAccountPage myAccountPage = new MyAccountPage();

    @BeforeMethod
    public void setup_class(){
        authorPage.navigateToAuthorPage();
    }

    @AfterMethod
    public void addTestScreenshot(){
        authorPage.addScreenshot("After test");
    }

    @Test
    public void testNavigateToAuthorPageAndInteractWithElements() {
        homePage.clickOnElement(homePage.author_option);
        getDriver().get("https://www.wafilife.com/cat/books/author");

        // Scroll and Interact with elements
        Actions actions = new Actions(getDriver());
        actions.scrollByAmount(0, 1200).build().perform();
        authorPage.clickOnElement(authorPage.right_arrow);
        authorPage.clickOnElement(authorPage.select_random_author);
        //authorPage.clickOnElement(authorPage.select_checkbox);
        authorPage.clickOnElement(authorPage.select_book);
        authorPage.clickOnElement(authorPage.order_btn);
        // Wait for the "অর্ডার সম্পন্ন করুন" button to become visible and clickable
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
        WebElement completeOrderButton = wait.until(
                ExpectedConditions.elementToBeClickable(authorPage.complete_order_btn)
        );

        // Click on the button
        completeOrderButton.click();

        // Wait for the dropdown to be visible
        WebDriverWait waitForDropdown = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

        try {
            // Always re-locate the dropdown before interacting
            WebElement areaDropdown = waitForDropdown.until(ExpectedConditions.presenceOfElementLocated(checkoutPage.area_dropdown));

            // Select the desired option by visible text
            Select select = new Select(areaDropdown);
            select.selectByVisibleText("আদাবর");

        } catch (StaleElementReferenceException e) {
            WebElement areaDropdown = wait.until(ExpectedConditions.presenceOfElementLocated(checkoutPage.area_dropdown));
            Select select = new Select(areaDropdown);
            select.selectByVisibleText("আদাবর");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        // write on address field
        checkoutPage.writeOnElement(checkoutPage.address_field, "Dhaka");
        // select checkbox
        checkoutPage.clickOnElement(checkoutPage.ship_to_office_checkbox);
        // select cod radio button
        checkoutPage.clickOnElement(checkoutPage.cod_selection);
        // Scroll up by a specific amount
        Actions actionForScrollUp = new Actions(getDriver());
        actionForScrollUp.scrollByAmount(0, -900).build().perform();

        // Interact with my account button after scrolling up
        checkoutPage.clickOnElement(checkoutPage.my_account_btn);
        // Interact with logout button after navigating to my account page
        myAccountPage.clickOnElement(myAccountPage.logout_btn);

    }
}
