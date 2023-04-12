package bikalp;

import baseTest.baseTest1;
import bikalp.com.cartpage.cartPage;
import bikalp.com.checkoutpage.checkoutPage;
import bikalp.com.confirmationPage.confirmationPage;
import bikalp.com.landingPage.landingPage;
import bikalp.com.orderPage.orderPage1;
import bikalp.com.productCatalogue.productCatalogue;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class project1 extends baseTest1 {
    String productName="ZARA COAT 3";
    @Test
    public void submitOrder () throws InterruptedException, IOException {

        productCatalogue plist= lpage.loginCredan("ismetp.27@gmail.com","1453IstanbulDallas");

        List<WebElement> allItems= plist.getProductList();
        plist.addProductToCart(productName);
        cartPage cpage= plist.gotoCartPage();

        Boolean match= cpage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);
        Thread.sleep(3000);
        checkoutPage chekcoutPage= cpage.gotoCheckout();
        chekcoutPage.setSelectCountry("India");
        confirmationPage cofirmCh=chekcoutPage.submitOrder();
        Thread.sleep(3000);
        String confirMessage=cofirmCh.getConfirmationMessage();
        Assert.assertTrue(confirMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));

    }
    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest(){
        productCatalogue plist= lpage.loginCredan("ismetp.27@gmail.com","1453IstanbulDallas");
        orderPage1 ordersPageList= plist.gotoOrderPage();
        Assert.assertTrue( ordersPageList.VerifyOrderDisplay(productName));
    }
}
