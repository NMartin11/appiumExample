package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import javafx.scene.effect.MotionBlur;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by namartin on 6/12/2017.
 */
public class LogTextBoxPage {

    private AndroidDriver driver;

    //Constructor
    public LogTextBoxPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver, 30, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "android:id/action_bar")
    private MobileElement header;

    @AndroidFindBy(accessibility = "Add")
    private MobileElement addButton;

    @AndroidFindBy(id = "io.appium.android.apis:id/text")
    private MobileElement panel;

    public void verifyHeader() {
        System.out.println("HOME_SCREEN_PAGE: Verifying Header apperas.");
        WebDriverWait wait = new WebDriverWait(this.driver, 30);
        wait.until(ExpectedConditions.visibilityOf(header));
    }

    public void selectAddButton() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.addButton));

        System.out.println("LOG_TEXT_BOX_PAGE: Selecting [Add] button. \n");
        this.addButton.click();
    }

    public String getPanelText() {
        return this.panel.getText();
    }






















}
