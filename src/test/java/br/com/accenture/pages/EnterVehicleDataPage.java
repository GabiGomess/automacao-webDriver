package br.com.accenture.pages;
import br.com.accenture.bases.PageBase;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterVehicleDataPage extends PageBase {

    // Constructor
    public EnterVehicleDataPage(WebDriver driver) { super(driver); }

    // Mapping page
    By makeField = By.id("make");
    By modelField = By.id("model");
    By cylinderCapacityField = By.id("cylindercapacity");
    By enginePerformanceField = By.id("engineperformance");
    By dateOfManufactureField = By.id("dateofmanufacture");
    By numberOfSeatsField = By.id("numberofseats");
    By rightHandDriveYesField = By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='righthanddriveyes']");
    By rightHandDriveNoField = By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='righthanddriveno']");
    By numberOfSeatsMotorcycleField = By.id("numberofseatsmotorcycle");
    By fuelTypeField = By.id("fuel");
    By payloadField = By.id("payload");
    By totalWeightField = By.id("totalweight");
    By listPriceField = By.id("listprice");
    By licensePlateNumberField = By.id("licenseplatenumber");
    By annualMileageField = By.id("annualmileage");
    By nextButton = By.id("nextenterinsurantdata");
    By tabName = By.id("entervehicledata");
    By tabCounter = By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Vehicle Data']/span");

    // Actions
    public void preencherCampoMake (String key) { sendKeys(makeField, key); }
    public void preencherCampoModel (String key) { sendKeys(modelField, key); }
    public void preencherCampoCylinderCapacity (String key) { sendKeys(cylinderCapacityField, key); }
    public void preencherCampoEnginePerformance (String key) { sendKeys(enginePerformanceField, key); }
    public void preencherCampoDateOfManufacture (String key) { sendKeys(dateOfManufactureField, key); }
    public void preencherCampoNumberOfSeats (String key) { sendKeys(numberOfSeatsField, key); }
    public void preencherCampoRightHandDrive (@NotNull String key) {
        if (key.equalsIgnoreCase("Yes")) { radioBox(rightHandDriveYesField, key); }
        else { radioBox(rightHandDriveNoField, key); }
    }
    public void preencherCampoNumberOfSeatsMotorcycle (String key) { sendKeys(numberOfSeatsMotorcycleField, key); }
    public void preencherCampofuelType (String key) { sendKeys(fuelTypeField, key); }
    public void preencherCampoPayload (String key) { sendKeys(payloadField, key); }
    public void preencherCampoTotalWeight (String key) { sendKeys(totalWeightField, key); }
    public void preencherCampoListPrice (String key) { sendKeys(listPriceField, key); }
    public void preencherCampoLicensePlateNumber (String key) { sendKeys(licensePlateNumberField, key); }
    public void preencherCampoAnnualMileage (String key) { sendKeys(annualMileageField, key); }
    public void clicarNoBotaoNext() { click(nextButton); }
    public String recuperarUrl() { return getURL(); }
    public String recuperarTextoAba() { return getText(tabName); }
    public void clicarEmAba() { click(tabName); }
    public String recuperarContagemDeAba() { return getText(tabCounter); }
}
