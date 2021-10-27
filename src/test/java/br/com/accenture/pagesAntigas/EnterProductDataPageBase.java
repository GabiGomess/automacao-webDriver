//package br.com.accenture.pagesAntigas;
//import br.com.accenture.bases.PageBase;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.Select;
//
//public class EnterProductDataPageBase extends PageBase {
//    public EnterProductDataPageBase(WebDriver driver) { super(driver); }
//
//    public EnterProductDataPageBase addStartDate (String keys) {
//        driver.findElement(By.id("startdate")).sendKeys(keys);
//        return this;
//    }
//
//    public EnterProductDataPageBase addInsuranceSum (String keys) {
//        WebElement field = driver.findElement(By.id("insurancesum"));
//        new Select(field).selectByVisibleText(keys);
//        return this;
//    }
//
//    public EnterProductDataPageBase addMeritRating (String keys) {
//        WebElement field = driver.findElement(By.id("meritrating"));
//        new Select(field).selectByVisibleText(keys);
//        return this;
//    }
//
//    public EnterProductDataPageBase addDamageInsurance (String keys) {
//        WebElement field = driver.findElement(By.id("damageinsurance"));
//        new Select(field).selectByVisibleText(keys);
//        return this;
//    }
//
//    public EnterProductDataPageBase addOptionalProducts (String[] keys) {
//        for (String key : keys) {
//            WebElement check = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='" + key + "']"));
//            Actions actions = new Actions(driver);
//            actions.moveToElement(check).click().build().perform();
//        }
//        return this;
//    }
//
//    public EnterProductDataPageBase addCourtesyCar (String keys) {
//        WebElement field = driver.findElement(By.id("courtesycar"));
//        new Select(field).selectByVisibleText(keys);
//        return this;
//    }
//
//    public EnterProductDataPageBase clickInNext() {
//        driver.findElement(By.id("nextselectpriceoption")).click();
//        return this;
//    }
//
//    public EnterProductDataPageBase clickInPrev() {
//        driver.findElement(By.id("preventerinsurancedata")).click();
//        return this;
//    }
//
//    public EnterProductDataPageBase newProduct (String startDate, String insurancesum, String meritrating, String damageinsurance,
//                                                String[] optionalProducts, String courtesycar) {
//        return addStartDate(startDate)
//                .addInsuranceSum(insurancesum)
//                .addMeritRating(meritrating)
//                .addDamageInsurance(damageinsurance)
//                .addOptionalProducts(optionalProducts)
//                .addCourtesyCar(courtesycar)
//                .clickInNext();
//    }
//}
