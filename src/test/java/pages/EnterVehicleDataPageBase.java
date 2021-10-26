package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class EnterVehicleDataPageBase extends PageBase {
    public EnterVehicleDataPageBase(WebDriver driver) { super(driver); }

    public EnterVehicleDataPageBase addMake (String keys) {
        WebElement field = driver.findElement(By.id("make"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBase addModel (String keys) {
        WebElement field = driver.findElement(By.id("model"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBase addCylinderCapacity (String keys) {
        driver.findElement(By.id("cylindercapacity")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBase addEnginePerformance (String keys) {
        driver.findElement(By.id("engineperformance")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBase addDateOfManufacture (String keys) {
        driver.findElement(By.id("dateofmanufacture")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBase addNumberOfSeats (String keys) {
        WebElement field = driver.findElement(By.id("numberofseats"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBase addRightHandDrive (String keys) {
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

    public EnterVehicleDataPageBase addNumberOfSeatsMotorcycle (String keys) {
        WebElement field = driver.findElement(By.id("numberofseatsmotorcycle"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBase addFuelType (String keys) {
        WebElement field = driver.findElement(By.id("fuel"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterVehicleDataPageBase addPayload (String keys) {
        driver.findElement(By.id("payload")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBase addTotalWeight (String keys) {
        driver.findElement(By.id("totalweight")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBase addListPrice (String keys) {
        driver.findElement(By.id("listprice")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBase addLicensePlateNumber (String keys) {
        driver.findElement(By.id("licenseplatenumber")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBase addAnnualMileage (String keys) {
        driver.findElement(By.id("annualmileage")).sendKeys(keys);
        return this;
    }

    public EnterVehicleDataPageBase clickInNext() {
        driver.findElement(By.id("nextenterinsurantdata")).click();
        return this;
    }

    public EnterVehicleDataPageBase newVehicle (String make, String model, String ccm, String engine, String data, String seats1, String hand, String seats2,
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