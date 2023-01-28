package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.Home_Page;
import pages.Register_Page;

import java.time.Duration;

public class Home_Page_TestCase  {
    WebDriver driver;
    Home_Page homePage_obj;
    SoftAssert softAssert;
    String [] acualURL;
    @BeforeMethod
    public void Setup()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        softAssert =new SoftAssert();
        homePage_obj = new Home_Page(driver);
        acualURL = new String[4];
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
        driver.get("https://demo.nopcommerce.com");
    }

    @Test (priority = 1)
    public void SearchBySKU()
    {
        homePage_obj.Search_By_SKU("DS_VA3_PC");
        String Value =  homePage_obj.get_SKu();
        Assert.assertEquals(Value,"DS_VA3_PC");
    }
    @Test (priority = 2)
    public void Hover_Scenario()
    {
        homePage_obj.HoverCategories();

    }
    @Test(priority = 3)
    public void Followus_Scenario()
    {
        homePage_obj.FollowUs_FaceBook();
        acualURL [0] = driver.getCurrentUrl();
        homePage_obj.FollowUs_Twitter();
        acualURL[1] = driver.getCurrentUrl();
        homePage_obj.FollowUs_Youtube();
        acualURL[2] = driver.getCurrentUrl();
        homePage_obj.FollowUs_rss();
        acualURL[3] = driver.getCurrentUrl();
        softAssert.assertEquals(acualURL[0],"https://www.facebook.com/nopCommerce");
        softAssert.assertEquals(acualURL[1],"https://twitter.com/nopCommerce");
        softAssert.assertEquals(acualURL[2],"https://www.youtube.com/user/nopCommerce");
        softAssert.assertEquals(acualURL[3],"https://demo.nopcommerce.com/news/rss/1");
        softAssert.assertAll();

    }
    @Test(priority = 4)
    public void Wishlist_Scenario()
    {
        homePage_obj.Add_To_Wishlist();
        //System.out.println(homePage_obj.check_Quantity_Value());
        softAssert.assertTrue(homePage_obj.check_Quantity_Value());
        softAssert.assertAll();
    }
    @AfterMethod
    public void TearDown() throws InterruptedException
    {
        Thread.sleep(5000);
        driver.quit();
    }

}
