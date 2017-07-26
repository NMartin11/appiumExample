package support.SchweserApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import support.Page;

import java.util.concurrent.TimeUnit;

/**
 * Created By namartin: 7/25/2017
 **/
public class LoginSignupScreen extends Page{

    //Constructor
    public LoginSignupScreen(AndroidDriver driver, int throttle, String browser) {
        super(driver, throttle, browser);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver,throttle, TimeUnit.SECONDS),this);
    }

    //UI Elements
    @AndroidFindBy(className = "android.widget.TextView")
    private MobileElement welcomeHeader;


    //Getters
    public String getWelcomeText() throws InterruptedException {
        return waitVisible(welcomeHeader).getText();
    }
}
