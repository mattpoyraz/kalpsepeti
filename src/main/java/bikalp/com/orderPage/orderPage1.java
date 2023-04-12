package bikalp.com.orderPage;

import bikalp.com.abscratchComponents.abscratchComponents;
import bikalp.com.checkoutpage.checkoutPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class orderPage1 extends abscratchComponents {

    WebDriver driver;

    @FindBy(css=".totalRow button")
    WebElement checkoutEle;

    @FindBy(css="tr td:nth-child(3)")
    private List<WebElement> productNames;


    public orderPage1(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public  Boolean VerifyOrderDisplay(String productName ){
        boolean match= productNames.stream().anyMatch(prd->prd.getText().equalsIgnoreCase(productName));
        return  match;
    }



}


