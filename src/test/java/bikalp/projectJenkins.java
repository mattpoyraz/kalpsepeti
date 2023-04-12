package bikalp;

import baseTest.baseTest1;
import bikalp.com.cartpage.cartPage;
import bikalp.com.checkoutpage.checkoutPage;
import bikalp.com.confirmationPage.confirmationPage;
import bikalp.com.orderPage.orderPage1;
import bikalp.com.productCatalogue.productCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class projectJenkins extends baseTest1 {
    String productName="ZARA COAT 3";
    @Test
    public void submitOrder () throws InterruptedException, IOException {

        productCatalogue plist= lpage.loginCredan("ismetp.27@gmail.com","1453IstanbulDallas");

        List<WebElement> allItems= plist.getProductList();
        plist.addProductToCart(productName);
        cartPage cpage= plist.gotoCartPage();

    }

}
