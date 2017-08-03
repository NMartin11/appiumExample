package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import support.TestCase;

import java.util.List;
import java.util.stream.Collectors;

/**
 * opens app, swipes right on the home screen and checks text on current screen
 * Created By namartin: 7/26/2017
 **/
public class swipeRightOnWelcomeScreenThenSwipeBack extends TestCase{

    @Test(groups = "schewserApp")
    public void swipeRightOnWelcomeScreenThenSwipeBack() throws Exception {

        //Step 1 check we're on welcome screen
        List<String> headerText = selenium.waitAllVisible(By.className("android.widget.TextView")).stream().map(e ->
                e.getText()).collect(Collectors.toList());

        assertThisHasThat(headerText.get(0), "Welcome to Adaptive");

        //Step 2 Swipe right and check for "Increase your odds of passing the level" text
        userMovements.swipes.swipeForward();

        headerText = selenium.waitAllVisible(By.className("android.widget.TextView")).stream().map(e ->
                e.getText()).collect(Collectors.toList());

        assertThisHasThat(headerText.get(0), "Increase your odds of passing the Level I CFA® exam");

        //Step 3
        userMovements.swipes.swipeBack();

        headerText = selenium.waitAllVisible(By.className("android.widget.TextView")).stream().map(e ->
                e.getText()).collect(Collectors.toList());

        assertThisHasThat(headerText.get(0), "Welcome to Adaptive");

    }


}

