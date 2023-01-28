package pages;

import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.Select;

public class Register_Page {
    //Vars
    WebDriver driver;

    //constructors
    public Register_Page( WebDriver driver)
    {
        this.driver=driver;
    }
    //elemsents
    By MaleRadioBtn = By.id("gender-male");
    By FemaleRadioBtn = By.id("gender-female");
    By FirstNameField = By.id("FirstName");
    By LastNameField = By.id("LastName");
    By DayDropDown = By.name("DateOfBirthDay");
    By MonthDropDown = By.name("DateOfBirthMonth");
    By YearDropDown = By.name("DateOfBirthYear");
    By EmailField = By.id("Email");
    By PasswordField = By.id("Password");
    By ConfirmPasswordField = By.id("ConfirmPassword");
    By Register_Button = By.id("register-button");
    By Success_Msg = By.cssSelector("div[class=\"result\"]");
    // Methods or actions
    public void ChooseGender(String gender)
    {
        if(gender=="male")
            driver.findElement(MaleRadioBtn).click();
        else if (gender=="female")
            driver.findElement(FemaleRadioBtn).click();
    }
    public void insertFirstName(String firstName)
    {
        driver.findElement(FirstNameField).sendKeys(firstName);
    }
    public void insertlastName(String lastName)
    {
        driver.findElement(LastNameField).sendKeys(lastName);
    }
    public void selectDayFromDayDropDown(String day)
    {
        Select selectDay = new Select(driver.findElement(DayDropDown));
        selectDay.selectByValue(day);
    }
    public void selectMonthFromMonthDropDown(int month_num)
    {
        Select selectMonth = new Select(driver.findElement(MonthDropDown));
        selectMonth.selectByIndex(month_num);
    }
    public void selecYearFromYearDropDown(String year)
    {
        Select selectYear = new Select(driver.findElement(YearDropDown));
        selectYear.selectByValue(year);
    }
    public void insertEmail(String email)
    {
        driver.findElement(EmailField).sendKeys(email);
    }
    public void insertPassword(String password)
    {
        driver.findElement(PasswordField).sendKeys(password);
    }
    public void insertConfirmPassword(String confirmpassword)
    {
        driver.findElement(ConfirmPasswordField).sendKeys(confirmpassword);
    }
    public void clickonRegisterBtn()
    {
        driver.findElement(Register_Button).click();
    }
    public boolean Msg_isdisplayed()
    {
        System.out.println(driver.findElement(Success_Msg).isDisplayed());
        return driver.findElement(Success_Msg).isDisplayed();
    }
    public String GetColor()
    {
        String Temp = driver.findElement(Success_Msg).getCssValue("color");
        //System.out.println(Color.fromString(Temp).asHex());
        return Color.fromString(Temp).asHex();
    }







}
