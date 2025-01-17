package br.com.accenture.stepsdefinitions;

import br.com.accenture.pages.EnterVehicleDataPage;
import br.com.accenture.utils.Datas;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.hamcrest.Matchers;
import org.junit.After;

import static br.com.accenture.utils.Constants.*;
import static org.junit.Assert.*;

public class PreencherFormularioEnterVehicleDataStepDefinitions {

    EnterVehicleDataPage enterVehicle;

    @Given("^que estou na pagina inicial$")
    public void queEstouNaPaginaInicial() throws InterruptedException {
        enterVehicle.open();
        Thread.sleep(1000);
        assertEquals(enterVehicle.recuperarUrl(), baseURL);
    }

    @When("^selecionar aba 'Enter Vehicle Data'$")
    public void selecionarAbaEnterVehicleData() {
        enterVehicle.clicarEmAba();
        assertTrue((enterVehicle.recuperarTextoAba()).contains("Enter Vehicle Data"));
        assertEquals(enterVehicle.recuperarContagemDeAba(), "12");
    }

    @And("^selecionar campo <Make> com valor '(.*)'$")
    public void selecionarCampoMakeComValorDefinido(String valor) {
        assertNotNull(valor);
        assertThat(makeValues, Matchers.hasItemInArray(valor));
        enterVehicle.preencherCampoMake(valor);
    }

    @And("^selecionar campo <Model> com valor '(.*)'$")
    public void selecionarCampoModelComValorDefinido(String valor) {
        assertNotNull(valor);
        assertThat(modelValues, Matchers.hasItemInArray(valor));
        enterVehicle.preencherCampoModel(valor);
    }

    @And("^inserir campo <CylinderCapacity> com valor '(\\d+)'$")
    public void inserirCampoCylinderCapacityComValorDefinido(int valor) {
        assertTrue(valor >= 1 && valor <= 2000);
        enterVehicle.preencherCampoCylinderCapacity(String.valueOf(valor));
    }

    @And("^inserir campo <Engine Performance> com valor '(\\d+)'$")
    public void inserirCampoEnginePerformanceComValorDefinido(int valor) {
        assertTrue(valor >= 1 && valor <= 2000);
        enterVehicle.preencherCampoEnginePerformance(String.valueOf(valor));
    }

    @And("^inserir campo <Date of Manufacture> com valor '(.*)/(.*)/(.*)'$")
    public void inserirCampoDateOfManufactureComValorDefinido(String mm, String dd, String yyyy) {
        Datas datas = new Datas();
        String data = mm + "/" + dd + "/" + yyyy;
        assertTrue(datas.validador(data));
        assertTrue(datas.dataMenorQueHoje(data));
        enterVehicle.preencherCampoDateOfManufacture(data);
    }

    @And("^selecionar campo <Number of Seats> com valor '(\\d+)'$")
    public void selecionarCampoNumberOfSeatsComValorDefinido(int valor) {
        assertTrue(valor >= 1 && valor <= 9);
        enterVehicle.preencherCampoNumberOfSeats(String.valueOf(valor));
    }

    @And("^selecionar campo <Right Hand Drive> com valor '(.*)'$")
    public void selecionarCampoRightHandDriveComValorNoDefinido(String valor) {
        assertNotNull(valor);
        assertTrue((valor.equalsIgnoreCase("Yes")) || (valor.equalsIgnoreCase("No")));
        enterVehicle.preencherCampoRightHandDrive(valor);
    }

    @And("^selecionar campo <Number of Seats Motorcycle> com valor '(\\d+)'$")
    public void selecionarCampoNumberOfSeatsMotorcycleComValorDefinido(int valor) {
        assertTrue(valor >= 1 && valor <= 3);
        enterVehicle.preencherCampoNumberOfSeatsMotorcycle(String.valueOf(valor));
    }

    @And("^selecionar campo <Fuel Type> com valor '(.*)'$")
    public void selecionarCampoFuelTypeComValorDefinido(String valor) {
        assertNotNull(valor);
        assertThat(fuelTypeValues, Matchers.hasItemInArray(valor));
        enterVehicle.preencherCampofuelType(valor);
    }

    @And("^selecionar campo <Payload> com valor '(\\d+)'$")
    public void selecionarCampoPayloadComValorDefinido(int valor) {
        assertTrue(valor >= 1 && valor <= 1000);
        enterVehicle.preencherCampoPayload(String.valueOf(valor));
    }


    @And("^inserir campo <Total Weight> com valor '(\\d+)'$")
    public void inserirCampoTotalWeightComValorDefinido(int valor) {
        assertTrue(valor >= 100 && valor <= 50000);
        enterVehicle.preencherCampoTotalWeight(String.valueOf(valor));
    }

    @And("^inserir campo <List Price> com valor '(\\d+)'$")
    public void inserirCampoListPriceComValorDefinido(int valor) {
        assertTrue(valor >= 500 && valor <= 100000);
        enterVehicle.preencherCampoListPrice(String.valueOf(valor));
    }

    @And("^inserir campo <License Plate Number> com valor '(.*)'$")
    public void inserirCampoLicensePlateNumberComValorDefinido(String valor) {
        if (valor.isEmpty()) {
            enterVehicle.preencherCampoLicensePlateNumber(null);
        } else {
            enterVehicle.preencherCampoLicensePlateNumber(valor);
        }
    }

    @And("^inserir campo <Annual Mileage> com valor '(\\d+)'$")
    public void inserirCampoAnnualMileageComValorDefinido(int valor) {
        assertTrue(valor >= 100 && valor <= 100000);
        enterVehicle.preencherCampoAnnualMileage(String.valueOf(valor));
    }

    @And("^clico no botão <Next> em aba 'Enter Vehicle Data'$")
    public void clicoNoBotaoNextEmAbaEnterVehicleData() {
        assertEquals(enterVehicle.recuperarContagemDeAba(), "0");
        enterVehicle.clicarNoBotaoNext();
    }

    @After
    public void afterScenario() {
        enterVehicle.tearDown();
    }
}
