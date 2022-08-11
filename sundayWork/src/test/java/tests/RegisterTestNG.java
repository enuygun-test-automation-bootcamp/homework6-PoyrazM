package tests;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.BasePage.jse;

public class RegisterTestNG extends BaseTest{


    private String nameAndLastName = FAKER.name().fullName();
    private String email = FAKER.internet().emailAddress();
    private String password = FAKER.internet().password();


    @Test(priority = 1)
    void validateMyAccountIcon(){
        Assert.assertTrue(homePage.getMyAccountIcon().isDisplayed());
        homePage.clickToMyAccountIcon();
    }

    @Test(priority = 2)
    void validateRegisterIcon() throws InterruptedException {
        homePage.clickToRegisterIcon();
    }

    @Test(priority = 3)
    void validateRegisterPageTitle(){
        Assert.assertEquals(registerPage.checkTitleForRegisterPage(),"CREATE AN ACCOUNT");
    }

    @Test(priority = 4)
    void validateNameAndSurnameField(){
        Assert.assertEquals(registerPage.checkTitleForNameField(),"Name and Surname *");
        registerPage.sendKeysToNameField(this.nameAndLastName);
    }

    @Test(priority = 4)
    void validateEmailField(){
        Assert.assertEquals(registerPage.checkTitleForEmailField(),"E-MAIL *");
        registerPage.sendKeysToEmailField(this.email);
    }

    @Test(priority = 5)
    void validatePasswordField(){
        Assert.assertEquals(registerPage.checkTitleForPasswordField(),"PASSWORD *");
        registerPage.sendKeysToPasswordField(this.password);
    }

    @Test(priority = 6)
    void validateConfirmPasswordField(){
        Assert.assertEquals(registerPage.checkTitleForConfirmPasswordField(),"CONFIRM PASSWORD *");
        registerPage.sendKeysToConfirmPasswordField(this.password);
    }

    @Test(priority = 7)
    void validateSubmitButtonForCreateAccount(){
        jse.executeScript("window.scrollBy(0,250)");
        Assert.assertTrue(registerPage.getSubmitButtonForCreateAccount().isDisplayed());
        registerPage.clickToCreateSubmitButton();
    }

    @Test(priority = 8)
    void validateSuccessRegisterToHomePage(){
        String expectedUrl = "https://www.flocake.com/";
        Assert.assertEquals(homePage.actualUrl(),expectedUrl);
    }
}
