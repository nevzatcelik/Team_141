import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class denemeTest {

    AndroidDriver<AndroidElement> driver;
    // Android driver, Android cihazlar icin uretilmis ve ona gore ozellikleri eklenmis driver
   // AppiumDriver<MobileElement> appiumDriver;
    // oncden tek bir driver vardi. o da appiumDriver di. zamanla appium kendini gelistirdi
    // android icin ayri ios icin ayri ozellikleri bulunan driverlar uretti
    // yani onceden tek bir driver vardi hem ios icin hem android icin calisirdi. hala da calisir
   // IOSDriver<IOSElement> iosDriver;
    // Ios driver, Ios cihazlar icin uretilmis ve ona gore ozellikleri eklenmis driver


    @Test
    public void deneme() throws MalformedURLException {

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL 4"); // cihazin ismi
        //  cap.setCapability("deviceName","PIXEL 4");
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android"); // cihazin ios android neyse
        //   cap.setCapability("platormName","Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0"); // cihazin isletim sistemi
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); // cihazin otomasyonu
        /*
        UiAutomator2 isletim sistemi 6.0 dan buyuk isletim sistemleri icin calisan otomasyon
        UiAutomator ise 6.0 ya da 6 dan kucuk isletim sistemleri icin calisan otomasyon
         */

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        // bak dostum ben sana herhangi emirde bulundugumda eger verdigi emri yerine getiremiyorsan
        // ornegin git bir butona tikla dedim sende bulamadin. sonsuza kadar arama 15 saniye sonra geri don



    }
}
