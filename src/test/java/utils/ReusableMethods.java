package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import java.time.Duration;

public class ReusableMethods {


    public static void koordinatTiklamaMethodu(int x,int y,int bekleme) throws InterruptedException {
        TouchAction action=new TouchAction<>(Driver.getAndroidDriver());
        action.press(PointOption.point(x,y))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(bekleme)))
                .release()
                .perform();
    }
}
