package br.com.accenture.bases;

import net.serenitybdd.core.pages.PageObject;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase extends PageObject {
    // Variaveis globais
    protected WebDriverWait wait = null;
    protected WebDriver driver = null;
    protected JavascriptExecutor javaScriptExecutor = null;
    protected long timeOutDefault;

    // Construtor
    public PageBase(WebDriver driver) {
        super(driver);
        this.driver = driver;
        timeOutDefault = getWaitForTimeout().toMillis();
        this.wait = new WebDriverWait(driver, timeOutDefault);
        javaScriptExecutor = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
    }

    // Custom Actions
    private void waitUntilPageReady(){
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= timeOutDefault){
            if(javaScriptExecutor.executeScript("return document.readyState").toString() == "complete");{
                timeOut.stop();
                break;
            }
        }
    }

    protected WebElement waitForElement(By locator){
        waitUntilPageReady();
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    protected void sendKeys(By locator, String text){
        waitForElement(locator).sendKeys(text);
    }

    protected void click(By locator){
        WebDriverException possibleWebDriverException = null;
        StopWatch timeOut = new StopWatch();
        timeOut.start();

        while (timeOut.getTime() <= timeOutDefault)
        {
            WebElement element = null;

            try
            {
                element = waitForElement(locator);
                element.click();
                timeOut.stop();
                return;
            }
            catch (StaleElementReferenceException e){
                continue;
            }
            catch(ElementClickInterceptedException e){
                continue;
            }
            catch (WebDriverException e){
                possibleWebDriverException = e;
                if (e.getMessage().contains("Other element would receive the click"))
                {
                    continue;
                }   throw e;
            }
        }

        try {
            throw new Exception(possibleWebDriverException);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    protected void comboBoxSelectByVisibleText(By locator, String text){
        Select comboBox = new Select(waitForElement(locator));
        comboBox.selectByVisibleText(text);
    }

    //Default actions
    public void refresh(){
        driver.navigate().refresh();
    }
    public void navigateTo(String url){
        driver.navigate().to(url);
    }
    public void openNewTab(){
        javaScriptExecutor.executeScript("window.open();");
    }
    public void closeTab(){ driver.close(); }
    public String getTitle(){ String title = driver.getTitle(); return title; }
    public String getURL(){   String url = driver.getCurrentUrl(); return url; }


//    public String nextPage(String elemento) {
//        return driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='" + elemento + "']")).getText();
//    }
}
