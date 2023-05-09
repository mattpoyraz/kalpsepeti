package bikalp.com.productCatalogue;


import bikalp.com.abscratchComponents.abscratchComponents;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class productCatalogue extends abscratchComponents {

    WebDriver driver;
    public productCatalogue (WebDriver driver){
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css=".offset-md-0")
    List<WebElement> allItems;

    @FindBy(css="..card-img-top")
    WebElement spinner;

   /* @FindBy (css = ".offset-md-0")
            WebElement ToCart;

    */

    By productsBy= By.cssSelector(".offset-md-0");
    By addToCart= By.cssSelector(".card-body button:last-of-type");
    By toastCont= By.cssSelector("#toast-container");


    public List<WebElement> getProductList(){
        waitForElementAppear(productsBy);
        return allItems;
    }

    public WebElement getProductByName(String productName){
        WebElement products= getProductList().stream().filter(item->item.findElement(By.cssSelector("b")).getText().
                equals(productName)).findFirst().orElse(null);
        return products;

    }

    public void addProductToCart(String productName) throws InterruptedException {
        WebElement products = getProductByName(productName);
        products.findElement(addToCart).click();
        waitForElementAppear(toastCont);
        //waitForElemenetDesAppear(spinner);
    }


}
