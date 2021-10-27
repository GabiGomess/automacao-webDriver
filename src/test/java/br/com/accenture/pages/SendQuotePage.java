package br.com.accenture.pages;

import br.com.accenture.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendQuotePage extends PageBase {

    // Constructor
    public SendQuotePage(WebDriver driver) {
        super(driver);
    }

    // Mapping page
    By emailField = By.id("email");
    By phoneField = By.id("phone");
    By usernameField = By.id("username");
    By passwordField = By.id("password");
    By confirmPasswordField = By.id("confirmpassword");
    By commentsField = By.id("Comments");
    By sendButton = By.id("sendemail");
    By prevButton = By.id("prevselectpriceoption");
    By popUpText = By.xpath("//div[@class='sweet-alert showSweetAlert visible']/h2");
    By okPopUpButton = By.xpath("//div[@class='sa-confirm-button-container']/button[@class='confirm']");
    By tabName = By.id("sendquote");
    By tabCounter = By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Send Quote']/span");

    // Actions
    public void preencherCampoEmail(String key) {
        sendKeys(emailField, key);
    }

    public void preencherCampoPhone(String key) {
        sendKeys(phoneField, key);
    }

    public void preencherCampoUsername(String key) {
        sendKeys(usernameField, key);
    }

    public void preencherCampoPassword(String key) {
        sendKeys(passwordField, key);
    }

    public void preencherCampoConfirmPassword(String key) {
        sendKeys(confirmPasswordField, key);
    }

    public void preencherCampoComments(String key) {
        sendKeys(commentsField, key);
    }

    public void clicarNoBotaoSend() {
        click(sendButton);
    }

    public void clicarNoBotaoPrev() {
        click(prevButton);
    }

    public String capturarTextoEmPopUp() throws InterruptedException {
        Thread.sleep(1000);
        return getText(popUpText);
    }

    public void clicarEmBotaoOkPopUp() {
        click(okPopUpButton);
    }

    public String recuperarTextoAba() {
        return getText(tabName);
    }

    public void clicarEmAba() {
        click(tabName);
    }

    public String recuperarContagemDeAba() {
        return getText(tabCounter);
    }
}
