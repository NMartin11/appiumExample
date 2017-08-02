package support.UswerMovements;

import io.appium.java_client.android.AndroidDriver;
import support.Page;

/**
 * Created By namartin: 7/26/2017
 **/
public class UserMovements extends Page{

    public Swipes swipes;

    public UserMovements(AndroidDriver driver, int throttle, String browser) throws Exception {
        super(driver, throttle, browser);

        swipes = new Swipes(driver, throttle, browser);
    }
}
