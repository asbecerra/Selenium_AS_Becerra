package Week12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

//Exercise12
public class TestGroups {
    public String URL = "https://www.spotify.com";
    public WebDriver driver;

    @Test(groups = {"successTests","failTests"})

    @BeforeTest
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @Test(groups = {"successTests"})
    public void successTest1(){
    }
    @Test(groups = {"successTests"})
    public void successTest2(){
    }
    @Test(groups = {"successTests"})
    public void successTest3(){
    }
    //Exercise14
    @Test(priority = 3, groups = {"failTests"})
    public void failTest1(){
    }
    @Test(groups = {"failTests"})
    public void failTest2(){
    }
    @AfterTest
    public void tearDown(){
        System.out.println("Test run");
        driver.close();
    }
}
