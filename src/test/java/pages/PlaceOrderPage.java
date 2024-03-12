package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

@Data
public class PlaceOrderPage {
    public PlaceOrderPage(){

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtQuantity")
    private WebElement quantity;

    @FindBy (id = "ctl00_MainContent_fmwOrder_txtName")
    private WebElement name;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox2")
    private WebElement street;

    @FindBy (id = "ctl00_MainContent_fmwOrder_TextBox3")
    private WebElement city;

}
