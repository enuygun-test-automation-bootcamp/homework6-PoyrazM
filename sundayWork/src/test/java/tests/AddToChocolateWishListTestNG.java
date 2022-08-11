package tests;

import framework.Helper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToChocolateWishListTestNG extends BaseTest{

    @Test(priority = 1)
    void checkAddToWishListSuccessfully(){
        Assert.assertTrue(homePage.getCakesForDropdown().isDisplayed());
        homePage.selectChocolateFromCakesDropDown();
    }

    @Test(priority = 2)
    void validateSelectItem(){
        Assert.assertTrue(productsListPage.getCakeJuventusProduct().isDisplayed());
        productsListPage.selectCakeItem();
    }

    @Test(priority = 3)
    void validateWishListButton(){
        Assert.assertTrue(productPage.getAddWishlistButton().isDisplayed());
        productPage.addToWishList();
    }

    @Test(priority = 4)
    void validateWishListIcon(){
        Assert.assertTrue(productPage.getGoToWishListIcon().isEnabled());
        productPage.goToWishList();
    }


    @Test(priority = 5)
    void validateAddToCartTitle(){
        Assert.assertEquals(wishListPage.wishListTitle(),"Cake Juventus");
    }
}
