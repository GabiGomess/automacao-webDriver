package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class SelectPriceOptionPage extends BasePage {
    public SelectPriceOptionPage(WebDriver driver) { super(driver); }

    public SelectPriceOptionPage addPrice (String keys) {
        WebElement radioButton = driver.findElement(By.xpath("//div/table[@id='priceTable']/tfoot/tr/th[@class='group']/label/input[@id='" + keys + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(radioButton).click().build().perform();
        return this;
    }

    public SelectPriceOptionPage validateViewQuote() {
        driver.findElement(By.id("viewquote")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.switchTo().window("Quote");
        assertEquals(driver.getCurrentUrl(), "http://sampleapp.tricentis.com/101/tcpdf/pdfs/quote.php");
        driver.switchTo().window("Select Price Option");
        return this;
    }

    public SelectPriceOptionPage clickInNext() {
        driver.findElement(By.id("nextsendquote")).click();
        return this;
    }

    public SelectPriceOptionPage clickInPrev() {
        driver.findElement(By.id("preventerproductdata")).click();
        return this;
    }

    public SelectPriceOptionPage newPriceOption (String select) {
        return addPrice(select)
                .validateViewQuote()
                .clickInNext();
    }
}
