package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ProductPage extends BasePage{
// Ürünün sayfasındaki elemanları ve operasyonları tutar

    @FindBy(id = "add_wishlist")
    private WebElement addWishlistButton;

    @FindBy(css = "div[data-tooltip='Favorites']")
    private WebElement goToWishListIcon;


// Favoriye ekleten metot
    public void addToWishList(){
        this.addWishlistButton.click();
    }

    // Eklenmiş favori ürün sonrası , favorilere gitmek için kullanılır.
    public void goToWishList(){
        this.goToWishListIcon.click();

    }


}
