package pages;

import io.cucumber.java.an.Y;
import jdk.internal.org.objectweb.asm.tree.analysis.Value;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class Home_Page {
    //vars
    WebDriver driver;
    Actions action;
    ArrayList<String> Tabs;
    WebDriverWait wait;
    //constructor
    public Home_Page(WebDriver _driver) {
        this.driver = _driver;
    }

    //elements
    By SearchField = By.id("small-searchterms");
    By SearchButton = By.className("search-box-button");
    By SearchResult = By.className("product-title");
    // By Cateogries = By.cssSelector("div[class=\"menu-toggle\"]");
    By SKUValue = By.cssSelector("div[class=\"sku\"] span[class=\"value\"]");
    By Electronics = By.cssSelector("a[href=\"/electronics\"]");
    By Computers = By.cssSelector("a[href=\"/computers\"]");
    By Apparel = By.cssSelector("a[href=\"/apparel\"]");
    By FaceBook_icon = By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]");
    By Twitter_icon = By.xpath("//a[@href=\"https://twitter.com/nopCommerce\"]");
    By rss_icon = By.cssSelector("a[href=\"/news/rss/1\"]");
    By Youtube_icon = By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]");
    By Notification_Bar = By.id("id=\"bar-notification\"");
    By AddToWishlist_BTn = By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]");
    By Above_Text = By.partialLinkText("HTC One M8 Android L 5.0 Lollipop");
    By Wishlist_Btn = By.className("wishlist-label");
    By Quantity = By.className("qty-input");

    //Methods or Action
    public void Search_By_SKU(String SKU) {
        driver.findElement(SearchField).sendKeys(SKU);
        driver.findElement(SearchButton).click();
    }

    public String get_SKu() {
        driver.findElement(SearchResult).click();
        String skuvalue = driver.findElement(SKUValue).getText();
        return skuvalue;
    }

    public void HoverCategories() {
        WebElement Computers_Category = driver.findElement(Computers);
        WebElement Electronics_Category = driver.findElement(Electronics);
        WebElement Apparel_Category = driver.findElement(Apparel);
        //choose any one WebElement from above to Hover on it .
        action = new Actions(driver);
        action.moveToElement(Electronics_Category).perform();
    }

    public void FollowUs_FaceBook() {
        driver.findElement(FaceBook_icon).click();
       Tabs = new ArrayList<>(driver.getWindowHandles());
       driver.switchTo().window(Tabs.get(1));
    }
    public void FollowUs_Twitter()
    {
        driver.switchTo().window(Tabs.get(0));
        driver.findElement(Twitter_icon).click();
        Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(2));
    }
    public void FollowUs_Youtube()
    {
        driver.switchTo().window(Tabs.get(0));
        driver.findElement(Youtube_icon).click();
        Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(3));
    }
    public void FollowUs_rss()
    {
        driver.switchTo().window(Tabs.get(0));
        driver.findElement(rss_icon).click();
        Tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(Tabs.get(0));

    }
    public void Add_To_Wishlist() {
        driver.findElement(RelativeLocator.with(AddToWishlist_BTn).below(Above_Text)).click();
       //Thread.sleep(1000);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //It waits until the green notification bar disappears
        wait.until(ExpectedConditions.invisibilityOfElementLocated(Notification_Bar));
        driver.findElement(Wishlist_Btn).click();

    }
    public boolean check_Quantity_Value()
    {
        String Temp = driver.findElement(Quantity).getAttribute("value");
        //Casting from String to integer
        int var = Integer.parseInt(Temp);
       // System.out.println(var);
        if (var >=1 )
            return true;
        else
            return false;
    }
}
