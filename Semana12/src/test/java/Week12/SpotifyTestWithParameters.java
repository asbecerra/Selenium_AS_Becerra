package Week12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.util.List;

//Exercise16
public class SpotifyTestWithParameters {
    String URL = "https://www.spotify.com";
    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        driver = new ChromeDriver();
        driver.get(URL);
    }
    @Test
    @Parameters({"specificTag"})
    public void spotifyTags(@Optional("h1")String tagName){
        List<WebElement> listTagsName = driver.findElements(By.tagName(tagName));
        if (tagName.equalsIgnoreCase("h1")){
            System.out.println("h1 will be showed");
        } else if (tagName.equalsIgnoreCase("h2")){
            System.out.println("h2 will be showed");
        }  else if (tagName.equalsIgnoreCase("h3")){
            System.out.println("h3 will be showed");
        }
        if (listTagsName.size() == 0){
            System.out.println("Elements not found");
        } else {
            for (WebElement list : listTagsName){
                System.out.println(list.getText());
            }
        }
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
