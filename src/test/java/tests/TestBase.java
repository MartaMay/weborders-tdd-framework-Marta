package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Driver;

import java.time.Duration;

public class TestBase {
   //protected WebDriver driver;

    @BeforeMethod (alwaysRun = true)
    public void setUp() {

        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod (alwaysRun = true)
    public void tearDown() {


        Driver.quitDriver();
    }
}
