package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
public class RegisterPage extends BasePage{
// Bu class siteye kayıt olma sayfasındaki elementleri tutar. Operasyon döndürür.
    @FindBy(xpath = "//h1[text()='CREATE AN ACCOUNT ']")
    private WebElement registerPageTitle;

    @FindBy(css = "label[for='loginInputName']")
    private WebElement labelForNameField;

    @FindBy(id = "loginInputName")
    private WebElement nameInputField;

    @FindBy(css = "label[for='loginInputEmail']")
    private WebElement labelForEmailField;

    @FindBy(id = "loginInputEmail")
    private WebElement emailInputField;

    @FindBy(css = "label[for='loginInputPassword']")
    private WebElement labelForPasswordField;

    @FindBy(id = "loginInputPassword")
    private WebElement passwordInputField;

    @FindBy(css = "label[for='loginInputPasswordConfirm']")
    private WebElement labelForConfirmPassField;

    @FindBy(id = "loginInputPasswordConfirm")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//button[text()='CREATE']")
    private WebElement submitButtonForCreateAccount;

    //Kayıt olma sayfasındaki başlığı döndürür
    public String checkTitleForRegisterPage(){
        return this.registerPageTitle.getText();
    }

    //Kayıt olma sayfasındaki isim alanının başlığını döndürür
    public String checkTitleForNameField(){
        return this.labelForNameField.getText();
    }

    //Kayıt olma sayfasındaki isim alanına key gönderir
    public void sendKeysToNameField(String nameAndSurName){
        this.nameInputField.sendKeys(nameAndSurName);
    }

    //Kayıt olma sayfasındaki email alanının başlığını döndürür
    public String checkTitleForEmailField(){
        return this.labelForEmailField.getText();
    }

    //Kayıt olma sayfasındaki email alanına key gönderir
    public void sendKeysToEmailField(String emailAddress){
        this.emailInputField.sendKeys(emailAddress);
    }

    //Kayıt olma sayfasındaki şifre alanının başlığını döndürür
    public String checkTitleForPasswordField(){
        return this.labelForPasswordField.getText();
    }

    //Kayıt olma sayfasındaki şifre alanının başlığını döndürür
    public void sendKeysToPasswordField(String password){
        this.passwordInputField.sendKeys(password);
    }

    //Kayıt olma sayfasındaki şifre doğrulama alanının başlığını döndürür
    public String checkTitleForConfirmPasswordField(){
        return this.labelForConfirmPassField.getText();
    }

    //Kayıt olma sayfasındaki şifre doğrulama alanına key gönderir
    public void sendKeysToConfirmPasswordField(String confirmPassword){
        this.confirmPasswordField.sendKeys(confirmPassword);
    }

    // Kullanıcı üret butonuna tıklar
    public void clickToCreateSubmitButton(){

        this.submitButtonForCreateAccount.click();
    }
}
