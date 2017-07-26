package support.ApiDemoApp;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Page;

import java.util.concurrent.TimeUnit;

/**
 * Created by namartin on 6/12/2017.
 */
public class HomeScreenPage extends Page{


    //Constructor
    public HomeScreenPage(AndroidDriver driver, int throttle, String browser) {
        super(driver, throttle, browser);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(this.driver,throttle, TimeUnit.SECONDS),this);
    }


    @AndroidFindBy(id = "android:id/action_bar")
    private MobileElement header;

    @AndroidFindBy(accessibility = "Text")
    private MobileElement textButton;


    public void verifyHeader() {
        System.out.println("HOME_SCREEN_PAGE: Verifying Header apperas.");
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public void selectTextButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(textButton));

        System.out.println("HOME_SCREEN_PAGE: Selecting [text} button. \n");
        this.textButton.click();
    }





}
