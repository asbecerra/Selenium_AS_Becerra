import com.sun.tools.internal.xjc.model.CElement;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.List;

public class FirstTest {

    @Test
    public void showTitle(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();  //instancia
        driver.get("https://www.spotify.com");
        System.out.println(driver.getTitle());
        driver.close();

    }

    @Test
    public void FirstTest(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        //instancia
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com");
        String url = driver.getCurrentUrl();
        System.out.println("The actual URL is: " +url);
        //close window
        //driver.close();
    }

    @Test
    public void showHs(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        //instancia
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        System.out.println("Amount of H1 is: " +h1List.size());

        //To locate the WebElement
        for(WebElement element : h1List){
            System.out.println(element.getText());
        }
        System.out.println("**************");
        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        System.out.println("Amount of H2 is: " + h2List.size());
        for (WebElement element : h2List){
            System.out.println("H2 Elements: " + element.getText());
        }
        System.out.println("**************");
        List<WebElement> h3List = driver.findElements(By.tagName("h3"));
        System.out.println("Amount of H3 is: " + h3List.size());
        for (WebElement element : h3List){
            System.out.println("H3 Elements: " + element.getText());
        }

        List<WebElement> paragraphList = driver.findElements(By.tagName("p"));
        System.out.println("Amount of paragraph is: " + paragraphList.size());
        for (WebElement element : paragraphList) {
            System.out.println("Paragraph: " + element.getText());
        }

        driver.close();
    }
    @Test
    public void getWindowSize(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("The height is: " +height);
        System.out.println("the width is: " +width);

        driver.close();

    }
    @Test
    public void getLinksElements() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("Amount of Links is: " +linksList.size());
        for (WebElement element : linksList) {
            System.out.println("Links: " + element.getText());
        }
        driver.close();
    }
    @Test
    public void getBBCLists() {
        System.setProperty("webdriver.chrome.driver", "driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bbc.com/mundo");
        List<WebElement> liList = driver.findElements(By.tagName("lo"));
        System.out.println("Amount of Lists is: " +liList.size());
        for (WebElement element : liList) {
            System.out.println("List: " + element.getText());
        }
        driver.close();
    }
    @Test
    public void getSpotifyTitle(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();  //instancia
        driver.get("https://www.spotify.com");
        String title = driver.getTitle();
        if (title.equals("Escuchar es todo - Spotify")){
            System.out.println("Test passed");
        } else {
            System.out.println("test failed");
        }
        driver.close();
    }
    @Test
    public void getGoogleWindowSize(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();
        System.out.println("The height is: " +height);
        System.out.println("The width is: " +width);
        //set size
        Dimension dimension = new Dimension(1024,768);
        driver. manage().window().setSize(dimension);
        System.out.println("Updating Size....");
        height = driver.manage().window().getSize().getHeight();
        width = driver.manage().window().getSize().getWidth();
        System.out.println("The new height is: " +height);
        System.out.println("The new width is: " +width);

        driver.close();

    }
    public WebDriver getGoogleDriver(){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        return driver;
    }

    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }

    @Test
    public void goToGoogle(){
        WebDriver driver = getGoogleDriver();
        String title = driver.getTitle();
        System.out.println(title);
        driver.close();
    }

    @Test
    public void testBBC(){
        WebDriver driver = getDriver("https://www.bbc.com");
        String title = driver.getTitle();
        System.out.println(title);
    }
    //Find a Webelement and press enter
    @Test
    public void searchInGoogle(){
        WebDriver driver = getGoogleDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.name("q")).sendKeys("WebElement" + Keys.ENTER);
        driver.close();
    }

    @Test
    public void searchInGoogleAndGoBack(){
        WebDriver driver = getGoogleDriver();
        driver.get("https://www.google.com");
        System.out.println("the title is: " +driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("WebElement" + Keys.ENTER);
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        driver.close();
    }
    @Test
    public void facebookPageTest(){
        WebDriver driver = getDriver("https://www.facebook.com");
        List<WebElement> divList = driver.findElements(By.tagName("div"));
        System.out.println("Amount of facebook's div is: " + divList.size());

        List<WebElement> linksList = driver.findElements(By.tagName("a"));
        System.out.println("Amount of Links  in facebook page is: " +linksList.size());
        for (WebElement element : linksList) {
            System.out.println("facebook Links: " + element.getText());
        }

        List<WebElement> btnList = driver.findElements(By.tagName("button"));
        System.out.println("The number of buttons on facebook page is: " +btnList.size());
        for (WebElement element : btnList){
            System.out.println("Facebook buttons: " +element.getText());
        }

        driver.close();
    }

    @Test

    public void sendKeysToFbk(){
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.id("pass")).sendKeys("holamundo");
        driver.findElement(By.name("login")).click();
    }

    //Ejercicio 9.14
    @Test

    public void netflixTest(){
        WebDriver driver = getDriver("https://www.netflix.com");
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        if(h1List.size() > h2List.size()){
            System.out.println("Amount of h1 is: " +h1List.size());
            for (WebElement element: h1List){
                System.out.println("h1 element " + element.getText());
            }
        } else if (h1List.size() < h2List.size()){
            System.out.println("Amount of h2 is: " +h2List.size());
            for (WebElement element: h2List) {
                System.out.println("h2 element " + element.getText());
            }
        }  else {
            System.out.println("Amount of h1 is: " +h1List.size());
            System.out.println("Amount of h2 is: " +h2List.size());
            for (WebElement element: h1List) {
                System.out.println("h1 element " + element.getText());
            }
            for (WebElement element: h1List) {
                System.out.println("h2 element " + element.getText());
            }
        }
        driver.navigate().refresh();
        List<WebElement> btnList = driver.findElements(By.tagName("button"));
        for (WebElement element: btnList) {
            System.out.println("Netflix button " + element.getText());
        }
        driver.manage().window().maximize();
        List<WebElement> divList = driver.findElements(By.tagName("div"));
        System.out.println("The amount of div elements is: " + divList.size());
        String title = driver.getTitle();
        System.out.println(title);
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println("The amount of input elements is: " + inputList.size());
        List<WebElement> linkList = driver.findElements(By.tagName("link"));
        System.out.println("The amount of links elements is: " + linkList.size());

        int[] size = {h1List.size(), h2List.size(), btnList.size(), divList.size(), inputList.size(), linkList.size()};
        int largestSize = h1List.size();
        int largestSizeIndex = 0;
        
        for (int x=1; x<size.length; x++){
            if (size[x]>largestSize) {
                largestSize = size[x];
                largestSizeIndex = x;
            }
        }
        if (largestSizeIndex == 0) {
            System.out.println("h1 is the element that repeats the most ");
        } else if (largestSizeIndex == 1) {
            System.out.println("h2 is the element that repeats the most ");
        } else if (largestSizeIndex == 2) {
            System.out.println("Button is the element that repeats the most ");
        } else if (largestSizeIndex == 3) {
            System.out.println("div is the element that repeats the most ");
        } else if (largestSizeIndex == 4) {
            System.out.println("input is the element that repeats the most ");
        } else if (largestSizeIndex == 5) {
            System.out.println("link is the element that repeats the most ");
        }
    }

    @Test
    public void netflixSingInPage(){
        WebDriver driver = getDriver("https://www.netflix.com");
        driver.findElement(By.linkText("Sign In")).click();
        List<WebElement> h1List = driver.findElements(By.tagName("h1"));
        List<WebElement> h2List = driver.findElements(By.tagName("h2"));
        for (WebElement element: h1List) {
            System.out.println("h1 second Page element " + element.getText());
        }
        for (WebElement element: h2List) {
            System.out.println("h2 second Page element " + element.getText());
        }
        driver.navigate().back();
        driver.navigate().refresh();
        List<WebElement> divList = driver.findElements(By.tagName("div"));
        for (WebElement element: divList) {
            System.out.println("div elements " + element.getText());
        }
        String title = driver.getTitle();
        System.out.println("Page Title:  " +title);
        List<WebElement> inputList = driver.findElements(By.tagName("input"));
        System.out.println("The amount of input elements is: " + inputList.size());
        List<WebElement> linkList = driver.findElements(By.tagName("link"));
        System.out.println("The amount of links elements is: " + linkList.size());

        int[] size = {divList.size(), inputList.size(), linkList.size()};
        int largestSize = divList.size();
        int largestSizeIndex = 0;

        for (int x=1; x<size.length; x++){
            if (size[x]>largestSize) {
                largestSize = size[x];
                largestSizeIndex = x;
            }
        }

        if (largestSizeIndex == 0) {
            System.out.println("div is the element that repeats the most ");
        } else if (largestSizeIndex == 1) {
            System.out.println("input is the element that repeats the most ");
        } else if (largestSizeIndex == 2) {
            System.out.println("Link is the element that repeats the most ");
        }
    }
}

