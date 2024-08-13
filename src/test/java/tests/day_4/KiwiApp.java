package tests.day_4;

import org.testng.annotations.Test;
import utils.Driver;

public class KiwiApp {

    @Test
    public void kiwiAppTest(){
        Driver.getAndroidDriver();
    }
}
