package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import java.io.IOException;

public class EnterInsurantDataPage extends BasePage {
    public EnterInsurantDataPage(WebDriver driver) { super(driver); }

    public EnterInsurantDataPage addFirstName (String keys) {
        driver.findElement(By.id("firstname")).sendKeys(keys);
        return this;
    }

    public EnterInsurantDataPage addLastName (String keys) {
        driver.findElement(By.id("lastname")).sendKeys(keys);
        return this;
    }

    public EnterInsurantDataPage addDateOfBirth (String keys) {
        driver.findElement(By.id("birthdate")).sendKeys(keys);
        return this;
    }

    public EnterInsurantDataPage addGender (String keys) {
        if (keys.equals("Male")) {
            WebElement radioButton = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='gendermale']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(radioButton).click().build().perform();

        } else {
            WebElement radioButton = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='genderfemale']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(radioButton).click().build().perform();
        } return this;
    }

    public EnterInsurantDataPage addStreetAddress (String keys) {
        driver.findElement(By.id("streetaddress")).sendKeys(keys);
        return this;
    }

    public EnterInsurantDataPage addCountry (String keys) {
        WebElement field = driver.findElement(By.id("country"));
        new Select(field).selectByVisibleText(keys);
        return this;
    }

    public EnterInsurantDataPage addZipCode (int keys) {
        driver.findElement(By.id("zipcode")).sendKeys((String.valueOf(keys)));
        return this;
    }

    public EnterInsurantDataPage addCity (String keys) {
        driver.findElement(By.id("city")).sendKeys(keys);
        return this;
    }

    public EnterInsurantDataPage addOccupation (String keys) {
        driver.findElement(By.id("occupation")).sendKeys(keys);
        return this;
    }

    public EnterInsurantDataPage addHobbies (String[] keys) {
        for (String key : keys) {
            WebElement check = driver.findElement(By.xpath("//div/p[@class='group']/label[@class='ideal-radiocheck-label']/input[@id='" + key + "']"));
            Actions actions = new Actions(driver);
            actions.moveToElement(check).click().build().perform();
        }
        return this;
    }

    public EnterInsurantDataPage addWebsite (String keys) {
        driver.findElement(By.id("website")).sendKeys(keys);
        return this;
    }

    public EnterInsurantDataPage addPicture () throws IOException {
        driver.findElement(By.id("picture")).sendKeys( new File("../automacao-webDriver-Accenture/example.txt").getCanonicalPath());
        return this;
    }

    public EnterInsurantDataPage clickInNext() {
        driver.findElement(By.id("nextenterproductdata")).click();
        return this;
    }

    public EnterInsurantDataPage clickInPrev() {
        driver.findElement(By.id("preventervehicledata")).click();
        return this;
    }

    public EnterInsurantDataPage newInsurant (String firstname, String lastname, String birthdate, String gender, String streetaddress, String country,
                                              int zipcode, String city, String occupation, String[] hobbies, String website) throws IOException {
        return addFirstName(firstname)
                .addLastName(lastname)
                .addDateOfBirth(birthdate)
                .addGender(gender)
                .addStreetAddress(streetaddress)
                .addCountry(country)
                .addZipCode(zipcode)
                .addCity(city)
                .addOccupation(occupation)
                .addHobbies(hobbies)
                .addWebsite(website)
                .addPicture()
                .clickInNext();
    }
}
