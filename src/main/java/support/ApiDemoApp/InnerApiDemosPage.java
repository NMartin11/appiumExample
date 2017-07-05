package support.ApiDemoApp;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.Page;

public class InnerApiDemosPage extends Page {

    //Constructor
    public InnerApiDemosPage(AndroidDriver driver, int throttle, String browser) {
        super(driver, throttle, browser);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @AndroidFindBy(id = "android:id/action_bar")
    private MobileElement header;

    @AndroidFindBy(accessibility = "LogTextBox")
    private MobileElement logTextBoxButton;



    public void verifyHeader(){
        System.out.println("INNER_API_DEMOS_PAGE: Verifying Header appears.");
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public void selectLogTextBoxButton(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.logTextBoxButton));

        System.out.println("INNER_API_DEMOS_PAGE: Selecting [LogTextBox] button.\n");
        this.logTextBoxButton.click();
    }
}
