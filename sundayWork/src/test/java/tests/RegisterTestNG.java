package tests;

import com.github.javafaker.Faker;
import io.qameta.allure.AllureId;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.Assert;
import org.testng.annotations.Test;

import static pages.BasePage.jse;

public class RegisterTestNG extends BaseTest{
// Bu senaryoda ise kayıt olma otomasyonu vardır.

    private String nameAndLastName = FAKER.name().fullName();
    private String email = FAKER.internet().emailAddress();
    private String password = FAKER.internet().password();


    // Hesabım ikonuna tıklar
    @Test(priority = 1)
    @AllureId("1")
    @Description("User clicks the my account icon , if icon is displayed")
    void validateMyAccountIcon(){
        Assert.assertTrue(homePage.getMyAccountIcon().isDisplayed());
        homePage.clickToMyAccountIcon();
    }

    // Hesabım ikonundaki menü açılır kayıt ol butonuna tıklanır.
    @Test(priority = 2)
    @AllureId("2")
    @Description("User clicks register icon")
    void validateRegisterIcon(){
        homePage.clickToRegisterIcon();
    }

    // Kayıt ol sayfasındaki title ı kontrol eder.
    @Test(priority = 3)
    @AllureId("3")
    @Description("User checks to register page title")
    void validateRegisterPageTitle(){
        Assert.assertEquals(registerPage.checkTitleForRegisterPage(),"CREATE AN ACCOUNT");
    }

    // İsim ve soyisim girme fieldını kontrol edip , ad soyad gönderir
    @Test(priority = 4)
    @AllureId("4")
    @Description("User checks to name and surname field and fills empty name and surname field")
    void validateNameAndSurnameField(){
        Assert.assertEquals(registerPage.checkTitleForNameField(),"Name and Surname *");
        registerPage.sendKeysToNameField(this.nameAndLastName);
    }

    // Email fieldını kontrol edip , email gönderir
    @Test(priority = 5)
    @AllureId("5")
    @Description("User checks to email field and fills empty email field")
    void validateEmailField(){
        Assert.assertEquals(registerPage.checkTitleForEmailField(),"E-MAIL *");
        registerPage.sendKeysToEmailField(this.email);
    }

    // Şifre fieldını kontrol edip , şifre gönderir.
    @Test(priority = 6)
    @AllureId("6")
    @Description("User checks to password field and fills empty password field")
    void validatePasswordField(){
        Assert.assertEquals(registerPage.checkTitleForPasswordField(),"PASSWORD *");
        registerPage.sendKeysToPasswordField(this.password);
    }

    // Şifre onay fieldını kontrol edip , şifrenin aynısını gönderir.
    @Test(priority = 7)
    @AllureId("7")
    @Description("User checks to confirm password field and fills empty confirm password field")
    void validateConfirmPasswordField(){
        Assert.assertEquals(registerPage.checkTitleForConfirmPasswordField(),"CONFIRM PASSWORD *");
        registerPage.sendKeysToConfirmPasswordField(this.password);
    }

    // Mouse u aşağı kaydırarak creat butonu oradaysa kullanıcı oluşturur.
    @Test(priority = 8)
    @AllureId("8")
    @Description("User scrolls to create button and clicks to register create button")
    void validateSubmitButtonForCreateAccount(){
        jse.executeScript("window.scrollBy(0,250)");
        Assert.assertTrue(registerPage.getSubmitButtonForCreateAccount().isDisplayed());
        registerPage.clickToCreateSubmitButton();
    }

    // Eğer kullanıcı başarılı kayıt olursa ana sayfaya gider , olmazsa kayıt ol sayfasında hata alır.
    // Başarılı kayıt sonrası ana sayfa url kontrolü yapılır.
    @Test(priority = 9)
    @AllureId("9")
    @Description("User checks to Home Page after register operations")
    void validateSuccessRegisterToHomePage(){
        String expectedUrl = "https://www.flocake.com/";
        Assert.assertEquals(homePage.actualUrl(),expectedUrl);
    }
}
