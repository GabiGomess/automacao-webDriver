package pages;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase extends PageObject {
    // Variaveis globais
    protected WebDriverWait wait = null;
    protected WebDriver driver = null;


    public PageBase(WebDriver driver) { this.driver = driver; }
    public String nextPage(String elemento) {
        return driver.findElement(By.xpath("//div/nav[@id='idealsteps-nav']/ul/li/a[@name='" + elemento + "']")).getText();
    }
}
