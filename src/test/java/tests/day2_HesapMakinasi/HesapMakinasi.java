package tests.day2_HesapMakinasi;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class HesapMakinasi {
    AndroidDriver<AndroidElement> driver;

    @Test
    public void hesapMakinasiTest() throws MalformedURLException {
        // kullanici gerekli kurulumlari yapar
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL 4"); // cihazin ismi
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android"); // cihazin ios android neyse
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0"); // cihazin isletim sistemi
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); // cihazin otomasyonu
        cap.setCapability(MobileCapabilityType.APP,"C:\\Users\\ahmet\\IdeaProjects\\Appium_T_141\\Apps\\Calculator_8.4 (503542421)_Apkpure (3).apk");

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        // uygulamanin yuklendigini dogrular(isInstalled)
        Assert.assertTrue(driver.isAppInstalled("com.google.android.calculator"));
        // uygulamanin acildigini dogrular
       Assert.assertTrue(driver.findElementById("com.google.android.calculator:id/clr").isDisplayed());

        // 400 un 3 katininin 1200 oldugunu hesap makinasindan dogrulayalim
        driver.findElementByAccessibilityId("4").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("0").click();
        driver.findElementByAccessibilityId("multiply").click();
        driver.findElementByAccessibilityId("3").click();
        String islemSonucu=driver.findElementById("com.google.android.calculator:id/result_preview").getText();
        System.out.println(islemSonucu); // 1200
        int expected=1200;
        Assert.assertEquals(Integer.parseInt(islemSonucu),expected);

    }
}
