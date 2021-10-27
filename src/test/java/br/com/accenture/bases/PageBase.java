package br.com.accenture.bases;

import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class PageBase extends PageObject {
    //Variaveis globlais
    protected WebDriverWait wait = null;
    protected WebDriver driver = null;
    protected JavascriptExecutor javaScriptExecutor = null;
    protected long timeOutDefault;

    //Construtor
    public PageBase(WebDriver driver) {
        super(driver);
        this.driver = driver;
        timeOutDefault = getWaitForTimeout().toMillis();
        this.wait = new WebDriverWait(driver, timeOutDefault);
        javaScriptExecutor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    // Custom Actions
    private void waitUntilPageReady() {
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= timeOutDefault) {
            if (javaScriptExecutor.executeScript("return document.readyState").toString() == "complete") ;
            {
                timeOut.stop();
                break;
            }
        }
    }

    protected WebElement waitForElement(By locator) {
        waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected void sendKeys(By locator, String text) {
        waitForElement(locator).sendKeys(text);
    }

    protected void radioBox(By locator, String text) {
        WebElement radio = waitForElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(radio).click().build().perform();
    }

    protected void click(By locator) {
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= timeOutDefault) {
            WebElement element = null;

            try {
                element = waitForElement(locator);
                element.click();
                timeOut.stop();
                return;
            } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
                continue;
            } catch (WebDriverException e) {
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click")) {
                    continue;
                }
                throw e;
            }
        }
        try {
            throw new Exception(possibleWebDriverException);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Default actions
    protected String getText(By locator) {
        String text = waitForElement(locator).getText();
        return text;
    }

    public void closeTab() {
        driver.close();
    }

    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

    public String getURL() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void tearDown() {
        driver.quit();
    }

    public void alternarTab(int index) throws InterruptedException {
        Thread.sleep(1000);
        List<String> abas = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(abas.get(index));
        Thread.sleep(1000);
    }
}