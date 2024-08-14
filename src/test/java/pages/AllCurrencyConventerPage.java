package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class AllCurrencyConventerPage {

    public AllCurrencyConventerPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyA")
    public WebElement birinciMenu;
    @FindBy(id = "com.smartwho.SmartAllCurrencyConverter:id/SpinnerCurrencyB")
    public WebElement ikinciMenu;
}
