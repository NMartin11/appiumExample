package support.SchweserApp;

import io.appium.java_client.android.AndroidDriver;
import support.Page;

/**
 * Created By namartin: 7/25/2017
 **/
public class SchweserApp extends Page {

    public  LoginSignupScreen loginSignupScreen;

    //Constructor
    public SchweserApp(AndroidDriver driver, int throttle, String browser) {
        super(driver, throttle, browser);

        loginSignupScreen = new LoginSignupScreen(driver, throttle, browser);

    }

}
