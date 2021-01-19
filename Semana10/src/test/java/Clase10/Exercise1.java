package Clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

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

    @Test
    public void registrationTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(4000);
        driver.findElement(By.name("firstname")).sendKeys("Alan");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        //dropdown locators
        WebElement month = driver.findElement(By.id("month"));
        Select comboMonth = new Select(month);
        comboMonth.selectByValue("4");
        WebElement days = driver.findElement(By.id("day"));
        Select comboDays = new Select(days);
        comboDays.selectByValue("4");
        WebElement year = driver.findElement(By.id("year"));
        Select comboYear = new Select(year);
        comboYear.selectByVisibleText("2012");
        List<WebElement> sexRadioButtons = driver.findElements(By.name("sex"));
        WebElement maleRadioButton = null;
        for(WebElement element: sexRadioButtons){
            System.out.println(element.getAttribute("value"));
            if(element.getAttribute("value").equals("2")){
                maleRadioButton = element;
            }
        }
        maleRadioButton.click();

        //driver.close();
    }
    @Test
    public void birthDateTest () throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(3000);
        WebElement month = driver.findElement(By.id("month"));
        Select comboMonth = new Select(month);
        comboMonth.selectByValue("12");
        WebElement days = driver.findElement(By.id("day"));
        Select comboDays = new Select(days);
        comboDays.selectByValue("20");
        WebElement year = driver.findElement(By.id("year"));
        Select comboYear = new Select(year);
        comboYear.selectByVisibleText("1990");

        driver.close();
    }

    @Test

}
