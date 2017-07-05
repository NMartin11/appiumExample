package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import support.ApiDemoApp.HomeScreenPage;
import support.TestCase;
import support.ApiDemoApp.ApiDemoApp;

/**
 * Created by namartin on 6/21/2017.
 */
public class demoAppTest extends TestCase {

    @Test
    public void test_login() throws Exception {

        demoApp.homeScreen.verifyHeader();
        demoApp.homeScreen.selectTextButton();

        demoApp.innerScreen.verifyHeader();
        demoApp.innerScreen.selectLogTextBoxButton();

        demoApp.logTextBoxScreen.verifyHeader();
        demoApp.logTextBoxScreen.selectAddButton();

        String expectedPanelText = "This is a test";
        String actualPanelText = demoApp.logTextBoxScreen.getPanelText();

        System.out.println("Checking panel text");

        Assert.assertTrue(actualPanelText.contains(expectedPanelText));


    }
}
