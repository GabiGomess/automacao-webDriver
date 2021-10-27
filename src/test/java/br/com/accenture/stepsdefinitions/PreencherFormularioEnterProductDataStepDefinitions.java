package br.com.accenture.stepsdefinitions;

import br.com.accenture.pages.EnterProductDataPage;
import cucumber.api.java.en.And;
import org.jetbrains.annotations.NotNull;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PreencherFormularioEnterProductDataStepDefinitions {

    EnterProductDataPage enterProduct;

    @And("^selecionar aba 'Enter Product Data'$")
    public void selecionarAbaEnterProductData() {
        enterProduct.clicarEmAba();
        assertTrue((enterProduct.recuperarTextoAba()).contains("Enter Product Data"));
        assertEquals(enterProduct.recuperarContagemDeAba(), "6");
    }

    @And("^inserir campo <Start Date> com valor '(.*)/(.*)/(.*)'$")
    public void inserirCampoStartDateComValor(@NotNull String valor) {


    }
}
