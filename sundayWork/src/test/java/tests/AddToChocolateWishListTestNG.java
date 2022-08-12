package tests;

import framework.Helper;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToChocolateWishListTestNG extends BaseTest{
// Dropdowndan pasta kısmı açılıp oradan çikolata seçip , bulunan sonuçlardaki juventus pastasını istek listesine ekleyerek
    // Oraya gerçekten gitti mi kontrolünün yapıldığı test

    // Burada pasta kısmından çikolatalı pasta seçilir.
    @Test(priority = 1)
    @AllureId("11")
    @Description("User move to mouse on the dropdown and selects chocolate under the CAKES")
    void checkAddToWishListSuccessfully(){
        Assert.assertTrue(homePage.getCakesForDropdown().isDisplayed());
        homePage.selectChocolateFromCakesDropDown();
    }

    // Çikolatalı pasta seçimi sonrası dönen sonuçlardan sonra Juventus pastası seçilir.
    @Test(priority = 2)
    @AllureId("22")
    @Description("User checks and selects Cake Juventus")
    void validateSelectItem(){
        Assert.assertTrue(productsListPage.getCakeJuventusProduct().isDisplayed());
        productsListPage.selectCakeItem();
    }

    // Juventus pastası seçildikten sonra istek listesine eklenir
    @Test(priority = 3)
    @AllureId("33")
    @Description("User check add wish list button under the  Cake Juventus , and clicks the this icon")
    void validateWishListButton(){
        Assert.assertTrue(productPage.getAddWishlistButton().isDisplayed());
        productPage.addToWishList();
    }

    // İstek listesi sayfasına gitmek için gereken butona tıklar
    @Test(priority = 4)
    @AllureId("44")
    @Description("User wants to add wish list page , so checks and clicks to wish list icon")
    void validateWishListIcon(){
        Assert.assertTrue(productPage.getGoToWishListIcon().isEnabled());
        productPage.goToWishList();
    }

    // İstek listesinde seçilen ürünün title'ı kontrol edilip , doğrulama yapılır.
    @Test(priority = 5)
    @AllureId("55")
    @Description("User checks the cart page title and user validates to true cake")
    void validateAddToCartTitle(){
        Assert.assertEquals(wishListPage.wishListTitle(),"Cake Juventus");
    }
}
