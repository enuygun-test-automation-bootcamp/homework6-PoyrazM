package pages;

import framework.Helper;
import lombok.Data;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static framework.DriverSetup.driver;
@Data
public class BasePage {
    public static Helper elementHelper;
    public static WebDriverWait wait;
    public static JavascriptExecutor jse;

    // Base Page sadece yapıcı döndürmek için kurulmuştur.
    public BasePage(){
        PageFactory.initElements(driver, this);
        elementHelper = new Helper(driver);
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        jse = (JavascriptExecutor) driver;
    }
}
