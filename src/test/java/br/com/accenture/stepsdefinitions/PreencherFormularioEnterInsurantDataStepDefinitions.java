package br.com.accenture.stepsdefinitions;

import br.com.accenture.pages.EnterInsurantDataPage;
import br.com.accenture.utils.Datas;
import cucumber.api.java.en.And;
import org.hamcrest.Matchers;
import org.junit.After;

import java.io.IOException;
import java.text.ParseException;

import static br.com.accenture.utils.Constants.*;
import static org.junit.Assert.*;

public class PreencherFormularioEnterInsurantDataStepDefinitions {

    EnterInsurantDataPage enterInsurant;

    @And("^selecionar aba 'Enter Insurant Data'$")
    public void selecionarAbaEnterInsurantData() {
        enterInsurant.clicarEmAba();
        assertTrue((enterInsurant.recuperarTextoAba()).contains("Enter Insurant Data"));
        assertEquals(enterInsurant.recuperarContagemDeAba(), "7");
    }

    @And("^inserir campo <First Name> com valor '(.*)'$")
    public void inserirCampoFirstNameComValorDefinido(String valor) {
        assertNotNull(valor);
        enterInsurant.preencherCampoFirstName(valor);
    }

    @And("^inserir campo <Last Name> com valor '(.*)'$")
    public void inserirCampoLastNameComValorDefinido(String valor) {
        assertNotNull(valor);
        enterInsurant.preencherCampoLastName(valor);
    }

    @And("^inserir campo <Date of Birth> com valor '(.*)/(.*)/(.*)'$")
    public void inserirCampoDateOfBirthComValorDefinido(String mm, String dd, String yyyy) throws ParseException {
        Datas datas = new Datas();
        String data = mm + "/" + dd + "/" + yyyy;
        assertTrue(datas.validador(data));
        assertTrue(datas.maioridadeValidador(data));
        enterInsurant.preencherCampoDateOfBirth(data);
    }

    @And("^selecionar campo <Gender> com valor '(.*)'$")
    public void selecionarCampoGenderComValorDefinido(String valor) {
        assertTrue((valor.equalsIgnoreCase("Female")) || (valor.equalsIgnoreCase("Male")) || (valor.isEmpty()));
        enterInsurant.preencherCampoGender(valor);
    }

    @And("^inserir campo <Street Address> com valor '(.*)'$")
    public void inserirCampoStreetAddressComValorDefinido(String valor) {
        enterInsurant.preencherCampoStreetAddress(valor);
    }

    @And("^selecionar campo <Country> com valor '(.*)'$")
    public void selecionarCampoCountryComValorDefinido(String valor) {
        assertNotNull(valor);
        assertThat(countryValues, Matchers.hasItemInArray(valor));
        enterInsurant.preencherCampoCountry(valor);
    }

    @And("^inserir campo <Zip Code> com valor '(\\d+)'$")
    public void inserirCampoZipCodeComValorDefinido(int valor) {
        int tamanho = String.valueOf(valor).length();
        assertTrue(tamanho >= 4 && tamanho <= 8);
        enterInsurant.preencherCampoZipCodeField(String.valueOf(valor));
    }

    @And("^inserir campo <City> com valor '(.*)'$")
    public void inserirCampoCityComValorDefinido(String valor) {
        if (valor.isEmpty()) {
            enterInsurant.preencherCampoCityField(null);
        } else {
            enterInsurant.preencherCampoCityField(valor);
        }
    }

    @And("^selecionar campo <Occupation> com valor '(.*)'$")
    public void selecionarCampoOccupationComValorDefinido(String valor) {
        assertNotNull(valor);
        assertThat(occupationValues, Matchers.hasItemInArray(valor));
        enterInsurant.preencherCampoOccupationField(valor);
    }

    @And("^selecionar campo <Hobbies> com valor '(.*)'$")
    public void selecionarCampoHobbiesComValorDefinido(String valor) {
        String[] hobbies = valor.toLowerCase().split(",");
        assertTrue(hobbies.length >= 1);
        for (String hobby : hobbies) {
            assertThat(hobbiesValues, Matchers.hasItemInArray(hobby));
        }
        enterInsurant.preencherCampoHobbies(hobbies);
    }

    @And("^inserir campo <Website> com valor '(.*)'$")
    public void inserirCampoWebsiteComValorDefinido(String valor) {
        assertTrue(valor.contains(".com") || valor.contains(".org") || valor.contains(".br") || valor.contains("co") ||
                (valor.contains(".edu") || valor.contains(".")));
        enterInsurant.preencherCampoWebsite(valor);
    }

    @And("^inserir campo <Picture>$")
    public void inserirCampoPicture() throws IOException {
        enterInsurant.preencherCampoPicture();
    }

    @And("^clico no botão <Next> em aba 'Enter Insurant Data'$")
    public void clicoNoBotaoNextEmAbaEnterInsurantData() {
        assertEquals(enterInsurant.recuperarContagemDeAba(), "0");
        enterInsurant.clicarNoBotaoNext();
    }

    @After
    public void afterScenario() {
        enterInsurant.tearDown();
    }
}

