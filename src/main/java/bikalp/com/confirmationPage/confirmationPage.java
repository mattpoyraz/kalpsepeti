package bikalp.com.confirmationPage;

import bikalp.com.abscratchComponents.abscratchComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class confirmationPage extends abscratchComponents {

    WebDriver driver;
    public confirmationPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(css="h1.hero-primary")
    WebElement confirmationMessage;

    public String getConfirmationMessage(){

        return confirmationMessage.getText();
    }
}
