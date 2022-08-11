package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ProductPage extends BasePage{


    @FindBy(id = "add_wishlist")
    private WebElement addWishlistButton;

    @FindBy(css = "div[data-tooltip='Favorites']")
    private WebElement goToWishListIcon;



    public void addToWishList(){
        this.addWishlistButton.click();
    }

    public void goToWishList(){
        this.goToWishListIcon.click();

    }


}
