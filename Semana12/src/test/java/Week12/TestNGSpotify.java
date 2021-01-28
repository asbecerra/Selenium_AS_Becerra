package Week12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGSpotify {

    String URL = "https://www.spotify.com";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
    }
    //Exercise1
    @Test (priority = 0)
    public void verifySpotifyTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Escuchar es todo - Spotify");
    }
    //Exercise2
    @Test (priority = 1)
    public void verifySignupURL(){
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div/nav/ul/li[5]/a")).click();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("signup"),"Tha page is not the expected");
    }

    //Exercise3
    @Test (priority = 2)
    public void noValidEmailTest(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/co/signup/']")).click();
        driver.findElement(By.id("email")).sendKeys("1234@.co");
        driver.findElement(By.name("confirm")).sendKeys("1234@.co");
        WebElement mailErrorMsg = driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico no es válido')]"));
        Assert.assertEquals(mailErrorMsg.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }
    //Exercise4
    @Test (priority = 3)
    public void existingEmailTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/co/signup/']")).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.name("confirm")).sendKeys("test@test.com");
        Thread.sleep(3000);
        WebElement existingMailrMsg = driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico ya está conectado a una cuenta')]"));
        Assert.assertEquals(existingMailrMsg.getText(),"Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Test run");
        driver.close();
    }
}


