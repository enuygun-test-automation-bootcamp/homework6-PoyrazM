package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class WishListPage extends BasePage{

// İstek listesindeki operasyonları ve elementleri tutar
    @FindBy(css = "h2[class='tt-title']")
    private WebElement inWishListProductTitle;

// İstek listesine eklenmiş ürünün başlığını döndürür
    public String wishListTitle(){
        return this.inWishListProductTitle.getText();
    }


}
