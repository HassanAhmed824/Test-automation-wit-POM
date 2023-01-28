package pages;

import io.cucumber.java.ja.且つ;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

import java.awt.*;

public class Login_Page {
    //Vars
    WebDriver driver;

    //constructors
    public Login_Page(WebDriver driver)
    {
        this.driver = driver;
    }
    //elemsents
    By Emailfield = By.id("Email");
    By Passwordfield = By.id("Password");
    By Submit_LoginButton = By.cssSelector("button[class=\"button-1 login-button\"]");
    By LoginButton = By.cssSelector("a[class=\"ico-login\"]");
    By MyAccountText = By.cssSelector("a[class=\"ico-account\"]");
    By ErrorMsgText = By.cssSelector("div[class=\"message-error validation-summary-errors\"]");
    // Methods
    public void clickonLoginBtn()
    {
        driver.findElement(LoginButton).click();
    }
    public void Login_Scenario(String email, String password)
    {
        driver.findElement(Emailfield).sendKeys(email);
        driver.findElement(Passwordfield).sendKeys(password);
        driver.findElement(Submit_LoginButton).click();
    }
    public boolean MyAccountTextisdisplayed()
    {
        return driver.findElement(MyAccountText).isDisplayed();
    }
    public String geturl()
    {
       return driver.getCurrentUrl();
    }
    public boolean ErrorMsgIsdisplayed()
    {
        return driver.findElement(ErrorMsgText).isDisplayed();
    }
    public String getColor()
    {
        String temp= driver.findElement(ErrorMsgText).getCssValue("color");
       return Color.fromString(temp).asHex();
    }

}
