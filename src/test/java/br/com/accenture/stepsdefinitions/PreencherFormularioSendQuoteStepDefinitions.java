package br.com.accenture.stepsdefinitions;

import br.com.accenture.pages.SendQuotePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import static org.junit.Assert.*;

public class PreencherFormularioSendQuoteStepDefinitions {
    SendQuotePage quote;
    String password;

    @And("^selecionar aba 'Send Quote'$")
    public void selecionarAbaSendQuote() {
        quote.clicarEmAba();
        assertTrue((quote.recuperarTextoAba()).contains("Send Quote"));
        assertEquals(quote.recuperarContagemDeAba(), "4");
    }

    @And("^inserir campo <E-Mail> com valor '(.*)'$")
    public void inserirCampoEMailComValorDefinido(String valor) {
        assertTrue((valor.contains(".com") || valor.contains(".org") || valor.contains(".br") || valor.contains("co") ||
                valor.contains(".edu") || valor.contains(".")) && valor.contains("@"));
        quote.preencherCampoEmail(valor);
    }

    @And("^inserir campo <Phone> com valor '(\\d+)'$")
    public void inserirCampoPhoneComValorDefinido(String valor) {
        assertTrue(valor.length() >= 8 && valor.length() <= 15);
        assertTrue(valor.matches("(\\d+)"));
        quote.preencherCampoPhone(valor);
    }

    @And("^inserir campo <Username> com valor '(.*)'$")
    public void inserirCampoUsernameComValorDefinido(String valor) {
        assertNotNull(valor);
        assertTrue(valor.length() >= 4 || valor.length() <= 32);
        assertTrue(valor.substring(0, 1).matches("^[A-Z]*$"));
        quote.preencherCampoUsername(valor);
    }

    @And("^inserir campo <Password> com valor '(.*)'$")
    public void inserirCampoPasswordComValorDefinido(String valor) {
        password = valor;
        assertNotNull(password);
        assertTrue(password.length() >= 6); // Tamanho maior que 6
        assertTrue(password.matches("^.*\\d.*$")); // Contem pelo menos um numero
        assertTrue(password.matches("^.*[A-Z].*$")); // Contem pelo menos uma letra maiuscula
        assertTrue(password.matches("^.*[a-z].*$")); // Contem pelo menos uma letra minuscula
        quote.preencherCampoPassword(password);
    }

    @And("^inserir campo <Confirm Password> com valor '(.*)'$")
    public void inserirCampoConfirmPasswordComValorDefinido(String valor) {
        assertNotNull(valor);
        assertEquals(valor, password);
        quote.preencherCampoConfirmPassword(password);
    }

    @And("^inserir campo <Comments> com valor '(.*)'$")
    public void inserirCampoCommentsComValorDefinido(String valor) {
        assertTrue(valor.length() <= 300);
        quote.preencherCampoComments(valor);
    }

    @And("^clico no botao Send$")
    public void clicoNoBotaoSend() {
        quote.clicarNoBotaoSend();
    }

    @Then("^deverá ser exibida mensagem 'Sending e-mail success!' em tela$")
    public void deveraSerExibidaMensagemSendingEMailSuccessEmTela() throws InterruptedException {
        assertEquals(quote.capturarTextoEmPopUp(), "Sending e-mail success!");
        quote.clicarEmBotaoOkPopUp();
    }
}
