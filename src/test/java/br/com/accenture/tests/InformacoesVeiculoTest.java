//package br.com.accenture.tests;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Rule;
//import org.junit.Test;
//import org.junit.rules.TestName;
//import org.junit.runner.RunWith;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import br.com.accenture.pages.*;
//import br.com.accenture.utils.Web;
//import java.io.IOException;
//
//import static org.junit.Assert.*;
//
//@RunWith(DataDrivenTestRunner.class)
//public class InformacoesVeiculoTest {
//    private WebDriver driver;
//    private String counter = null;
//
//    @Rule
//    public TestName test = new TestName();
//
//    @Before
//    public void setUp() throws IOException {
//        driver = Web.createChrome();
//    }
//
//    @Test
//    public void preencherCorretamenteAbaEnterVehicleData() {
//        driver.findElement(By.id("entervehicledata")).click();
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Vehicle Data']/span")).getText();
//        assertEquals(counter, "12");
//
//        String newVehicleData = new EnterVehicleDataPageBaseAntes(driver)
//                .addMake("Opel")
//                .addModel("Moped")
//                .addCylinderCapacity("1999")
//                .addEnginePerformance("1999")
//                .addDateOfManufacture("10/10/2021")
//                .addNumberOfSeats("5")
//                .addRightHandDrive("Yes")
//                .addNumberOfSeatsMotorcycle("3")
//                .addFuelType("Gas")
//                .addPayload("15")
//                .addTotalWeight("101")
//                .addListPrice("500")
//                .addLicensePlateNumber("A123")
//                .addAnnualMileage("100")
//                .clickInNext()
//                .nextPage("Enter Insurant Data");
//
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Vehicle Data']/span")).getText();
//        assertEquals(counter, "0");
//        assertTrue(newVehicleData.contains("Enter Insurant Data"));
//    }
//
//    @Test
//    public void preencherCorretamenteAbaEnterInsurantData() throws Exception {
//        driver.findElement(By.id("enterinsurantdata")).click();
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Insurant Data']/span")).getText();
//        assertEquals(counter, "7");
//
//        String newInsurantData = new EnterInsurantDataPageBase(driver)
//                .addFirstName("Gabriela")
//                .addLastName("Gomes")
//                .addDateOfBirth("06/04/1993")
//                .addGender("Female")
//                .addStreetAddress("Linhares Street")
//                .addCountry("Brazil")
//                .addZipCode(31570030)
//                .addCity("Belo Horizonte")
//                .addOccupation("Public Official")
//                .addHobbies(new String[]{"speeding", "skydiving"})
//                .addWebsite("https://www.linkedin.com/in/gabriela-gomess/")
//                .addPicture()
//                .clickInNext()
//                .nextPage("Enter Product Data");
//
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Insurant Data']/span")).getText();
//        assertEquals(counter, "0");
//        assertTrue(newInsurantData.contains("Enter Product Data"));
//    }
//
//    @Test
//    public void preencherCorretamenteAbaEnterProductData() {
//        driver.findElement(By.id("enterproductdata")).click();
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Product Data']/span")).getText();
//        assertEquals(counter, "6");
//
////        preencherCorretamenteAbaEnterVehicleData();
////        preencherCorretamenteAbaEnterInsurantData();
//
//        String newProductData = new EnterProductDataPageBase(driver)
//                .addStartDate("01/01/2022")
//                .addInsuranceSum("20.000.000,00")
//                .addMeritRating("Malus 10")
//                .addDamageInsurance("Partial Coverage")
//                .addOptionalProducts(new String[]{"LegalDefenseInsurance"})
//                .addCourtesyCar("Yes")
//                .clickInNext()
//                .nextPage("Select Price Option");
//
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Product Data']/span")).getText();
//        assertEquals(counter, "0");
//        assertTrue(newProductData.contains("Select Price Option"));
//    }
//
//    @Test
//    public void preencherCorretamenteAbaSelectPriceOption() throws Exception {
////        preencherCorretamenteAbaEnterVehicleData();
////        preencherCorretamenteAbaEnterInsurantData();
////        preencherCorretamenteAbaEnterProductData();
//
//        driver.findElement(By.id("selectpriceoption")).click();
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Select Price Option']/span")).getText();
//        assertEquals(counter, "1");
//
//        String newSelectPrice = new SelectPriceOptionPageBase(driver)
//                .addPrice("selectplatinum")
////                .validateViewQuote()
//                .clickInNext()
//                .nextPage("Send Quote");
//
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Select Price Option']/span")).getText();
//        assertEquals(counter, "0");
//        assertTrue(newSelectPrice.contains("Send Quote"));
//
////        List<String> abas = new ArrayList<>(driver.getWindowHandles());
////        driver.switchTo().window(abas.get(1));
////        Thread.sleep(1000);
////        assertEquals(driver.getCurrentUrl(), "http://sampleapp.tricentis.com/101/tcpdf/pdfs/quote.php");
////        assertNotNull(driver.getPageSource());
////        assertTrue(driver.getPageSource().contains("type=\"application/pdf\""));
////        driver.switchTo().window(abas.get(0));
//
//    }
//
//    @Test
//    public void preencherCorretamenteAbaSendQuote() throws Exception {
//        preencherCorretamenteAbaEnterVehicleData();
//        preencherCorretamenteAbaEnterInsurantData();
//        preencherCorretamenteAbaEnterProductData();
//        preencherCorretamenteAbaSelectPriceOption();
//
//        driver.findElement(By.id("sendquote")).click();
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Send Quote']/span")).getText();
//        assertEquals(counter, "4");
//
//        String newQuote = new SendQuotePageBase(driver)
//                .addEmail("gabrielaofgomes@gmail.com")
//                .addPhone("31999999999")
//                .addUsername("gabsGo")
//                .addPassword("Gabi2010")
//                .addConfirmPassword("Gabi2010")
//                .addComments("Comentarios basicos para validar operacao")
//                .clickInSend()
//                .validatePopUp()
//                .clickInPopUpOk()
//                .nextPage("");
//
//        counter = driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Send Quote']/span")).getText();
//        assertEquals(counter, "0");
//
//        assertEquals(driver.findElement(By.id("password")).getText(), driver.findElement(By.id("confirmpassword")).getText());
//    }
//
//    @After
//    public void tearDown() { driver.quit(); }
//}
//
