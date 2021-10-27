package br.com.accenture.pages;
import br.com.accenture.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class EnterProductDataPage extends PageBase {

    // Constructor
    public EnterProductDataPage(WebDriver driver) { super(driver); }

    // Mapping page
    By startDateField = By.id("startdate");
    By insuranceSumField = By.id("insurancesum");
    By meritRatingField = By.id("meritrating");
    By damageInsuranceField = By.id("damageinsurance");
    By courtesyCarField = By.id("courtesycar");
    By nextButton = By.id("nextselectpriceoption");
    By prevButton = By.id("preventerinsurancedata");
    By tabName = By.id("enterproductdata");
    By tabCounter = By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Product Data']/span");

    // Actions
    public void preencherCampoStartDate (String key) { sendKeys(startDateField, key); }
    public void preencherCampoInsuranceSum (String key) { sendKeys(insuranceSumField, key); }
    public void preencherCampoMeritRating (String key) { sendKeys(meritRatingField, key); }
    public void preencherCampoDamageInsurance (String key) { sendKeys(damageInsuranceField, key) ;}
    public void preencherCampoOptionalProducts (String[] keys) {
        for (String key : keys) {
            WebElement check = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='" + key + "']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(check).click().build().perform();
        }
    }
    public void preencherCampoCourtesyCar (String key) { sendKeys(courtesyCarField, key) ;}
    public void clicarNoBotaoNext() { click(nextButton); }
    public void clicarNoBotaoPrev() { click(prevButton); }
    public String recuperarTextoAba() { return getText(tabName); }
    public void clicarEmAba() { click(tabName); }
    public String recuperarContagemDeAba() { return getText(tabCounter); }
}
