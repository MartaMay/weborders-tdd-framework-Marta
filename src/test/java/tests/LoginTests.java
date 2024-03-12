package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LoginTests extends TestBase{


            @Test
        public void testValidLogin() throws IOException {


            Driver.getDriver().get(ConfigReader.getProperty("url"));
            new LoginPage().getUserNameField().sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);
            Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders");
    }
    @Test
    public void testValidLoginPageObjectModelStyle() throws IOException {

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigReader.getProperty("username"), ConfigReader.getProperty("password"));
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test (groups = "smoke")
    public void testInvalidLogin(){

        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        new LoginPage().getUserNameField().sendKeys("Tester", Keys.TAB, " ", Keys.ENTER);
        Assert.assertEquals(Driver.getDriver().getTitle(), "Web Orders Login");
    }
    @Test
    public void testInvalidCredentialsNoUsername(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        new LoginPage().login("invalidUser", "invalidPass");
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoPassword(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        new LoginPage().getUserNameField().sendKeys("cscs", Keys.TAB, "", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }

    @Test
    public void testInvalidCredentialsNoCred(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        new LoginPage().getUserNameField().sendKeys("", Keys.TAB, "", Keys.ENTER);
        Assert.assertNotEquals(Driver.getDriver().getTitle(), "Web Orders");
    }
}
