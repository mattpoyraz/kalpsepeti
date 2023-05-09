package bikalp;


import baseTest.pro;
import bikalp.com.cartpage.cartPage;
import bikalp.com.checkoutpage.checkoutPage;
import bikalp.com.confirmationPage.confirmationPage;
import bikalp.com.orderPage.orderPage1;
import bikalp.com.productCatalogue.productCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class project extends pro {
    String productName = "ZARA COAT 3";

    @Test(dataProvider = "getData", groups = {"Purchase"})
    //use this for dataProvider
    //public void submitOrder(String email, String password) throws InterruptedException, IOException {
    public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {

        productCatalogue plist = page.loginCredan(input.get("email"), input.get("password"));
        List<WebElement> allItems = plist.getProductList();
        Thread.sleep(3000);
        plist.addProductToCart(productName);

        cartPage cpage=plist.gotoCartPage();

        Boolean match = cpage.VerifyProductDisplay(productName);
        //Assert.assertTrue(match);
        Thread.sleep(3000);

        checkoutPage chekcoutPage = cpage.gotoCheckout();
        chekcoutPage.setSelectCountry("India");
        confirmationPage cofirmCh = chekcoutPage.submitOrder();
        //Thread.sleep(3000);
        String confirMessage = cofirmCh.getConfirmationMessage();
        Assert.assertTrue(confirMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }

    @Test(dependsOnMethods = {"submitOrder"})
    public void orderHistoryTest() {
        productCatalogue plist = page.loginCredan("ismetp.27@gmail.com", "1453IstanbulDallas");
        orderPage1 ordersPageList = plist.gotoOrderPage();
        Assert.assertTrue(ordersPageList.VerifyOrderDisplay(productName));
    }


   /* @DataProvider
    public Object[][] getData(){

        return new Object[][]
                {{"ismetp.27@gmail.com","1453IstanbulDallas"},
                {"ismetp.27@gmail.com","56465465"}};
    }

    */

    @DataProvider
    public Object[][] getData() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "ismetp.27@gmail.com");
        map.put("password", "1453IstanbulDallas");
/*
        HashMap<String, String> map2 = new HashMap<String, String>();
        map2.put("email", "ismetp.27@gmail.com");
        map2.put("password", "1453IstanbulDallas");

        return new Object[][] {{map},{map2}};

 */
        return new Object[][] {{map}};

    }
}