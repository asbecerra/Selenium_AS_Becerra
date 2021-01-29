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
    @Test (priority = 5)
    public void verifySpotifyTitle() {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, "Escuchar es todo - Spotify");
    }
    //Exercise2
    @Test (priority = 4)
    public void verifySignupURL(){
        driver.findElement(By.xpath("/html/body/div[2]/div/header/div/nav/ul/li[5]/a")).click();
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(currentURL.contains("signup"),"Tha page is not the expected");
    }

    //Exercise3
    @Test (priority = 3)
    public void noValidEmailTest(){
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/co/signup/']")).click();
        driver.findElement(By.id("email")).sendKeys("1234@.co");
        driver.findElement(By.name("confirm")).sendKeys("1234@.co");
        WebElement mailErrorMsg = driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico no es válido')]"));
        Assert.assertEquals(mailErrorMsg.getText(),"Este correo electrónico no es válido. Asegúrate de que tenga un formato como este: ejemplo@email.com");

    }
    //Exercise4
    @Test (priority = 2)
    public void existingEmailTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/co/signup/']")).click();
        driver.findElement(By.id("email")).sendKeys("test@test.com");
        driver.findElement(By.name("confirm")).sendKeys("test@test.com");
        Thread.sleep(3000);
        WebElement existingMailrMsg = driver.findElement(By.xpath("//span[contains(text(),'Este correo electrónico ya está conectado a una cuenta')]"));
        Assert.assertEquals(existingMailrMsg.getText(),"Este correo electrónico ya está conectado a una cuenta. Inicia sesión.");
    }

    //Exercise5
    @Test (priority = 1)
    public void checkEqualEmailError() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/co/signup/']")).click();
        driver.findElement(By.id("email")).sendKeys("as_23@test.com");
        driver.findElement(By.name("confirm")).sendKeys("test1@as.com");
        driver.findElement(By.id("password")).sendKeys("123test");
        Thread.sleep(3000);
        WebElement difEmailError = driver.findElement(By.xpath("//*[@id=\"__next\"]/main/div[2]/form/div[2]/div[2]"));
        Assert.assertEquals(difEmailError.getText(),"Las direcciones de correo electrónico no coinciden.");
    }
    //Exercise6
    private static final String EMAIL_ERROR = "Es necesario que introduzcas tu correo electrónico.";
    private static final String CONFIRM_ERROR = "Es necesario que confirmes tu correo electrónico.";
    private static final String PWD_ERROR = "Debes introducir una contraseña.";
    private static final String PROFILE_ERROR = "Introduce un nombre para tu perfil.";
    private static final String DAY_ERROR = "Indica un día del mes válido.";
    private static final String MONTH_ERROR ="Selecciona tu mes de nacimiento.";
    private static final String YEAR_ERROR = "Indica un año válido.";
    private static final String GENDER_ERROR = "Selecciona tu sexo.";
    private static final String CAPTCHA_ERROR = "Confirma que no eres un robot.";

    @Test (priority = 0)
    public void checkErrorMessages() throws InterruptedException {
        driver.findElement(By.xpath("//a[@href='https://www.spotify.com/co/signup/']")).click();
        driver.findElement(By.xpath("//button[@type ='submit']")).click();

        WebElement mailMsgError = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que introduzcas tu correo electrónico.')]"));
        WebElement confirmMsgError = driver.findElement(By.xpath("//*[contains(text(),'Es necesario que confirmes tu correo electrónico.')]"));
        WebElement pwdMsgError = driver.findElement(By.xpath("//*[contains(text(),'Debes introducir una contraseña.')]"));
        WebElement profileMsgError = driver.findElement(By.xpath("//*[contains(text(),'Introduce un nombre para tu perfil.')]"));
        WebElement dayMsgError = driver.findElement(By.xpath("//*[contains(text(),'Indica un día del mes válido.')]"));
        WebElement monthMsgError = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu mes de nacimiento.')]"));
        WebElement yearMsgError = driver.findElement(By.xpath("//*[contains(text(),'Indica un año válido.')]"));
        WebElement genderMsgError = driver.findElement(By.xpath("//*[contains(text(),'Selecciona tu sexo')]"));
        WebElement captchaMsgError = driver.findElement(By.xpath("//*[contains(text(),'Confirma que no eres un robot.')]"));

        Assert.assertEquals(mailMsgError.getText(),EMAIL_ERROR);
        Assert.assertEquals(confirmMsgError.getText(),CONFIRM_ERROR);
        Assert.assertEquals(pwdMsgError.getText(),PWD_ERROR);
        Assert.assertEquals(profileMsgError.getText(),PROFILE_ERROR);
        Assert.assertEquals(dayMsgError.getText(),DAY_ERROR);
        Assert.assertEquals(monthMsgError.getText(),MONTH_ERROR);
        Assert.assertEquals(yearMsgError.getText(),YEAR_ERROR);
        Assert.assertEquals(genderMsgError.getText(),GENDER_ERROR);
        Assert.assertEquals(captchaMsgError.getText(),CAPTCHA_ERROR);
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Test run");
        driver.close();
    }
}


