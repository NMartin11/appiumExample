package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import support.TestCase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By namartin: 7/25/2017
 **/
public class appCheckIfOnLoginSignupScreen extends TestCase {

    @Test
    public void checkIfOnLoginSignupScreen() throws Exception {


        List<String> headerText = selenium.waitAllVisible(By.className("android.widget.TextView")).stream().map(e ->
                e.getText()).collect(Collectors.toList());

        assertThisHasThat(headerText.get(0), "Welcome to Adaptive");
        assertThisHasThat(headerText.get(1), "Swipe to learn more.");
        assertThisHasThat(headerText.get(2), "Sign up");
        assertThisHasThat(headerText.get(3), "Log in");


    }

}
