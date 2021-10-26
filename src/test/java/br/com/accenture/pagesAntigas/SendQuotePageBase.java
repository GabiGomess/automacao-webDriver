package br.com.accenture.pagesAntigas;
import br.com.accenture.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendQuotePageBase extends PageBase {
    public SendQuotePageBase(WebDriver driver) { super(driver); }

    public SendQuotePageBase addEmail (String keys) {
        driver.findElement(By.id("email")).sendKeys(keys);
        return this;
    }

    public SendQuotePageBase addPhone (String keys) {
        driver.findElement(By.id("phone")).sendKeys(keys);
        return this;
    }

    public SendQuotePageBase addUsername (String keys) {
        driver.findElement(By.id("username")).sendKeys(keys);
        return this;
    }

    public SendQuotePageBase addPassword (String keys) {
        driver.findElement(By.id("password")).sendKeys(keys);
        return this;
    }

    public SendQuotePageBase addConfirmPassword (String keys) {
        driver.findElement(By.id("confirmpassword")).sendKeys(keys);
        return this;
    }

    public SendQuotePageBase addComments (String keys) {
        driver.findElement(By.id("Comments")).sendKeys(keys);
        return this;
    }

    public SendQuotePageBase clickInPrev() {
        driver.findElement(By.id("prevselectpriceoption")).click();
        return this;
    }

    public SendQuotePageBase clickInSend() {
        driver.findElement(By.id("sendemail")).click();
        return this;
    }

    public SendQuotePageBase validatePopUp() {
        driver.findElement(By.xpath("//div[@class='sweet-alert showSweetAlert visible']/h2")).getText();
        return this;
    }

    public SendQuotePageBase clickInPopUpOk() {
        driver.findElement(By.xpath("//div[@class='sa-confirm-button-container']/button[@class='confirm']")).click();
        return this;
    }

    public SendQuotePageBase newSendQuote (String email, String phone, String username, String password, String confirmpassword,
                                           String comments) {
        return addEmail(email)
                .addPhone(phone)
                .addUsername(username)
                .addPassword(password)
                .addConfirmPassword(confirmpassword)
                .addComments(comments)
                .clickInSend()
                .validatePopUp()
                .clickInPopUpOk();
    }
}
