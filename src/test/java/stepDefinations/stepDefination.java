package stepDefinations;

import baseTest.pro;
import bikalp.com.cartpage.cartPage;
import bikalp.com.checkoutpage.checkoutPage;
import bikalp.com.confirmationPage.confirmationPage;
import bikalp.com.landingPage.landingPage;
import bikalp.com.productCatalogue.productCatalogue;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.IOException;
import java.util.List;

public class stepDefination extends pro {
    public landingPage page;
    public confirmationPage cofirmCh;
    public productCatalogue plist;
    @Given("I landed on Ecommerce Page")
    public void I_landed_on_Ecommerce_Page () throws IOException, InterruptedException {
        page= launchApplication();
    }
    @Given("^Logged in with username (.+) and password (.+)$")
    public void logged_in_username_and_password(String username, String password){
    plist = page.loginCredan(username,password);
    }

    @When("^I add product (.+) to Cart$")
    public void I_add_product_to_cart(String productName) throws InterruptedException {
        List<WebElement> allItems = plist.getProductList();
        plist.addProductToCart(productName);
    }
    @When("^Checkot (.+) and submit the order$")
    public void checkout_submit_order(String productName) throws InterruptedException {
        Thread.sleep(3000);
        cartPage cpage = plist.gotoCartPage();
        Boolean match = cpage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        checkoutPage chekcoutPage = cpage.gotoCheckout();
        chekcoutPage.setSelectCountry("India");
        cofirmCh = chekcoutPage.submitOrder();
    }
/*
    @Then("{string} message is displayed on Confirmation")
    public void message_is_displayed_on_confirmation(String string) throws InterruptedException {

        String confirMessage = cofirmCh.getConfirmationMessage();
        Assert.assertTrue(confirMessage.equalsIgnoreCase(string));
        driver.close();
    }


 */
    @Then("{string} message is displayed")
    public void something_message_is_displayed(String strArg1) throws Throwable {

        Assert.assertEquals(page.setGetErrorMessage(),strArg1);
        driver.close();
    }
    //world




}


