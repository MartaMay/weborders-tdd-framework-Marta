package pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utilities.CSVReader;

import java.util.Arrays;

public class DemoSeleniumUtils {

    @Test
    public static void main() {

//headless test
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");

        WebDriver driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get("https://www.mockaroo.com/");

        driver.findElement(By.xpath("//a[@href='/pricing'][@class]")).click();

    }

}
