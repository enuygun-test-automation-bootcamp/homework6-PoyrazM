package tests;

import com.github.javafaker.Faker;
import framework.ConfigReader;
import framework.DriverSetup;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;

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

    @AfterClass
    void tearDown(){
        if (driver != null){
            driver.close();
            driver.quit();
            driver = null;
        }
    }
}
