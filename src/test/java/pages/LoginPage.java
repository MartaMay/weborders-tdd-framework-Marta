package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

@Data
public class LoginPage {



    public LoginPage(){
        //this line initializes all variables with @FindBy annotations
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id="ctl00_MainContent_username")
    private  WebElement userNameField;

    public WebElement getUserNameField() {
        return userNameField;
    }

    public void login(String username, String password){
        userNameField.sendKeys(ConfigReader.getProperty(username), Keys.TAB, ConfigReader.getProperty(password), Keys.ENTER);

    }
    public void login(){
        userNameField.sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

    }

}
