package pages;

import lombok.Data;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class WishListPage extends BasePage{


    @FindBy(css = "h2[class='tt-title']")
    private WebElement inWishListProductTitle;


    public String wishListTitle(){
        return this.inWishListProductTitle.getText();
    }


}
