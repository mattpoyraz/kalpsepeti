package bikalp.com.landingPage;

import bikalp.com.abscratchComponents.abscratchComponents;
import bikalp.com.productCatalogue.productCatalogue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class landingPage extends abscratchComponents {

     WebDriver driver;
     public landingPage (WebDriver driver){
         super(driver);
         this.driver=driver;
         PageFactory.initElements(driver,this);
     }

     @FindBy(id="userEmail")
     WebElement getUserEmail;

     @FindBy(id="userPassword")
     WebElement getUserName;

     @FindBy(css="#login")
     WebElement getSubmit;

     @FindBy(css="[class*='toast-container']")
     WebElement getErrorMessage;



    public productCatalogue loginCredan (String email, String password){

        getUserEmail.sendKeys(email);
        getUserName.sendKeys(password);
        getSubmit.click();

        productCatalogue plist=new productCatalogue(driver);
        return plist;
    }

    public String setGetErrorMessage (){

        waitForWebElementAppear(getErrorMessage);
        return getErrorMessage.getText();

    }

    public void gotoLink (){

        driver.get("https://rahulshettyacademy.com/client");
    }


}
