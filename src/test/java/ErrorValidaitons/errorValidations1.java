package ErrorValidaitons;

import baseTest.baseTest1;
import bikalp.com.cartpage.cartPage;
import bikalp.com.productCatalogue.productCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class errorValidations1 extends baseTest1 {
    String productName = "ZARA COAT 3";

    @Test
    public void loginValidation() throws InterruptedException, IOException {


        productCatalogue plist = lpage.loginCredan("anshika@gmail.com","Iaamking@000");
        Assert.assertEquals("Incorrect email or password.", lpage.setGetErrorMessage());


    }

    @Test
    public void productErrorValidation() throws InterruptedException, IOException {

        productCatalogue plist = lpage.loginCredan("anshika@gmail.com","Iamking@000");
        Thread.sleep(3000);
        List<WebElement> allItems = plist.getProductList();
        plist.addProductToCart(productName);
        cartPage cpage = plist.gotoCartPage();
        Boolean match = cpage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);

    }
}
