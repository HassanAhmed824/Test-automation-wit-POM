package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Login_Page;
import pages.Register_Page;

import java.time.Duration;

public class Login_TestCases {
    WebDriver driver;
    Login_Page login_page_obj;
    SoftAssert softAssert;
    @BeforeMethod
    public void Setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        login_page_obj =new Login_Page(driver);
         softAssert = new SoftAssert();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://demo.nopcommerce.com");
       login_page_obj.clickonLoginBtn();
    }
    @Test(priority = 1)
    public void Test_ValidLogin()
    {
        login_page_obj.Login_Scenario("v@gmail.com","121212");
        softAssert.assertTrue(login_page_obj.MyAccountTextisdisplayed());
        softAssert.assertEquals(login_page_obj.geturl(),"//demo.nopcommerce.com/");
    }
    @Test(priority = 2)
    public void Test_inValidLogin()
    {
        login_page_obj.Login_Scenario("invalid@gmail.com","1111");
        softAssert.assertTrue(login_page_obj.ErrorMsgIsdisplayed());
        softAssert.assertEquals(login_page_obj.getColor(),"#e4434b");
    }
    @AfterMethod
    public void TearDown() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.quit();
    }


 //   @AfterMethod
}
