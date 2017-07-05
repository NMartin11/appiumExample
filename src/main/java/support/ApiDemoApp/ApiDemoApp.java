package support.ApiDemoApp;

import io.appium.java_client.android.AndroidDriver;
import support.Page;

/**
 * Created by namartin on 6/21/2017.
 */
public class ApiDemoApp extends Page{

    public HomeScreenPage homeScreen;
    public InnerApiDemosPage innerScreen;
    public LogTextBoxPage logTextBoxScreen;

    //Constructor
    public ApiDemoApp(AndroidDriver driver,  int throttle, String browser) {
        super(driver, throttle, browser);

        homeScreen = new HomeScreenPage(driver, throttle,browser);
        innerScreen = new InnerApiDemosPage(driver, throttle, browser);
        logTextBoxScreen = new LogTextBoxPage(driver, throttle, browser);
    }
}
