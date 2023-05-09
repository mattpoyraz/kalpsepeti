package ErrorValidaitons;

import baseTest.Retry;
import baseTest.pro;
import bikalp.com.cartpage.cartPage;
import bikalp.com.productCatalogue.productCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class errorValidations1 extends pro {
    String productName = "ZARA COAT 3";
    String emailId="ismetp.27@gmail.com";
    String passwordId="1453IstanbulDallass";


    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
    public void loginValidation() throws InterruptedException, IOException {
        page.loginCredan(emailId,passwordId);
        String expected=page.setGetErrorMessage();
        String actual="Incorrect email or password.";
        Assert.assertEquals(actual,expected);
    }



    @Test
    public void productErrorValidation() throws InterruptedException, IOException {

        productCatalogue plist = page.loginCredan(emailId,passwordId);
        Thread.sleep(3000);

        List<WebElement> allItems = plist.getProductList();
        plist.addProductToCart(productName);

        cartPage cpage = plist.gotoCartPage();
        Boolean match = cpage.VerifyProductDisplay(productName);
        Assert.assertTrue(match);

    }








}
