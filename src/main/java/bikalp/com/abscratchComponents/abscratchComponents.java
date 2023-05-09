package bikalp.com.abscratchComponents;

import bikalp.com.cartpage.cartPage;
import bikalp.com.orderPage.orderPage1;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class abscratchComponents {

    WebDriver driver;
    public abscratchComponents(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="[routerlink='/dashboard/cart']")
    WebElement getGotoCartPage;

    @FindBy(css="[routerlink*='myorders']")
    WebElement orderHeader;


    public cartPage gotoCartPage(){

        getGotoCartPage.click();
        cartPage cpage=new cartPage(driver);
        return cpage;
    }

    public orderPage1 gotoOrderPage(){

        orderHeader.click();
        orderPage1 orpage=new orderPage1(driver);
        return orpage;

    }


    public void waitForElementAppear(By findBy){

        //WebDriverWait wait=new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));


    }

    public void waitForWebElementAppear(WebElement findBy){

       // WebDriverWait wait=new WebDriverWait(driver, 15);
       // wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public void waitForElemenetDesAppear(WebElement element) throws InterruptedException {

        Thread.sleep(3000);
        /* WebDriverWait wait=new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.invisibilityOf(element));
         */
    }


}
