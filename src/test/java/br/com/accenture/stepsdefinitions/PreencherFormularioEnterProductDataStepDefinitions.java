package br.com.accenture.stepsdefinitions;

import br.com.accenture.pages.EnterProductDataPage;
import br.com.accenture.utils.Datas;
import cucumber.api.java.en.And;
import org.hamcrest.Matchers;

import java.text.ParseException;

import static br.com.accenture.utils.Constants.*;
import static org.junit.Assert.*;

public class PreencherFormularioEnterProductDataStepDefinitions {

    EnterProductDataPage enterProduct;

    @And("^selecionar aba 'Enter Product Data'$")
    public void selecionarAbaEnterProductData() {
        enterProduct.clicarEmAba();
        assertTrue((enterProduct.recuperarTextoAba()).contains("Enter Product Data"));
        assertEquals(enterProduct.recuperarContagemDeAba(), "6");
    }

    @And("^inserir campo <Start Date> com valor '(.*)/(.*)/(.*)'$")
    public void inserirCampoStartDateComValorDefinido(String mm, String dd, String yyyy) throws ParseException {
        Datas datas = new Datas();
        String data = mm + "/" + dd + "/" + yyyy;
        assertTrue(datas.validador(data));
        assertTrue(datas.validarDataDepois(data));
        enterProduct.preencherCampoStartDate(data);
    }

    @And("^selecionar campo <Insurance Sum> com valor '(.*)'$")
    public void selecionarCampoInsuranceSumComValorDefinido(String valor) {
        assertNotNull(valor);
        assertThat(insuranceSumValues, Matchers.hasItemInArray(valor.replace(".", "").trim()));
        enterProduct.preencherCampoInsuranceSum(valor);
    }

    @And("^selecionar campo <Merit Rating> com valor '(.*)'$")
    public void selecionarCampoMeritRatingComValorDefinido(String valor) {
        assertNotNull(valor);
        assertThat(meritRatingValues, Matchers.hasItemInArray(valor));
        enterProduct.preencherCampoMeritRating(valor);
    }

    @And("^selecionar campo <Damage Insurance> com valor '(.*)'$")
    public void selecionarCampoDamageInsuranceComValorDefinido(String valor) {
        assertNotNull(valor);
        assertThat(damageInsurance, Matchers.hasItemInArray(valor));
        enterProduct.preencherCampoDamageInsurance(valor);
    }

    @And("^selecionar campo <Optional Products> com valor '(.*)'$")
    public void selecionarCampoOptionalProductsComValorDefinido(String valor) {
        String[] products = valor.replace(" ", "").split(",");
        assertTrue(products.length >= 1);
        for (String product : products) {
            assertThat(optionalProductsValues, Matchers.hasItemInArray(product));
        }
        enterProduct.preencherCampoOptionalProducts(products);
    }

    @And("^selecionar campo <Courtesy Car> com valor '(.*)'$")
    public void selecionarCampoCourtesyCarComValorDefinido(String valor) {
        assertNotNull(valor);
        assertTrue(valor.equalsIgnoreCase("Yes") || valor.equalsIgnoreCase("No"));
        enterProduct.preencherCampoCourtesyCar(valor);
    }

    @And("^clico no botao Next em aba 'Enter Product Data'$")
    public void clicoNoBotaoNextEmAbaEnterProductData() {
        assertEquals(enterProduct.recuperarContagemDeAba(), "0");
        enterProduct.clicarNoBotaoNext();
    }
}
