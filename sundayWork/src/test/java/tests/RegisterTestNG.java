package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.BasePage.jse;

public class RegisterTestNG extends BaseTest{


    private String nameAndLastName = FAKER.name().fullName();
    private String email = FAKER.internet().emailAddress();
    private String password = FAKER.internet().password();

    @Test(priority = 1)
    @AllureId("1")
    @Description("User clicks the my account icon , if icon is displayed")
    void validateMyAccountIcon(){
        Assert.assertTrue(homePage.getMyAccountIcon().isDisplayed());
        homePage.clickToMyAccountIcon();
    }

    @Test(priority = 2)
    @AllureId("2")
    @Description("User clicks register icon")
    void validateRegisterIcon(){
        homePage.clickToRegisterIcon();
    }

    @Test(priority = 3)
    @AllureId("3")
    @Description("User checks to register page title")
    void validateRegisterPageTitle(){
        Assert.assertEquals(registerPage.checkTitleForRegisterPage(),"CREATE AN ACCOUNT");
    }

    @Test(priority = 4)
    @AllureId("4")
    @Description("User checks to name and surname field and fills empty name and surname field")
    void validateNameAndSurnameField(){
        Assert.assertEquals(registerPage.checkTitleForNameField(),"Name and Surname *");
        registerPage.sendKeysToNameField(this.nameAndLastName);
    }

    @Test(priority = 5)
    @AllureId("5")
    @Description("User checks to email field and fills empty email field")
    void validateEmailField(){
        Assert.assertEquals(registerPage.checkTitleForEmailField(),"E-MAIL *");
        registerPage.sendKeysToEmailField(this.email);
    }

    @Test(priority = 6)
    @AllureId("6")
    @Description("User checks to password field and fills empty password field")
    void validatePasswordField(){
        Assert.assertEquals(registerPage.checkTitleForPasswordField(),"PASSWORD *");
        registerPage.sendKeysToPasswordField(this.password);
    }

    @Test(priority = 7)
    @AllureId("7")
    @Description("User checks to confirm password field and fills empty confirm password field")
    void validateConfirmPasswordField(){
        Assert.assertEquals(registerPage.checkTitleForConfirmPasswordField(),"CONFIRM PASSWORD *");
        registerPage.sendKeysToConfirmPasswordField(this.password);
    }

    @Test(priority = 8)
    @AllureId("8")
    @Description("User scrolls to create button and clicks to register create button")
    void validateSubmitButtonForCreateAccount(){
        jse.executeScript("window.scrollBy(0,250)");
        Assert.assertTrue(registerPage.getSubmitButtonForCreateAccount().isDisplayed());
        registerPage.clickToCreateSubmitButton();
    }

    @Test(priority = 9)
    @AllureId("9")
    @Description("User checks to Home Page after register operations")
    void validateSuccessRegisterToHomePage(){
        String expectedUrl = "https://www.flocake.com/";
        Assert.assertEquals(homePage.actualUrl(),expectedUrl);
    }
}
