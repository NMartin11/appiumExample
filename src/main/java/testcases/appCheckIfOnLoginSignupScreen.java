package testcases;

import org.testng.annotations.Test;
import support.TestCase;

/**
 * Created By namartin: 7/25/2017
 **/
public class appCheckIfOnLoginSignupScreen extends TestCase {

    @Test
    public void checkIfOnLoginSignupScreen() throws Exception {

        String headerText = schweserApp.loginSignupScreen.getWelcomeText();
        assertThisHasThat(headerText, "Welcome to Adaptive");

    }

}
