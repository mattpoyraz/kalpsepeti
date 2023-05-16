package databaseConnection;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.*;

public class databaseConnection2 {


        public static void main(String []args) throws SQLException {
            WebDriver driver;
            String host="localhost";
            String port="3306";

            Connection con= DriverManager.getConnection("jdbc:mysql://"+host+"/antep",
                    "root","root");
            Statement s=con.createStatement();
            ResultSet result= s.executeQuery("select * from sam");


            while(result.next()) {

                String dataMysql= result.getString("housename");

                if(dataMysql.equals("mehmet")) {

                    WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    driver.get("https://www.amazon.com");
                    driver.manage().window().maximize();
                    driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).
                            sendKeys(dataMysql);
                    driver.close();
                }

            }

        }

}
