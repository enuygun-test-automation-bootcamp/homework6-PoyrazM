package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@Data
public class ProductResultsPage extends BasePage{
// Ürün arandığı zaman veya dropdowndan belli bir title seçildiği zaman altında listelenen ürünlerin sonucunu döndürür.
    @FindBy(xpath = "//*[text()='Cake Juventus']")
    private WebElement cakeJuventusProduct;

    @FindBy(css = "h1[class='tt-title']")
    private WebElement productTitleText;

    // Juventus Pastası seçilir ve texti doğrulanır.
    public void selectCakeItem(){
        this.cakeJuventusProduct.click();
        Assert.assertEquals(this.productTitleText.getText(),"Cake Juventus");
    }

}
