package Clase10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Exercise1 {
    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void forgotAccountTest(){
        WebDriver driver = getDriver("https://www.facebook.com");
        System.out.println("Title: " + driver.getTitle());
        driver.findElement(By.linkText("Forgot Password?")).click();
        System.out.println("Tilte: " + driver.getTitle());
        String title = driver.getTitle();
        String url = driver.getCurrentUrl();

        if (title.equals("Forgot Password | Can't Log In | Facebook") && (!url.equals("https://www.facebook.com"))){
            System.out.println("Test passed");
        } else {
            System.out.println("test failed");
        }
        driver.close();
    }
}
