package Week12;

import org.testng.annotations.*;

public class TestngTest {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("Before Suite");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("Before Test");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("Before Class");
    }
    //BeforeMethod  before each Test
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @Test
    public void firstTest(){
        System.out.println("This is a test");
    }

    @Test
    public void secondTest(){
        System.out.println("This is an other test");
    }
    //AfterMethod after each test
    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("After Class");
    }
    @AfterTest
    public void AfterTest(){
        System.out.println("After Test");
    }
    @AfterSuite
    public void AfterSuite(){
        System.out.println("After Suite");
    }

}
