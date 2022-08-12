package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import static framework.DriverSetup.driver;

@Data
public class HomePage extends BasePage{

// Ana sayfa Elementleri ve operasyonlarının tutulduğu class. Metotları daha sonra yapacağım test senaryosuna göre çağırabilirim
    @FindBy(id = "search-input")
    private WebElement searchInput;

    @FindBy(css = "button[type=submit]")
    private WebElement searchIcon;

    @FindBy(xpath = "(//*[@class='dropdown megamenu tt-submenu'])[4]")
    private WebElement cakesForDropdown;

    @FindBy(xpath = "(//*[text()='Chocolate'])[4]")
    private WebElement chocolateButton;


    @FindBy(css = "button[data-tooltip='My account']")
    private WebElement myAccountIcon;

    @FindBy(xpath = "(//a[text()='Register'])[2]")
    private WebElement registerIcon;
// Drop downun üstüne gelir ve CAKES menüsünü açarak çikolotayı seçer.
    public void selectChocolateFromCakesDropDown(){
        elementHelper.hasanHocanınHoverMoverı(this.cakesForDropdown);
        this.chocolateButton.click();
    }
// My Account ikonuna tıklar
    public void clickToMyAccountIcon(){
        this.myAccountIcon.click();
    }

    // Siteye kayıt ol ikonuna tıklatır.
    public void clickToRegisterIcon(){
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Register'])[2]")));
         Assert.assertTrue(getRegisterIcon().isDisplayed());
         this.registerIcon.click();
    }

    // Güncel url'yi döndürür.
    public String actualUrl(){
        return driver.getCurrentUrl();
    }
}
