package tests;

import com.github.javafaker.Faker;
import framework.ConfigReader;
import framework.DriverSetup;
import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import pages.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BaseTest {
    public static WebDriver driver;

    HomePage homePage;
    ProductResultsPage productsListPage;
    ProductPage productPage;
    WishListPage cartPage;
    WishListPage wishListPage;
    RegisterPage registerPage;

    public static Faker FAKER;
    public BaseTest(){
        FAKER = new Faker();
    }


// Burası benim parent test classım
    @BeforeClass
    void setup(){
        driver = DriverSetup.initialize_Driver(ConfigReader.initialize_Properties().get("browser").toString());
        this.homePage = new HomePage();
        this.productsListPage = new ProductResultsPage();
        this.productPage = new ProductPage();
        this.cartPage = new WishListPage();
        this.wishListPage = new WishListPage();
        this.registerPage = new RegisterPage();
    }



    @AfterSuite
    void tearDown(){
        if (driver != null){
            driver.quit();
        }
    }
}
