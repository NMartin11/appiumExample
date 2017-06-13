package tests;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomeScreenPage;
import pages.InnerApiDemosPage;
import pages.LogTextBoxPage;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;


/**
 * Created by namartin on 5/22/2017.
 */
public class SmokeTest {

   //Create instance for appium driver
    private static AndroidDriver driver;
    private HomeScreenPage homeScreen;
    private InnerApiDemosPage innerApiDemosPage;
    private LogTextBoxPage logTextBoxPage;



    //set up desired capabilites for driver instance
    @BeforeClass
    public void DesiredCapabilites() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "09494939");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", ".ApiDemos");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
//        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);


        driver = new AndroidDriver(capabilities);
        homeScreen = new HomeScreenPage(driver);
        innerApiDemosPage = new InnerApiDemosPage(driver);
        logTextBoxPage = new LogTextBoxPage(driver);


    }

    @Test
    public void test_login() throws Exception {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        homeScreen.verifyHeader();
        homeScreen.selectTextButton();

        innerApiDemosPage.verifyHeader();
        innerApiDemosPage.selectLogTextBoxButton();

        logTextBoxPage.verifyHeader();
        logTextBoxPage.selectAddButton();

        String expectedPanelText = "This is a test";
        String actualPanelText = logTextBoxPage.getPanelText();

        System.out.println("Checking panel text");

        Assert.assertTrue(actualPanelText.contains(expectedPanelText));


    }




    @AfterSuite
    public void tearDownAppium() throws Exception {
            System.out.println("\nTearing Down Driver.");
            driver.quit();
    }

}
