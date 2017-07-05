package support;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

//public abstract class TestCase implements SauceOnDemandSessionIdProvider, SauceOnDemandAuthenticationProvider{
public abstract class TestCase extends UninitializedTestCase{

    @Parameters({ "browser", "remoteOrLocal", "environment",
            "remoteAddress", "sauceBrowserVersion", "throttle",
            "maxDurationForSauce", "sauceOs", "versionNum"})
    @BeforeMethod(alwaysRun = true)
    @Override
    public void initialize(String sBrowser, String sBox, String sEnvironment,
                           String remoteAddress, String sauceBrowserVersion, String throttleText,
                           String maxDurationForSauce, String sauceOs, String versionNum) {
        System.out.println(this.getClass().getName() + ": setting up");
        System.out.println();
        super.initialize(sBrowser, sBox, sEnvironment, remoteAddress, sauceBrowserVersion, throttleText,
                maxDurationForSauce, sauceOs, versionNum);
        System.out.println(this.getClass().getName() + ": finished setting up");
    }




}
