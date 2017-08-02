package testcases;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import support.TestCase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created By namartin: 7/26/2017
 **/
public class swipeRightOnWelcomeScreen extends TestCase{

    @Test
    public void swipeRightOnWelcomeScreen() throws Exception {

        //Step 1 check we're on welcome screen
        List<String> headerText = selenium.waitAllVisible(By.className("android.widget.TextView")).stream().map(e ->
                e.getText()).collect(Collectors.toList());

        assertThisHasThat(headerText.get(0), "Welcome to Adaptive");

        //Step 2 Swipe right and check for "Increase your odds of passing the level" text
        //TODO: change swiping postions for right and left side of the screen
        userMovements.swipes.swipeForward();

        headerText = selenium.waitAllVisible(By.className("android.widget.TextView")).stream().map(e ->
                e.getText()).collect(Collectors.toList());


    }


}
