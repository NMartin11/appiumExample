package support;

import com.codesnippets4all.json.parsers.JSONParser;
import com.codesnippets4all.json.parsers.JsonParserFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Page {
    protected String browser;
    protected WebDriver driver;
    protected int timeOutInSeconds = 30;
    protected int tryTimeoutInSeconds = 5;
    protected int throttle;
    public boolean useAjaxWaits;

    public Page(WebDriver driver, int throttle, String browser) {
        this.driver = driver;
        this.throttle = throttle;
        this.browser = browser;
    }

    public void hardWaitInSeconds(int waitTimeInSeconds) {
        try {
            Thread.sleep(waitTimeInSeconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void hardWaitInMillis(int waitTimeInMillis) {
        try {
            Thread.sleep(waitTimeInMillis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isElementPresent(By locator) {
        try {
            performWait(0);
            new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementPresent(By locator, int customTimeOut) {
        try {
            performWait(0);
            new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(WebElement element) {
        try {
            performWait(0);
            new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(WebElement element, int customTimeOut) {
        try {
            performWait(0);
            new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(By by) {
        try {
            performWait(0);
            new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementVisible(By by, int customTimeOut) {
        try {
            performWait(0);
            new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementClickable(WebElement element) {
        try {
            performWait(0);
            new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementClickable(WebElement element, int customTimeOut) {
        try {
            performWait(0);
            new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementClickable(By by) {
        try {
            performWait(0);
            new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isElementClickable(By by, int customTimeOut) {
        try {
            performWait(0);
            new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement waitUntil(ExpectedCondition<WebElement> expectedCondition) {
        performWait(0);
        WebElement e = new WebDriverWait(driver, timeOutInSeconds).until(expectedCondition);
        return e;
    }

    public WebElement waitUntil(ExpectedCondition<WebElement> expectedCondition, int customTimeOut) {
        performWait(0);
        WebElement e = new WebDriverWait(driver, customTimeOut).until(expectedCondition);
        return e;
    }

    public boolean waitUntilBoolean(ExpectedCondition<Boolean> expectedCondition) {
        performWait(0);
        boolean e = new WebDriverWait(driver, timeOutInSeconds).until(expectedCondition);
        return e;
    }

    public WebElement waitVisible(WebElement e){
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(e));
    }

    public WebElement waitVisible(WebElement e, int customTimeOut){
        performWait(0);
        return new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.visibilityOf(e));
    }

    public WebElement waitVisible(By by){
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitVisible(By by, int customTimeOut){
        performWait(0);
        return new WebDriverWait(driver, customTimeOut)
                .until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public List<WebElement> waitAllVisible(By by){
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public List<WebElement> waitAllVisible(By by, int customTimeOut){
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public List<WebElement> waitAllVisible(List<WebElement> e){
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.visibilityOfAllElements(e));
    }





    //present


    public WebElement waitPresent(By by){
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitPresent(By by, int customTimeOut){
        performWait(0);
        return new WebDriverWait(driver, customTimeOut)
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> waitAllPresent(By by){
        performWait(0);
        new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElements(by);
    }

    public List<WebElement> waitAllPresent(By by, int customTimeOut){
        performWait(0);
        new WebDriverWait(driver, timeOutInSeconds)
                .until(ExpectedConditions.presenceOfElementLocated(by));
        return driver.findElements(by);
    }



    public WebElement waitClickable(By by, int customTimeOut){
        performWait(0);
        return new WebDriverWait(driver, customTimeOut)
                .until(ExpectedConditions.elementToBeClickable(by));
    }

    /**
     * Checks if a checkbox is set to on by default
     *
     * @param e
     * @param customTimeOut
     * @return true if checkbox was already checked
     * @throws InterruptedException
     */
    public boolean isCheckboxChecked (WebElement e, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        return new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(e)).isSelected();
    }

    /**
     * Checks if a checkbox is set to on by default
     *
     * @param customTimeOut
     * @return true if checkbox was already checked
     * @throws InterruptedException
     */
    public boolean isCheckboxChecked (By by, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        return new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(by)).isSelected();
    }

    /**
     * Sets a checkbox on only if it is not already checked
     *
     * @param e
     * @param customTimeOut
     * @return true if checkox is set to on by this method
     * @throws InterruptedException
     */
    public boolean setCheckboxOn (WebElement e, int customTimeOut) throws InterruptedException {
        boolean clickedCheckbox = false;
        if (!isCheckboxChecked(e, customTimeOut)) {
            click(e);
            clickedCheckbox = true;
        }
        return clickedCheckbox;
    }
    public void click(WebElement e) throws InterruptedException {
        performWait(throttle);
        switch (browser) {
            default:
                new Actions(driver).moveToElement(
                        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(e)))
                        .click().perform();
                break;
        }
    }

    public void click(WebElement e, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        switch (browser) {

            default:
                new Actions(driver)
                        .moveToElement(
                                new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(e)))
                        .click().perform();
                break;
        }
    }

    public void click(By by) throws InterruptedException {
        performWait(throttle);
        switch (browser) {
            default:
                new Actions(driver).moveToElement(
                        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by)))
                        .click().perform();
                break;
        }
    }

    public void click(By by, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        switch (browser) {

            default:
                new Actions(driver)
                        .moveToElement(
                                new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(by)))
                        .click().perform();
                break;
        }
    }

    public void clear(By by) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by)).clear();
    }

    public void clear(By by, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(by)).clear();
    }

    public void clear(WebElement e) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(e)).clear();
    }

    public void clear(WebElement e, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(e)).clear();
    }

    public void type(WebElement e, String text) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(e)).sendKeys(text);
    }

    public void type(WebElement e, String text, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(e)).sendKeys(text);
    }

    public void type(By by, String text) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void type(By by, String text, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void clearAndType(WebElement e, String text) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(e)).clear();
        performWait(0);
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(e)).sendKeys(text);
    }

    public void clearAndType(WebElement e, String text, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(e)).clear();
        performWait(0);
        new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(e)).sendKeys(text);
    }

    public void clearAndType(By by, String text) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by)).clear();
        performWait(0);
        new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void clearAndType(By by, String text, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(by)).clear();
        performWait(0);
        new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.elementToBeClickable(by)).sendKeys(text);
    }

    public void selectByVisibleText(WebElement e, String visibleText) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(e)));
        performWait(0);
        s.selectByVisibleText(visibleText);
    }



    public void selectByVisibleText(By by, String visibleText) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(by)));
        performWait(0);
        s.selectByVisibleText(visibleText);
    }



    public void selectByValue(WebElement e, String value) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(e)));
        performWait(0);
        s.selectByValue(value);
    }



    public void selectByValue(By by, String value) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(by)));
        performWait(0);
        s.selectByValue(value);
    }



    public void selectByIndex(WebElement e, int index) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(e)));
        performWait(0);
        s.selectByIndex(index);
    }



    public void selectByIndex(By by, int index) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(by)));
        performWait(0);
        s.selectByIndex(index);
    }



    public void selectByVisibleText(WebElement e, String visibleText, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(e), customTimeOut));
        performWait(0);
        s.selectByVisibleText(visibleText);
    }



    public void selectByVisibleText(By by, String visibleText, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(by), customTimeOut));
        performWait(0);
        s.selectByVisibleText(visibleText);
    }



    public void selectByValue(WebElement e, String value, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(e), customTimeOut));
        performWait(0);
        s.selectByValue(value);
    }



    public void selectByValue(By by, String value, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(by), customTimeOut));
        performWait(0);
        s.selectByValue(value);
    }



    public void selectByIndex(WebElement e, int index, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(e), customTimeOut));
        performWait(0);
        s.selectByIndex(index);
    }



    public void selectByIndex(By by, int index, int customTimeOut) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(by), customTimeOut));
        performWait(0);
        s.selectByIndex(index);
    }

    public WebElement getSelectedOption(WebElement e) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(e)));
        performWait(0);
        return s.getFirstSelectedOption();
    }

    public WebElement getSelectedOption(By by) throws InterruptedException {
        performWait(throttle);
        Select s = new Select(waitUntil(ExpectedConditions.elementToBeClickable(by)));
        performWait(0);
        return s.getFirstSelectedOption();
    }

    /**
     * Clicks if element is clickable, doesn't fail if not.
     * @param e
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClick(WebElement e) throws InterruptedException {
        try{
            click(e, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clicks if element is clickable, doesn't fail if not.
     * @param e
     * @param customTimeOut
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClick(WebElement e, int customTimeOut) throws InterruptedException {
        try{
            click(e, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clicks if element is clickable, doesn't fail if not.
     * @param by
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClick(By by) throws InterruptedException {
        try{
            click(by, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clicks if element is clickable, doesn't fail if not.
     * @param by
     * @param customTimeOut
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClick(By by, int customTimeOut) throws InterruptedException {
        try{
            click(by, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clears if element is clickable, doesn't fail if not.
     * @param by
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClear(By by) throws InterruptedException {
        try{
            clear(by, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clears if element is clickable, doesn't fail if not.
     * @param by
     * @param customTimeOut
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClear(By by, int customTimeOut) throws InterruptedException {
        try{
            clear(by, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clears if element is clickable, doesn't fail if not.
     * @param e
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClear(WebElement e) throws InterruptedException {
        try{
            clear(e);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clears if element is clickable, doesn't fail if not.
     * @param e
     * @param customTimeOut
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClear(WebElement e, int customTimeOut) throws InterruptedException {
        try{
            clear(e, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Types if element is clickable, doesn't fail if not.
     * @param e
     * @param text
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryType(WebElement e, String text) throws InterruptedException {
        try{
            type(e, text, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Types if element is clickable, doesn't fail if not.
     * @param e
     * @param text
     * @param customTimeOut
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryType(WebElement e, String text, int customTimeOut) throws InterruptedException {
        try{
            type(e, text, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Types if element is clickable, doesn't fail if not.
     * @param by
     * @param text
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryType(By by, String text) throws InterruptedException {
        try{
            type(by, text, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Types if element is clickable, doesn't fail if not.
     * @param by
     * @param text
     * @param customTimeOut
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryType(By by, String text, int customTimeOut) throws InterruptedException {
        try{
            type(by, text, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clears and types if element is clickable, doesn't fail if not.
     * @param e
     * @param text
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClearAndType(WebElement e, String text) throws InterruptedException {
        try{
            clear(e, tryTimeoutInSeconds);
            type(e, text, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clears and types if element is clickable, doesn't fail if not.
     * @param e
     * @param text
     * @param customTimeOut
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClearAndType(WebElement e, String text, int customTimeOut) throws InterruptedException {
        try{
            clear(e, customTimeOut);
            type(e, text, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clears and types if element is clickable, doesn't fail if not.
     * @param by
     * @param text
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClearAndType(By by, String text) throws InterruptedException {
        try{
            clear(by, tryTimeoutInSeconds);
            type(by, text, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Clears and types if element is clickable, doesn't fail if not.
     * @param by
     * @param text
     * @param customTimeOut
     * @return boolean
     * @throws InterruptedException
     */
    public boolean tryClearAndType(By by, String text, int customTimeOut) throws InterruptedException {
        try{
            clear(by, customTimeOut);
            type(by, text, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }

    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param e
     * @param visibleText
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByVisibleText(WebElement e, String visibleText) throws InterruptedException {
        try{
            selectByVisibleText(e, visibleText, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param by
     * @param visibleText
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByVisibleText(By by, String visibleText) throws InterruptedException {
        try{
            selectByVisibleText(by, visibleText, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param e
     * @param visibleText
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByVisibleText(WebElement e, String visibleText, int customTimeOut) throws InterruptedException {
        try{
            selectByVisibleText(e, visibleText, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param by
     * @param visibleText
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByVisibleText(By by, String visibleText, int customTimeOut) throws InterruptedException {
        try{
            selectByVisibleText(by, visibleText, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }




    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param e
     * @param value
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByValue(WebElement e, String value) throws InterruptedException {
        try{
            selectByValue(e, value, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param by
     * @param value
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByValue(By by, String value) throws InterruptedException {
        try{
            selectByValue(by, value, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param e
     * @param value
     * @param customTimeOut
     * @return
     * @throws InterruptedException
     */
    public boolean trySelectByValue(WebElement e, String value, int customTimeOut) throws InterruptedException {
        try{
            selectByValue(e, value, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param by
     * @param value
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByValue(By by, String value, int customTimeOut) throws InterruptedException {
        try{
            selectByValue(by, value, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }




    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param e
     * @param index
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByIndex(WebElement e, int index) throws InterruptedException {
        try{
            selectByIndex(e, index, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param by
     * @param index
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByIndex(By by, int index) throws InterruptedException {
        try{
            selectByIndex(by, index, tryTimeoutInSeconds);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param e
     * @param index
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByIndex(WebElement e, int index, int customTimeOut) throws InterruptedException {
        try{
            selectByIndex(e, index, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }



    /**
     * Chooses an option if select is visible.  Doesn't fail if not.
     * @param by
     * @param index
     * @return boolean
     * @throws InterruptedException
     */
    public boolean trySelectByIndex(By by, int index, int customTimeOut) throws InterruptedException {
        try{
            selectByIndex(by, index, customTimeOut);
            return true;
        } catch(Exception x) {
            return false;
        }
    }


    public String getText(WebElement e) {
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(e)).getText();
    }

    public String getText(WebElement e, int customTimeOut) {
        performWait(0);
        return new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.visibilityOf(e)).getText();
    }

    public String getText(By by) {
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by))
                .getText();
    }

    public String getText(By by, int customTimeOut) {
        performWait(0);
        return new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.visibilityOfElementLocated(by))
                .getText();
    }

    public void handleAlert() {
        performWait(0);
        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    public boolean tryHandleAlert() {
        try{
            performWait(0);
            WebDriverWait wait = new WebDriverWait(driver, 4);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        }catch(Exception e) {
            return false;
        }
    }

    public boolean tryHandleAlert(int timeOut) {
        try{
            performWait(0);
            WebDriverWait wait = new WebDriverWait(driver, timeOut);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.accept();
            return true;
        }catch(Exception e) {
            return false;
        }
    }


    public String getAlertTextAndAccept(int customTimeout) {
        performWait(0);
        WebDriverWait wait = new WebDriverWait(driver, customTimeout);
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();
        return alertText;
    }

    public boolean retryingFindClick(By by) throws InterruptedException {
        boolean result = false;
        int attempts = 0;
        while (attempts < 2) {
            try {
                performWait(throttle);
                driver.findElement(by).click();
                result = true;
                break;
            } catch (StaleElementReferenceException e) {
            }
            attempts++;
        }
        return result;
    }

    public String getAttribute(By by, String attributeName) {
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOfElementLocated(by)).getAttribute(attributeName);
    }

    public String getAttribute(By by, String attributeName, int customTimeOut) {
        performWait(0);
        return new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.visibilityOfElementLocated(by)).getAttribute(attributeName);
    }

    public String getAttribute(WebElement e, String attributeName) {
        performWait(0);
        return new WebDriverWait(driver, timeOutInSeconds).until(ExpectedConditions.visibilityOf(e)).getAttribute(attributeName);
    }

    public String getAttribute(WebElement e, String attributeName, int customTimeOut) {
        performWait(0);
        return new WebDriverWait(driver, customTimeOut).until(ExpectedConditions.visibilityOf(e)).getAttribute(attributeName);
    }

    public boolean isAttributePresent(WebElement e, String attributeName ) {
        boolean b = false;
        String value = getAttribute(e, attributeName);
        if(value != null){
            b = true;
        }

        return b;
    }

    public boolean isAttributePresent(WebElement e, String attributeName, int customTimeOut ) {
        boolean b = false;
        String value = getAttribute(e, attributeName, customTimeOut);
        if(value != null){
            b = true;
        }

        return b;
    }

    public boolean isAttributePresent(By by, String attributeName) {
        boolean b = false;
        String value = getAttribute(by, attributeName);
        if(value != null){
            b = true;
        }

        return b;
    }

    public boolean isAttributePresent(By by, String attributeName, int customTimeOut ) {
        boolean b = false;
        String value = getAttribute(by, attributeName, customTimeOut);
        if(value != null){
            b = true;
        }

        return b;
    }

    /**
     * Gets creds from an untracked file.
     * @param filename
     * @param objectName
     * @return
     * @throws IOException
     */
    public String getCredentials(String filename, String objectName) throws IOException{

        String result;
        String textFromFile;
        //read the untracked lmsadminuser file to get credentials for the db
        FileReader fr = new FileReader("untrackedConfigs/" + filename);
        BufferedReader br = new BufferedReader(fr);
        textFromFile = br.readLine();
        br.close();
        JsonParserFactory factory = JsonParserFactory.getInstance();
        JSONParser parser = factory.newJsonParser();
        Map jsonData = parser.parseJson(textFromFile);
        result = (String)jsonData.get(objectName);
        return result;
    }
    /**
     * Waits for jQuery ajax calls to finish.
     * @throws InterruptedException
     */
    public void waitForAjaxCalls() throws InterruptedException {
        if((Boolean) ((JavascriptExecutor)driver).executeScript("return !!window.jQuery")){
            for (int i = 0; i < 100; i++) {
                if (activeAjaxCalls()) {
                    Thread.sleep(500);
                } else {
                    Thread.sleep(500);
                    break;
                }
            }
        }
    }
    /**
     * Waits for active ajax calls to finish and for the page to be in a ready state.
     * @return Returns true if both the page is in a ready state and there are no active ajax calls.
     */
    public boolean waitForJsToLoad() {
        WebDriverWait wait = new WebDriverWait(driver, 60);

        // wait for jQuery to load
        ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver driver) {
                try {
                    return ((long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
                } catch (Exception e) {
                    return true;
                }
            }
        };

        // wait for Javascript to load
        ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {

            @Override
            public Boolean apply(WebDriver arg0) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };

        return wait.until(jQueryLoad) && wait.until(jsLoad);
    }

    /**
     * Returns true if there are currently active ajax calls.
     * @return boolean
     */
    public boolean activeAjaxCalls(){
        long activeCalls = (long) ((JavascriptExecutor)driver).executeScript("return jQuery.active");
        if (activeCalls > 0 )
            return true;
        else return false;
    }

//	public boolean activeAjaxCalls(){
//		return (Boolean) ((JavascriptExecutor)driver).executeScript("return jQuery.active === 0");
//
//	}
    /**
     * Determines which wait to perform.
     * @param timeOutTime
     */
    public void performWait(int timeOutTime) {
        try {
            if (useAjaxWaits) {
                waitForJsToLoad();
            } else {
                Thread.sleep(timeOutTime);
            }
        } catch (Exception e) {

        }
    }

    public void tryDismissAlert(int timeout) {

        try {
            performWait(0);
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.alertIsPresent());
            Alert alert = driver.switchTo().alert();
            alert.dismiss();
        } catch (Exception e) {

        }

    }


}
