package support;
import com.saucelabs.common.SauceOnDemandAuthentication;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileBrowserType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import support.ApiDemoApp.ApiDemoApp;


public abstract class UninitializedTestCase {
    protected String stagePrefix = "stage.www";
    protected String testPrefix = "qa5.www2";
    protected String currentBrowser;
    protected AndroidDriver driver;
    protected String url;
    protected Page selenium;
    protected int idleClientTimeOut = -1;

    //Applications
    protected ApiDemoApp demoApp;

    //enum for the machine to which commands are sent
    protected enum Box {
        REMOTE, LOCAL, SAUCE
    }



    protected Box box;
    protected String browser;
    protected Environment environment;
    protected Platform platform;
    protected String versionNumber;
    protected int throttle;
    protected String downloadPath;
    protected DesiredCapabilities capability = DesiredCapabilities.android();

    //urls


    //Sauce Labs Creds
    public SauceOnDemandAuthentication authentication = new SauceOnDemandAuthentication(
            "kpe_qa_auto", "45e6f6c6-399b-40a0-b6d2-7e59afd27aae");
    public String sessionId;


    public void initialize(String sBrowser, String sBox, String sEnvironment,
                           String remoteAddress, String sauceBrowserVersion, String throttleText,
                           String maxDurationForSauce, String sauceOs, String versionNum) {
        try {
            //sets ENVIRONMENT
            this.throttle = Integer.parseInt(throttleText);
            if (sEnvironment.toLowerCase().contains("stage")) {
                environment = Environment.STAGE;
            } else if (sEnvironment.toLowerCase().contains("test")) {
                environment = Environment.TEST;
            } else if (sEnvironment.toLowerCase().contains("dev")) {
                environment = Environment.DEV;
            } else if (sEnvironment.toLowerCase().contains("qa2")) {
                environment = Environment.QA2;
            }

            //sets BROWSER
            if (sBrowser.toLowerCase().contains("chrome")) {
                browser = MobileBrowserType.CHROME;
            }

            //set BOX
            if (sBox.toLowerCase().contains("remote")) {
                box = Box.REMOTE;
            } else if (sBox.toLowerCase().contains("local")) {
                box = Box.LOCAL;
            } else if (sBox.toLowerCase().contains("sauce")) {
                box = Box.SAUCE;
            }

            //set PLATFORM
            if(sauceOs.toLowerCase().contains("android")) {
                platform = Platform.ANDROID;
            }

            //set VERSION
            if(!versionNum.isEmpty()) {
                versionNumber = versionNum;
            } else {
                Assert.fail("no version number, not able to compile");
            }

            switch (box) {
                case LOCAL:
                    switch (browser) {

                        case "Chrome":

                            DesiredCapabilities capabilities = DesiredCapabilities.android();
                            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "09494939");
                    //        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.1.14:5555");
                    //        capabilities.setCapability("appPackage", "io.appium.android.apis");
                    //        capabilities.setCapability("appActivity", ".ApiDemos");
                            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                            capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
                            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, versionNumber);
                            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);

                            driver = new AndroidDriver(capabilities);
                            break;
                    }
                    break;

                case REMOTE:

                    switch (browser) {

                        case "CHROME": {

                            DesiredCapabilities capabilities = DesiredCapabilities.android();
//                            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "09494939");
                                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.1.14:5555");
                            //        capabilities.setCapability("appPackage", "io.appium.android.apis");
                            //        capabilities.setCapability("appActivity", ".ApiDemos");
                            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                            capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
                            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
                            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);

                            driver = new AndroidDriver(capabilities);
                            break;

                        }
                    }

             /*   case SAUCE:

                    switch (browser) {
                        case "CHROME": {
                            DesiredCapabilities capabilities = DesiredCapabilities.android();
//                            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "09494939");
                            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "192.168.1.14:5555");
                            //        capabilities.setCapability("appPackage", "io.appium.android.apis");
                            //        capabilities.setCapability("appActivity", ".ApiDemos");
                            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
                            capabilities.setCapability(MobileCapabilityType.PLATFORM, Platform.ANDROID);
                            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "6.0.1");
                            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);

                            driver = new AndroidDriver(capabilities);
                            break;
                        }
                    }
                    if(idleClientTimeOut >= 0){
                        capability.setCapability("idleTimeout", "" + idleClientTimeOut);
                    }
                    capability.setCapability("tunnelIdentifier", System.getProperty("build.name"));
                    capability.setCapability("version", sauceBrowserVersion);
                    capability.setCapability("maxDuration", maxDurationForSauce);
                    capability.setCapability("platform", platform);
                    if(sBrowser.toLowerCase().contains("ipad")){
                        capability.setCapability("platform", "OS X 10.10");
                        capability.setCapability("version", "9.2");
                        capability.setCapability("deviceName","iPad 2");
                        capability.setCapability("deviceOrientation", "portrait");
                    }
                    capability.setCapability("name", getClass().getName());
                    capability.setCapability("build", System.getProperty("build.name")
                            + " " + System.getProperty("jenkins.buildNumber"));
                    driver = new RemoteWebDriver(new URL("http://"
                            + authentication.getUsername() + ":"
                            + authentication.getAccessKey()
                            + "@ondemand.saucelabs.com:80/wd/hub"), capability);

                    ((RemoteWebDriver)driver).setFileDetector(new LocalFileDetector());

                    break;*/

            }
            selenium = new Page(driver, this.throttle, browser);
            demoApp = new ApiDemoApp(driver, this.throttle, browser);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void teardown() {
        try {
            driver.quit();
        } catch (Exception e) {
            System.out.println("Failed to close the browser.  "
                    + "The browser may have crashed or been closed.");
        }
    }
    protected void setIdleClientTimeOut(int idleClientTimeOut){
        this.idleClientTimeOut = idleClientTimeOut;
    }

    protected void goToUrlByEnvironment(String stageUrl, String testUrl){
        switch (environment) {
            case STAGE:
                driver.get(stageUrl);
                break;
            case TEST:
                driver.get(testUrl);
                break;
            case DEV:
                break;
            default:
                break;
        }
    }

    protected void goToUrlByEnvironment(String stageUrl, String testUrl, String devUrl, String test2Url){
        switch (environment) {
            case STAGE:
                driver.get(stageUrl);
                break;
            case TEST:
                driver.get(testUrl);
                break;
            case DEV:
                driver.get(devUrl);
                break;
            case QA2:
                driver.get(test2Url);
            default:
                break;
        }
    }

    /**
     * Assert that url contains text.
     * @param text
     */
    public void assertUrlContains(String text){
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains(text),
                "Url did not contain " + text + ".");
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void assertThisHasThat(String actual, String expected) {
        Assert.assertTrue(actual.contains(expected), "Expected to contain this: " + expected + " Found: " + actual);
    }
    public void assertThisNotHasThat(String actual, String expected) {
        Assert.assertTrue(!actual.contains(expected), "Expected to not contain this: " + expected + " Found: " + actual);
    }

    public void assertThisIsThat(String actual, String expected) {
        Assert.assertEquals(actual, expected);
    }

    //override this to clean up after a test
    protected void cleanup() throws Exception {
        //does nothing
    }

    @AfterMethod(alwaysRun = true)
    public void callTearDown() throws Exception{
        System.out.println(this.getClass().getName() + ": tearing down");
        System.out.println();
        cleanup();
        teardown();
    }

}

