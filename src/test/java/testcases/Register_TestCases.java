package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Register_Page;

import java.time.Duration;

public class Register_TestCases {
   WebDriver driver;
   Register_Page registerPage_obj;
   SoftAssert softAssert;
    @BeforeMethod
    public void Setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        registerPage_obj =new Register_Page(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
    }
    @Test
    public void Registeration_Scenario()
    {
        registerPage_obj.ChooseGender("male");
        registerPage_obj.insertFirstName("x");
        registerPage_obj.insertlastName("y");
        registerPage_obj.selectDayFromDayDropDown("25");
        registerPage_obj.selectMonthFromMonthDropDown(12);
        registerPage_obj.selecYearFromYearDropDown("2010");
        registerPage_obj.insertEmail("v@gmail.com");
        registerPage_obj.insertPassword("121212");
        registerPage_obj.insertConfirmPassword("121212");
        registerPage_obj.clickonRegisterBtn();
        Assert.assertTrue(registerPage_obj.Msg_isdisplayed());
       Assert.assertEquals(registerPage_obj.GetColor(), "#4cb17c");
    }
    @AfterMethod
    public void TearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}