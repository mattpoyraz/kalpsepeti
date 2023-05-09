package ErrorValidaitons;


import baseTest.pro;
import bikalp.com.cartpage.cartPage;
import bikalp.com.checkoutpage.checkoutPage;
import bikalp.com.confirmationPage.confirmationPage;
import bikalp.com.productCatalogue.productCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

public class NextPage extends pro {

    String pName = "ADIDAS ORIGINAL";
    @Test(dataProvider = "getData")
    public void checkNewItems(HashMap<String, String> input) throws InterruptedException {

        productCatalogue pcatalog= page.loginCredan(input.get("email"), input.get("password"));
        List<WebElement> listofProduct= pcatalog.getProductList();
        pcatalog.addProductToCart(pName);
        Thread.sleep(4000);
        cartPage cpa=pcatalog.gotoCartPage();

        Boolean match = cpa.VerifyProductDisplay(pName);
        Assert.assertTrue(match);

        checkoutPage cheko= cpa.gotoCheckout();
        cheko.setSelectCountry("India");

        confirmationPage confirmationP= cheko.submitOrder();
        String ctext= confirmationP.getConfirmationMessage();
        Assert.assertTrue(ctext.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


    }

    @DataProvider
    public Object[][] getData() {

        HashMap<String, String> map = new HashMap<String, String>();
        map.put("email", "ismetp.27@gmail.com");
        map.put("password", "1453IstanbulDallas");
        return new Object[][] {{map}};

    }
}

