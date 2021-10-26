package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class SelectPriceOptionPageBase extends PageBase {
    public SelectPriceOptionPageBase(WebDriver driver) { super(driver); }

    public SelectPriceOptionPageBase addPrice (String keys) {
        WebElement radioButton = driver.findElement(By.xpath("//div/table[@id='priceTable']/tfoot/tr/th[@class='group']/label/input[@id='" + keys + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(radioButton).click().build().perform();
        return this;
    }

    public SelectPriceOptionPageBase validateViewQuote() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.id("viewquote")).click();
        Thread.sleep(10000);
        return this;
    }

    public SelectPriceOptionPageBase clickInNext() {
        driver.findElement(By.id("nextsendquote")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public SelectPriceOptionPageBase clickInPrev() {
        driver.findElement(By.id("preventerproductdata")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return this;
    }

    public SelectPriceOptionPageBase newPriceOption (String select) throws InterruptedException {
        return addPrice(select)
                .validateViewQuote()
                .clickInNext();
    }
}
