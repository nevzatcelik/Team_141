package tests.day_5;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.testng.annotations.Test;
import pages.AllCurrencyConventerPage;
import utils.Driver;
import utils.ReusableMethods;

public class AllCurrencyConventer {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyConventerPage page=new AllCurrencyConventerPage();

    @Test
    public void currencyTest(){

// cevirmek istedigimiz para birimi zloty olarak secilir
  page.birinciMenu.click();
        ReusableMethods.scrollWithUiScrollableAndClick("PLN");
// cevirelecek olan para birimi Tl olarak secilir
  page.ikinciMenu.click();
   ReusableMethods.scrollWithUiScrollableAndClick("Turkish Lira");
// cevrilen tutar screenShot olarak kaydedilir
// Ardindan zloty nin tl karsiligi olan tl degeri kaydedilir
// kullaniciya sms olarak bildirilir
    }
}
