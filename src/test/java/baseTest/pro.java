package baseTest;

import bikalp.com.landingPage.landingPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class pro {

    public WebDriver driver;
    public landingPage page;
    public WebDriver initializeDriver() throws IOException, InterruptedException {


        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
                + "//src//main//java//bikalp//com//resources//globalData.properties");
        properties.load(fis);

        String browserName = System.getProperty("browser")!=null ?
                System.getProperty("browser"):properties.getProperty("browser");

        if (browserName.contains("Chrome")) {

            ChromeOptions options =new ChromeOptions();
            WebDriverManager.chromedriver().setup();
            //System.setProperty("webdriver.chrome.driver","C://Users//ismet//IdeaProjects//IsmetLast10//drivers//chromedriver.exe");

            if(browserName.contains("Headless")){
                options.addArguments("Headless");
            }
            driver = new ChromeDriver(options);
            driver.manage().window().setSize(new Dimension(1440,900));

        } else if (browserName.equalsIgnoreCase("firefox")) {

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();


        } else if (browserName.equalsIgnoreCase("Edge")) {
            //WebDriverManager.edgedriver().setup();
            System.setProperty("webdriver.edge.driver",
                    "C://Users//ismet//IdeaProjects//IsmetLast10//drivers//msedgedriver.exe");
            driver = new EdgeDriver();


        }



        return driver;
    }

    public String getScreenShot(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source =ts.getScreenshotAs(OutputType.FILE);
        File file=new File(System.getProperty("user.dir")+"//reports//"+testCaseName+".png");
        FileUtils.copyFile(source,file);
        return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";

    }




    @BeforeMethod(alwaysRun = true)
    public landingPage launchApplication() throws IOException, InterruptedException {

        driver= initializeDriver();
        page = new landingPage(driver);
        page.gotoLink();
        return page;

    }



    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        driver.close();
    }


}



