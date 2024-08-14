package tests.day_4;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPage;
import utils.Driver;
import utils.ReusableMethods;

public class KiwiApp {
    AndroidDriver<AndroidElement>driver=Driver.getAndroidDriver();
    KiwiPage page=new KiwiPage();

    @Test
    public void kiwiAppTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));
// uygulamanin basariyla acildigi dogrulanir
         Assert.assertTrue(page.misafirButonu.isDisplayed());
// misafir olarak devam et e tiklanir
        page.misafirButonu.click();
// ardinda gelecek olan 3 adimada yesil butona basilarak devam edilir 542,2043
       Thread.sleep(1000);
        for (int i = 0; i < 3; i++) {
            ReusableMethods.koordinatTiklamaMethodu(542,2043,500);
        }


// Trip type,one way olarak secilir
        page.returnButton.click();
        page.oneWay.click();
        page.fromButton.click();
// kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
     page.clearButton.click();
// kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        if (!driver.isKeyboardShown()){
         driver.getKeyboard().pressKey("istanbul");
        }else {
           page.kalkisKutusu.sendKeys("Antalya");
        }

       page.fromTopPlusButton.click();
// varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
// gidis tarihi agustos ayinin 21 i olarak secilir ve set date e tiklanir
// search butonuna tiklanir
// en  ucuz ve aktarmasiz filtrelemeleri yapilir
// gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
    }
}
