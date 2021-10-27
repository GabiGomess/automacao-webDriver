package br.com.accenture.pages;

import br.com.accenture.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SelectPriceOptionPage extends PageBase {

    // Constructor
    public SelectPriceOptionPage(WebDriver driver) {
        super(driver);
    }

    // Mapping page
    By viewQuoteButton = By.id("viewquote");
    By nextButton = By.id("nextsendquote");
    By prevButton = By.id("preventerproductdata");
    By tabName = By.id("selectpriceoption");
    By tabCounter = By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@id='selectpriceoption']/span");

    // Actions
    public void preencherCampoPrice(String keys) {
        WebElement radioButton = driver.findElement(By.xpath("//div/table[@id='priceTable']/tfoot/tr/th[@class='group']/label/input[@value='" + keys + "']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(radioButton).click().build().perform();
    }

    public void clicarNoBotaoViewQuote() throws InterruptedException {
        Thread.sleep(3000);
        click(viewQuoteButton);
        Thread.sleep(10000);
    }

    public void clicarNoBotaoNext() {
        click(nextButton);
    }

    public void clicarNoBotaoPrev() {
        click(prevButton);
    }

    public String recuperarTextoAba() {
        return getText(tabName);
    }

    public void clicarEmAba() {
        click(tabName);
    }

    public String recuperarContagemDeAba() {
        return getText(tabCounter);
    }
}
