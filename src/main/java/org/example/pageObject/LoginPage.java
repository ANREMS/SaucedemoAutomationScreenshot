package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public static WebDriver webDriver;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }

    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//div[.='Sauce Labs Backpack']")
    private WebElement sauceLabsBackpackItem;

    @FindBy(css = "h3")
    private WebElement errMsg;

    public boolean verifyOnLoginPage(){
        return inputUsername.isDisplayed();
    }

    public void setUserName(String userName){
        inputUsername.sendKeys(userName);
    }

    public void setPassword(String pwd){
        inputPassword.sendKeys(pwd);
    }

    public void clickButtonLogin(){
        buttonLogin.click();
    }

    public boolean loginIsSuccessful(){
        return sauceLabsBackpackItem.isDisplayed();
    }

    public String loginIsError(){
        return errMsg.getText();
    }
}
