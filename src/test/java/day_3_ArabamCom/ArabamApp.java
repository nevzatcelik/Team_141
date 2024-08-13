package day_3_ArabamCom;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.aspectj.weaver.ast.And;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.swing.plaf.PanelUI;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ArabamApp {
    AndroidDriver<AndroidElement>driver;
    @BeforeTest
    public void setUp() throws MalformedURLException {
        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.DEVICE_NAME,"PIXEL 4"); // cihazin ismi
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android"); // cihazin ios android neyse
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0"); // cihazin isletim sistemi
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2"); // cihazin otomasyonu
        cap.setCapability("appPackage","com.dogan.arabam");
        // AppPackage uzerinde caliscak oldugumuz uygulamanin kimlik bilgisidir. Apk infodan kimlik bilgisi bulunur
        cap.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");
        // AppActivity ise uzerinde calisacak oldugumuz uygulamanin hangi sayfasindan baslamak istedigimizi belir
        // yani profil kismindan baslamak istiyorsam ilgili activity bulunur ve appActivity bolumune
        // yazilarak uygulama oradan baslatilir

        driver=new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"),cap);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void arabamTest1() throws InterruptedException {
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        // uygulaminin basarili bir sekilde acildigi dogrulanir
         Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());
        // alt menuden ilan ara butonuna tiklanir
        driver.findElementByXPath("//*[@text='İlan Ara']").click();
        // kategori olarak otomobil secilir
        driver.findElementByXPath("//*[@text='Otomobil']").click();
        // arac olarak Volkswagen secilir
        Thread.sleep(2000);
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(521,1809))
                // pres islemi ekran parmagimizi kaydir islemini baslatmak icin ilk dokundugumuz yerdir
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(100)))
                // baslangic noktasiyla bitis noktasi arasindaki gecen sure
                // eger sure azalirsa; gidilen yol mesafesi ARTAR
                // eger sureyi arttirirsan; gidilen yol mesafesi AZALIR !!
                // yani tamamen bir ters oranti vardir. ekranda daha fazla assagi ya da yukari gitmek istiyorsak
                // birim zamanda sureyi azaltmaliyiz
                .moveTo(PointOption.point(521,521))
                // Move to pressten sonra kaydirilacak alan olan ekrandaki koordinat noktasi
                .release() // kaydirma islemi bittikten sonra ekrandan parmagimizi kaldirma islemi
                .perform(); // kaydirma islemi yapmasi icin yap emrinin verilmesi
           Thread.sleep(1000);
          driver.findElementByXPath("//*[@text='Volkswagen']").click();
        // arac markasi olarak passat secilir
         driver.findElementByXPath("//*[@text='Passat']").click();
        // 1.4 TSI BlueMotion secilir
         driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi yapilir
        driver.findElementByXPath("//*[@text='Comfortline']").click();

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir 408,400
        Thread.sleep(1500);
        action.press(PointOption.point(408,400))
                .release()
                .perform();

        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String enUcuzFiyat=driver.findElementByXPath("(//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]").getText();
        enUcuzFiyat=enUcuzFiyat.replaceAll("\\D","");


        Assert.assertTrue(Integer.parseInt(enUcuzFiyat)>500000);

    }

    @Test
    public void arabamLoginTest(){


    }
}
