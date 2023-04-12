package bikalp.com.cartpage;

import bikalp.com.abscratchComponents.abscratchComponents;
import bikalp.com.checkoutpage.checkoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class cartPage extends abscratchComponents {

    WebDriver driver;

    @FindBy(css=".totalRow button")
    WebElement checkoutEle;

    @FindBy(css=".cartSection h3")
    private List<WebElement> cartProducts;


    public cartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public  Boolean VerifyProductDisplay(String productName ){
        boolean match= cartProducts.stream().anyMatch(prd->prd.getText().equalsIgnoreCase(productName));
        return  match;
    }

    public checkoutPage gotoCheckout(){

        checkoutEle.click();
        return new checkoutPage(driver);
        /*
        checkoutPage coutPage=new checkoutPage(driver);
        return coutPage;


         */

    }
}
