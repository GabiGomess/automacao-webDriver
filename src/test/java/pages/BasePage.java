package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;
    public BasePage(WebDriver driver) { this.driver = driver; }
    public String capturarTextoToast(String elemento) {
        return driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='" + elemento + "']")).getText();
    }
}
