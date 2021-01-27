package Week11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class Practice11 {

    public WebDriver getDriver(String URL){
        System.setProperty("webdriver.chrome.driver","driver/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get(URL);
        return driver;
    }
    //Exercise1
    @Test
    public void completeDocusignResgistrationForm(){
        WebDriver driver = getDriver("https://go.docusign.com/o/trial");
        driver.findElement(By.xpath("//*[@name='first_name']")).sendKeys("Alan");
        driver.findElement(By.xpath("//*[@name='last_name']")).sendKeys("Smith");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[@name='phone']")).sendKeys("55555555");
        driver.findElement(By.xpath("//*[@name='title']")).sendKeys("QA Tester");
        //dropdown is a select element
        WebElement selectOne = driver.findElement(By.xpath("//*[@name='ds_industry']"));
        Select selectOneDropdown = new Select(selectOne);
        selectOneDropdown.selectByValue("Technology");
    }

    //Exercise2
    @Test
    public void defaultXpath(){
        WebDriver driver = getDriver("https://go.docusign.com/o/trial");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_First_Name\"]/input")).sendKeys("Ana");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Last_Name\"]/input")).sendKeys("Test");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Email\"]/input")).sendKeys("test1@test.com");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Phone\"]/input")).sendKeys("12345678");
        driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Job_Title\"]/input")).sendKeys("Engineer");
        //dropdown is a select element
        WebElement selectOne = driver.findElement(By.xpath("//*[@id=\"dsFormLabel_Industry\"]/select"));
        Select selectOneDropdown = new Select(selectOne);
        selectOneDropdown.selectByValue("Education");
    }

    //Exercise3
    @Test
    public void spotifyByNameTest() {
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.findElement(By.xpath("//*[@name='email']")).sendKeys("Testing8@test.com");
        driver.findElement(By.xpath("//*[@name='confirm']")).sendKeys("Testing8@test.com");
        driver.findElement(By.xpath("//*[@name='password']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@name='displayname']")).sendKeys("Testing");
        driver.findElement(By.xpath("//*[@name='day']")).sendKeys("22");
        WebElement month = driver.findElement(By.xpath("//*[@name='month']"));
        Select oneMonth = new Select(month);
        oneMonth.selectByValue("09");
        driver.findElement(By.xpath("//*[@name='year']")).sendKeys("1990");
        driver.findElement(By.xpath("//*[contains(text(),'Hombre')]")).click();
    }


    //Exercise4
    @Test
    public void spotifyPlaceHolder() {
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@placeholder='Introduce tu correo electrónico.']")).sendKeys("Test@test.com");
        driver.findElement(By.xpath("//*[@placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("Testing@test.com");
        driver.findElement(By.xpath("//*[@placeholder='Crea una contraseña.']")).sendKeys("123456789");
        driver.findElement(By.xpath("//*[@placeholder='Introduce un nombre de perfil.']")).sendKeys("Testing");
        driver.findElement(By.xpath("//*[@placeholder='DD']")).sendKeys("11");
        WebElement month = driver.findElement(By.xpath("//*[@name='month']"));
        Select oneMonth = new Select(month);
        oneMonth.selectByValue("06");
        driver.findElement(By.xpath("//*[@placeholder='AAAA']")).sendKeys("2000");
        driver.findElement(By.xpath("//*[contains(text(),'No binario')]")).click();
        WebElement errMsg = driver.findElement(By.xpath("//*[contains(text(),'Este correo electrónico ya está conectado a una cuenta.')]"));
        System.out.println(".........***  " + errMsg.getText());
        WebElement errMsg2 = driver.findElement(By.xpath("//*[contains(text(),'Las direcciones de correo electrónico no coinciden.')]"));
        System.out.println(".........***  " + errMsg2.getText());
    }
    //Exercise5
    @Test
    public void spotifyByName() {
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.findElement(By.cssSelector("input[name='email']")).sendKeys("MyTesting8@test.com");
        driver.findElement(By.cssSelector("input[name='confirm']")).sendKeys("MyTesting8@test.com");
        driver.findElement(By.cssSelector("input[name='password']")).sendKeys("Passw0rd");
        driver.findElement(By.cssSelector("input[name='displayname']")).sendKeys("New Test");
        driver.findElement(By.cssSelector("input[name='day']")).sendKeys("08");
        WebElement month = driver.findElement(By.xpath("//*[@name='month']"));
        Select oneMonth = new Select(month);
        oneMonth.selectByValue("12");
        driver.findElement(By.cssSelector("input[name='year']")).sendKeys("2002");
        driver.findElement(By.xpath("//*[contains(text(),'Mujer')]")).click();
    }
    //Exercise6
    @Test
    public void checkBoxTest() throws InterruptedException {
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(3000);
        List<WebElement> sexRadioButtons = driver.findElements(By.name("sex"));
        for(WebElement element: sexRadioButtons) {
            Assert.assertFalse(element.isSelected(),"There is a  checkbox selected");
        }
        WebElement maleCheckBox = driver.findElement(By.cssSelector("[name='sex'][value='2']"));
        maleCheckBox.click();
        Assert.assertTrue(maleCheckBox.isSelected(),"Male Checkbox is not selected");
    }
    //Exercise7
    @Test
    public void spotufyByCssPH() {
        WebDriver driver = getDriver("https://www.spotify.com/uy/signup/");
        driver.manage().window().maximize();
        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("seleniumTest@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("seleniumTest@test.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("Mypwd");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("Selenium");
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("31");
        WebElement month = driver.findElement(By.xpath("//*[@name='month']"));
        Select oneMonth = new Select(month);
        oneMonth.selectByValue("01");
        driver.findElement(By.cssSelector("input[placeholder='AAAA']")).sendKeys("1950");
        driver.findElement(By.xpath("//*[contains(text(),'Mujer')]")).click();
    }

}
