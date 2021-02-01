package Week12;

import javafx.scene.layout.Priority;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SalesforceTestNG {
    public static final String SALESFORCE_URL = "https://login.salesforce.com";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(SALESFORCE_URL);
    }
    //Exercise7&10
    @Test (enabled = false)
    public void validateSalesforceLogo (){
        WebElement logo = driver.findElement(By.id("logo"));
        System.out.println("Logo's tagName is " + logo.getTagName());
        System.out.println("Attribute alt " + logo.getAttribute("alt"));
    }
    //Exercise8
    @Test (priority = 4)
    public void rememberMeIsSelected(){
        WebElement rememberCheckBox = driver.findElement(By.id("rememberUn"));
        rememberCheckBox.click();
        Assert.assertTrue(rememberCheckBox.isSelected());
    }
    //Exercise9
    @Test (priority = 2)
    public void footerIsValid(){
        WebElement footer = driver.findElement(By.id("footer"));
        Assert.assertTrue(footer.getText().contains("All rights reserved"));
    }



    @AfterMethod
    public void tearDown(){
        driver.close();
    }



}
