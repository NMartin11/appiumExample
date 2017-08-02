package support.UswerMovements;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.PageFactory;
import support.Page;

import java.util.concurrent.TimeUnit;

/**
 * Created By namartin: 7/26/2017
 **/
public class Swipes extends Page {

    //start and end points for swiping horizontally
    private int rightSide;
    private int leftSide;

    //start and end points for swiping horizontally
    private int middle;
    private int endY;


    //Constructor
    public Swipes(AndroidDriver driver, int throttle, String browser) throws Exception {
        super(driver, throttle, browser);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver,throttle, TimeUnit.SECONDS),this);
        setScreenDimensionsForSwiping();
    }


    public Dimension getScreenSize() throws Exception {
        return driver.manage().window().getSize();
    }

    public void setScreenDimensionsForSwiping() throws Exception {
        //start and end points for swiping horizontally
        rightSide = (int) (getScreenSize().width * 0.70);
        leftSide = (int) (getScreenSize().width * 0.30);

        //Middle of screen
        middle = (int) (getScreenSize().width * 0.70);
    }


    public void swipeForward() throws Exception {
        driver.swipe(rightSide, middle, leftSide, middle, 100);
    }

    public void swipeBack() throws Exception {
        driver.swipe(leftSide,  middle,  rightSide,  middle,  3000);
    }

}
