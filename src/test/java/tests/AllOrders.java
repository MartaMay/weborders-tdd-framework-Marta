package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class AllOrders extends TestBase{


    @Test (groups = "smoke")
    public void testButtons(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

        Assert.assertTrue(Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.id("ctl00_MainContent_btnUncheckAll")).isDisplayed());
        Assert.assertTrue(Driver.getDriver().findElement(By.id("ctl00_MainContent_btnDelete")).isDisplayed());
}

    @Test
    public void testCheckAll(){
        Driver.getDriver().get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester", Keys.TAB, "test", Keys.ENTER);

        Driver.getDriver().findElement(By.id("ctl00_MainContent_btnCheckAll")).click();

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//input[@type='checkbox']"));

        for (WebElement checkbox : elements) {
            Assert.assertTrue(checkbox.isSelected());
        }

    }

}
