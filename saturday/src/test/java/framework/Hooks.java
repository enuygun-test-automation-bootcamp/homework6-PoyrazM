package framework;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

//Hooks for project
public class Hooks {

    WebDriver driver;
    Properties properties;

    @BeforeTest
    public void before() {
        properties = ConfigReader.initialize_Properties();
        driver = DriverSetup.initialize_Driver(properties.getProperty("browser"));
    }

    @AfterTest
    public void after() {
        driver.quit();
    }
}