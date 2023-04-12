package bikalp.com.checkoutpage;

import bikalp.com.abscratchComponents.abscratchComponents;
import bikalp.com.confirmationPage.confirmationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage extends abscratchComponents {
    WebDriver driver;

    public checkoutPage(WebDriver driver) {

            super(driver);
            this.driver=driver;
            PageFactory.initElements(driver,this);

    }

    @FindBy (css=".action__submit")
    WebElement submit;

    @FindBy(css="[placeholder='Select Country']")
    WebElement country;

    //@FindBy(xpath = "//button[contains(@class,'ta-item')])[2]")
    @FindBy(css = "button[class*='ng-star-inserted']")
    WebElement selectCountry;

    By results= By.cssSelector(".ta-results");

    public void setSelectCountry (String countryName){

        Actions a= new Actions(driver);
        a.sendKeys(country,countryName).build().perform();
        waitForElementAppear(results);
        selectCountry.click();

    }

    public confirmationPage submitOrder(){
        submit.click();

        return new confirmationPage(driver);


    }




    }
