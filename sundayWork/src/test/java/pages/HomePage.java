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

    public void selectChocolateFromCakesDropDown(){
        elementHelper.hasanHocanınHoverMoverı(this.cakesForDropdown);
        this.chocolateButton.click();
    }

    public void clickToMyAccountIcon(){
        this.myAccountIcon.click();
    }

    public void clickToRegisterIcon(){
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//a[text()='Register'])[2]")));
         Assert.assertTrue(getRegisterIcon().isDisplayed());
         this.registerIcon.click();
    }

    public String actualUrl(){
        return driver.getCurrentUrl();
    }
}
