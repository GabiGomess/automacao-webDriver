package br.com.accenture.pages;

import br.com.accenture.bases.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class EnterInsurantDataPage extends PageBase {

    // Constructor
    public EnterInsurantDataPage(WebDriver driver) {
        super(driver);
    }

    // Mapping page
    By firstNameField = By.id("firstname");
    By lastNameField = By.id("lastname");
    By dateOfBirthField = By.id("birthdate");
    By genderFemaleField = By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='genderfemale']");
    By genderMaleField = By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='gendermale']");
    By streetAddressField = By.id("streetaddress");
    By countryField = By.id("country");
    By zipCodeField = By.id("zipcode");
    By cityField = By.id("city");
    By occupationField = By.id("occupation");
    By websiteField = By.id("website");
    By pictureField = By.id("picture");
    By nextButton = By.id("nextenterproductdata");
    By prevButton = By.id("preventervehicledata");
    By tabName = By.id("enterinsurantdata");
    By tabCounter = By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='Enter Insurant Data']/span");

    // Actions
    public void preencherCampoFirstName(String key) {
        sendKeys(firstNameField, key);
    }

    public void preencherCampoLastName(String key) {
        sendKeys(lastNameField, key);
    }

    public void preencherCampoDateOfBirth(String key) {
        sendKeys(dateOfBirthField, key);
    }

    public void preencherCampoGender(String key) {
        if (key.equals("Female")) {
            radioBox(genderFemaleField, key);
        } else {
            radioBox(genderMaleField, key);
        }
    }

    public void preencherCampoStreetAddress(String key) {
        sendKeys(streetAddressField, key);
    }

    public void preencherCampoCountry(String key) {
        sendKeys(countryField, key);
    }

    public void preencherCampoZipCodeField(String key) {
        sendKeys(zipCodeField, key);
    }

    public void preencherCampoCityField(String key) {
        sendKeys(cityField, key);
    }

    public void preencherCampoOccupationField(String key) {
        sendKeys(occupationField, key);
    }

    public void preencherCampoHobbies(String[] keys) {
        for (String key : keys) {
            WebElement check = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='" + key.replace(" ", "") + "']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(check).click().build().perform();
        }
    }

    public void preencherCampoWebsite(String key) {
        sendKeys(websiteField, key);
    }

    public void preencherCampoPicture() throws IOException {
        driver.findElement(pictureField).sendKeys(new File("../automacao-webDriver-Accenture/example.txt").getCanonicalPath());
    }

    public void clicarNoBotaoNext() {
        click(nextButton);
    }

    public void clicarNoBotaoPrev() {
        click(prevButton);
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
