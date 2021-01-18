package Clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exercise1 {
    public WebDriver getDriver(String URL) {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void forgotAccountTest() {
        WebDriver driver = getDriver("https://www.facebook.com");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.linkText("Forgot Password?")).click();
        System.out.println("Tilte: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "Forgot Password | Can't Log In | Facebook", "The Title is not the expected");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://www.facebook.com", "The links are the same");

        driver.close();
    }

    @Test
    public void forgotAccountPartialLinkTest() {
        WebDriver driver = getDriver("https://www.facebook.com");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.partialLinkText("Forgot ")).click();
        System.out.println("Tilte: " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Forgot Password | Can't Log In | Facebook","The Title is not the expected");

        driver.close();
    }

    @Test
    public void customSalesforceLink() {
        WebDriver driver = getDriver("https://login.salesforce.com");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.linkText("Use Custom Domain")).click();
        driver.findElement(By.id("mydomain")).sendKeys("as");
        driver.findElement(By.name("Continue")).click();
        driver.findElement(By.name("username")).sendKeys("test@test.com");

        driver.close();
    }
}
