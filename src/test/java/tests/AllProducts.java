package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllProductsPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.FrameworkConstance;
import utilities.SeleniumUtils;

import java.util.ArrayList;
import java.util.List;

public class AllProducts extends TestBase{

    @Test
    public void verifyColumns(){

        Driver.getDriver().get(FrameworkConstance.HOME_PAGE_URL);

        new LoginPage().login();
        new HomePage().clickOnLink("View all products");

        List<String> headersText = new AllProductsPage().extractHeadersText();

//        List<WebElement> headers = new AllProductsPage().getHeaders();
//        List<String> headersText = SeleniumUtils.getElementsText(headers);

        Assert.assertEquals(headersText, List.of("Product name", "Price", "Discount"));
    }


    @Test (groups = "smoke")
    public void verifyProducts(){

        Driver.getDriver().get(ConfigReader.getProperty("url"));
        Driver.getDriver().findElement(By.id("ctl00_MainContent_username")).sendKeys(ConfigReader.getProperty("username"), Keys.TAB, ConfigReader.getProperty("password"), Keys.ENTER);

        Driver.getDriver().findElement(By.linkText("View all products")).click();

        List<WebElement> elements = Driver.getDriver().findElements(By.xpath("//table[@class='ProductsTable']//tr//td[1]"));
        List<String> elementsText  = new ArrayList<>();
        elements.forEach( webElement -> elementsText.add(webElement.getText()) );

        Assert.assertEquals(elementsText, List.of("MyMoney", "FamilyAlbum", "ScreenSaver"));
    }

}
