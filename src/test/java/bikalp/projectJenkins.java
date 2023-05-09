package bikalp;

import baseTest.pro;
import bikalp.com.cartpage.cartPage;
import bikalp.com.productCatalogue.productCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class projectJenkins extends pro {
    String productName="ZARA COAT 3";
    @Test
    public void submitOrder () throws InterruptedException, IOException {

        productCatalogue plist= page.loginCredan("ismetp.27@gmail.com","1453IstanbulDallas");

        List<WebElement> allItems= plist.getProductList();
        plist.addProductToCart(productName);
        cartPage cpage= plist.gotoCartPage();

    }

}
