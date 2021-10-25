package tests;
import org.easetech.easytest.runner.DataDrivenTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.EnterInsurantDataPage;
import pages.EnterProductDataPage;
import pages.EnterVehicleDataPage;
import pages.SelectPriceOptionPage;
import utils.Web;
import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(DataDrivenTestRunner.class)
public class InformacoesVeiculoTest {
    private WebDriver driver;
    private String counter = null;

    @Rule
    public TestName test = new TestName();

    @Before
    public void setUp() throws IOException {
        driver = Web.createChrome();
    }

    @Test
    public void preencherCorretamenteAbaEnterVehicleData() {
        driver.findElement(By.id("entervehicledata")).click();
        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Vehicle Data']/span")).getText();
        assertEquals(counter, "12");

        String newVehicleData = new EnterVehicleDataPage(driver)
                .addMake("Opel")
                .addModel("Moped")
                .addCylinderCapacity("1999")
                .addEnginePerformance("1999")
                .addDateOfManufacture("10/10/2021")
                .addNumberOfSeats("5")
                .addRightHandDrive("Yes")
                .addNumberOfSeatsMotorcycle("3")
                .addFuelType("Gas")
                .addPayload("15")
                .addTotalWeight("101")
                .addListPrice("500")
                .addLicensePlateNumber("A123")
                .addAnnualMileage("100")
                .clickInNext()
                .capturarTextoToast("Enter Insurant Data");

        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Vehicle Data']/span")).getText();
        assertEquals(counter, "0");
        assertTrue(newVehicleData.contains("Enter Insurant Data"));
    }

    @Test
    public void preencherCorretamenteAbaEnterInsurantData() throws Exception {
        driver.findElement(By.id("enterinsurantdata")).click();
        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Insurant Data']/span")).getText();
        assertEquals(counter, "7");

        String newInsurantData = new EnterInsurantDataPage(driver)
                .addFirstName("Gabriela")
                .addLastName("Gomes")
                .addDateOfBirth("06/04/1993")
                .addGender("Female")
                .addStreetAddress("Linhares Street")
                .addCountry("Brazil")
                .addZipCode(31570030)
                .addCity("Belo Horizonte")
                .addOccupation("Public Official")
                .addHobbies(new String[]{"speeding", "skydiving"})
                .addWebsite("https://www.linkedin.com/in/gabriela-gomess/")
                .addPicture()
                .clickInNext()
                .capturarTextoToast("Enter Product Data");

        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Insurant Data']/span")).getText();
        assertEquals(counter, "0");
        assertTrue(newInsurantData.contains("Enter Product Data"));
    }

    @Test
    public void preencherCorretamenteAbaEnterProductData() {
        driver.findElement(By.id("enterproductdata")).click();
        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Product Data']/span")).getText();
        assertEquals(counter, "6");

//        preencherCorretamenteAbaEnterVehicleData();
//        preencherCorretamenteAbaEnterInsurantData();

        String newProductData = new EnterProductDataPage(driver)
                .addStartDate("01/01/2022")
                .addInsuranceSum("20.000.000,00")
                .addMeritRating("Malus 10")
                .addDamageInsurance("Partial Coverage")
                .addOptionalProducts(new String[]{"LegalDefenseInsurance"})
                .addCourtesyCar("Yes")
                .clickInNext()
                .capturarTextoToast("Select Price Option");

        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Product Data']/span")).getText();
        assertEquals(counter, "0");
        assertTrue(newProductData.contains("Select Price Option"));
    }

    @Test
    public void preencherCorretamenteAbaSelectPriceOption() throws Exception {
        preencherCorretamenteAbaEnterVehicleData();
        preencherCorretamenteAbaEnterInsurantData();
        preencherCorretamenteAbaEnterProductData();

        driver.findElement(By.id("selectpriceoption")).click();
        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Select Price Option']/span")).getText();
        assertEquals(counter, "1");

        String newSelectPrice = new SelectPriceOptionPage(driver)
                .addPrice("selectplatinum")
                .validateViewQuote()
                .clickInNext()
                .capturarTextoToast("Send Quote");

        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Select Price Option']/span")).getText();
        assertEquals(counter, "0");
        assertTrue(newSelectPrice.contains("Send Quote"));
    }

    @After
    public void tearDown() { driver.quit(); }
}

