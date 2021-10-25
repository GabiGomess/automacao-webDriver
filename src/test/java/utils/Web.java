package utils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Web {
    @NotNull
    public static WebDriver createChrome() throws IOException {
        System.setProperty("webdriver.chrome.driver", new File("../automacao-webDriver-Accenture/chromedriver.exe").getCanonicalPath());
        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("http://sampleapp.tricentis.com/101/app.php");
        return driver;
    }
}