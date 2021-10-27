package br.com.accenture.stepsdefinitions;

import br.com.accenture.pages.SelectPriceOptionPage;
import cucumber.api.java.en.And;
import org.hamcrest.Matchers;

import static br.com.accenture.utils.Constants.priceOptionValues;
import static org.junit.Assert.*;

public class PreencherFormularioSelectPriceOptionStepDefinitions {
    SelectPriceOptionPage priceOption;

    @And("^selecionar aba 'Select Price Option'$")
    public void selecionarAbaSelectPriceOption() {
        priceOption.clicarEmAba();
        assertTrue((priceOption.recuperarTextoAba()).contains("Select Price Option"));
        assertEquals(priceOption.recuperarContagemDeAba(), "1");
    }

    @And("^selecionar <price> com valor '(.*)'$")
    public void selecionarPriceComValorDefinido(String valor) {
        assertThat(priceOptionValues, Matchers.hasItemInArray(valor));
        priceOption.preencherCampoPrice(valor);
        assertEquals(priceOption.recuperarContagemDeAba(), "0");
    }

    @And("^clico no botao <View Quote> para analisar$")
    public void clicoNoBotaoViewQuoteParaAnalisar() throws InterruptedException {
        priceOption.clicarNoBotaoViewQuote();
        priceOption.alternarTab(1);
        assertEquals(priceOption.getDriver().getCurrentUrl(), "http://sampleapp.tricentis.com/101/tcpdf/pdfs/quote.php");
        assertTrue(priceOption.getDriver().getPageSource().contains("type=\"application/pdf\""));
        priceOption.closeTab();
    }

    @And("^clico no botao Next em aba 'Select Price Option'$")
    public void clicoNoBotaoNextEmAbaSelectPriceOption() {
        priceOption.clicarNoBotaoNext();

    }

}
