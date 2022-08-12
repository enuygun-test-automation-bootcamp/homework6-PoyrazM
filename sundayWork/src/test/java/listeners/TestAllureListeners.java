package listeners;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import tests.BaseTest;

public class TestAllureListeners implements ITestListener {

    // Listener ekleyerek testim fail olduğu zaman ekran görüntüsü almasını beklerim.

    public void onTestFailure(ITestResult result) {
        saveScreenShotOnFailure(BaseTest.driver);
        saveLogs(result.getMethod().getConstructorOrMethod().getName());
    }

    @Attachment(value = "Screenshot" , type = "image/png")
    public byte[] saveScreenShotOnFailure(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment(value = "Stacktrack",type = "text/plain")
    public static String saveLogs(String message){
        return message;
    }
}
