package pages;

import lombok.Data;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Data
public class RegisterPage extends BasePage{

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

    public String checkTitleForRegisterPage(){
        return this.registerPageTitle.getText();
    }

    public String checkTitleForNameField(){
        return this.labelForNameField.getText();
    }

    public void sendKeysToNameField(String nameAndSurName){
        this.nameInputField.sendKeys(nameAndSurName);
    }

    public String checkTitleForEmailField(){
        return this.labelForEmailField.getText();
    }

    public void sendKeysToEmailField(String emailAddress){
        this.emailInputField.sendKeys(emailAddress);
    }

    public String checkTitleForPasswordField(){
        return this.labelForPasswordField.getText();
    }

    public void sendKeysToPasswordField(String password){
        this.passwordInputField.sendKeys(password);
    }

    public String checkTitleForConfirmPasswordField(){
        return this.labelForConfirmPassField.getText();
    }

    public void sendKeysToConfirmPasswordField(String confirmPassword){
        this.confirmPasswordField.sendKeys(confirmPassword);
    }

    public void clickToCreateSubmitButton(){

        this.submitButtonForCreateAccount.click();
    }
}
