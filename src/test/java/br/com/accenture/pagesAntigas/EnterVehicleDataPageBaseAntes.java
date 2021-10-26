package br.com.accenture.pagesAntigas;
import br.com.accenture.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EnterVehicleDataPageBaseAntes extends PageBase {
    public EnterVehicleDataPageBaseAntes(WebDriver driver) { super(driver); }

    public EnterVehicleDataPageBaseAntes addMake (String keys) {
        WebElement field = driver.findElement(By.id("make"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addModel (String keys) {
        WebElement field = driver.findElement(By.id("model"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addCylinderCapacity (String keys) {
        driver.findElement(By.id("cylindercapacity")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addEnginePerformance (String keys) {
        driver.findElement(By.id("engineperformance")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addDateOfManufacture (String keys) {
        driver.findElement(By.id("dateofmanufacture")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addNumberOfSeats (String keys) {
        WebElement field = driver.findElement(By.id("numberofseats"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addRightHandDrive (String keys) {
        if (keys.equals("Yes")) {
            WebElement radio = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='righthanddriveyes']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(radio).click().build().perform();

        } else {
            WebElement radio = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='righthanddriveno']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(radio).click().build().perform();
        } return this;
    }

    public EnterVehicleDataPageBaseAntes addNumberOfSeatsMotorcycle (String keys) {
        WebElement field = driver.findElement(By.id("numberofseatsmotorcycle"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addFuelType (String keys) {
        WebElement field = driver.findElement(By.id("fuel"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addPayload (String keys) {
        driver.findElement(By.id("payload")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addTotalWeight (String keys) {
        driver.findElement(By.id("totalweight")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addListPrice (String keys) {
        driver.findElement(By.id("listprice")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addLicensePlateNumber (String keys) {
        driver.findElement(By.id("licenseplatenumber")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes addAnnualMileage (String keys) {
        driver.findElement(By.id("annualmileage")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBaseAntes clickInNext() {
        driver.findElement(By.id("nextenterinsurantdata")).click();
        return this;
    }

    public EnterVehicleDataPageBaseAntes newVehicle (String make, String model, String ccm, String engine, String data, String seats1, String hand, String seats2,
                                                     String fuel, String payload, String totalweight, String listprice, String licenseplatenumber, String annualmileage) {
        return addMake(make)
                .addModel(model)
                .addCylinderCapacity(ccm)
                .addEnginePerformance(engine)
                .addDateOfManufacture(data)
                .addNumberOfSeats(seats1)
                .addRightHandDrive(hand)
                .addNumberOfSeatsMotorcycle(seats2)
                .addFuelType(fuel)
                .addPayload(payload)
                .addTotalWeight(totalweight)
                .addListPrice(listprice)
                .addLicensePlateNumber(licenseplatenumber)
                .addAnnualMileage(annualmileage)
                .clickInNext();
    }
}
