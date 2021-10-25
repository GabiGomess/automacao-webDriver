package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EnterProductDataPage extends BasePage {
    public EnterProductDataPage(WebDriver driver) { super(driver); }

    public EnterProductDataPage addStartDate (String keys) {
        driver.findElement(By.id("startdate")).sendKeys(keys);
        return this;
    }

    public EnterProductDataPage addInsuranceSum (String keys) {
        WebElement field = driver.findElement(By.id("insurancesum"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterProductDataPage addMeritRating (String keys) {
        WebElement field = driver.findElement(By.id("meritrating"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterProductDataPage addDamageInsurance (String keys) {
        WebElement field = driver.findElement(By.id("damageinsurance"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterProductDataPage addOptionalProducts (String[] keys) {
        for (String key : keys) {
            WebElement check = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='" + key + "']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(check).click().build().perform();
        }
        return this;
    }

    public EnterProductDataPage addCourtesyCar (String keys) {
        WebElement field = driver.findElement(By.id("courtesycar"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterProductDataPage clickInNext() {
        driver.findElement(By.id("nextselectpriceoption")).click();
        return this;
    }

    public EnterProductDataPage clickInPrev() {
        driver.findElement(By.id("preventerinsurancedata")).click();
        return this;
    }

    public EnterProductDataPage newProduct (String startDate, String insurancesum, String meritrating, String damageinsurance,
                                            String[] optionalProducts, String courtesycar) {
        return addStartDate(startDate)
                .addInsuranceSum(insurancesum)
                .addMeritRating(meritrating)
                .addDamageInsurance(damageinsurance)
                .addOptionalProducts(optionalProducts)
                .addCourtesyCar(courtesycar)
                .clickInNext();
    }
}
