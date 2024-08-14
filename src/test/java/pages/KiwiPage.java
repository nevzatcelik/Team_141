package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class KiwiPage {

    public KiwiPage(){
        PageFactory.initElements((WebDriver) Driver.getAndroidDriver(),this);
    }

    @FindBy(xpath = "//*[@text='Continue as a guest']")
    public WebElement misafirButonu;

    @FindBy(xpath = "//*[@text='Return']")
    public WebElement returnButton;

    @FindBy(xpath = "//*[@text='One way']")
    public WebElement oneWay;

    @FindBy(xpath = "//*[@text='From:']")
    public WebElement fromButton;

    @FindBy(xpath = "//*[@content-desc='Clear All']")
    public WebElement clearButton;

    @FindBy(xpath = "//*[@class='android.widget.EditText']")
    public WebElement kalkisKutusu;

    @FindBy(xpath = "(//*[@content-desc='Add destination'])[1]")
    public WebElement fromTopPlusButton;
}
