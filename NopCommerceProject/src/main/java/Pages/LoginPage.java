package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

public class LoginPage {
    private final SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("simpleJSON.json");

    // Locators
    private final By Login_Button = By.className("ico-login");
    private final By RegisterFromLoginPage_Btn = By.xpath("//button[normalize-space()='Register']");
    private final By Email_Txt = By.id("Email");
    private final By Password_Txt = By.id("Password");
    private final By RememberMe_CheckBox = By.id("RememberMe");
    private final By Login_BTN = By.xpath("//button[normalize-space()='Log in']");
    @Getter
    private final static By NoCustomerFound_Message = By.xpath("//li[normalize-space()='No customer account found']");
    @Getter
    private final static By EmailError_Message = By.id("Email-error");
    @Getter
    private final static By Logout_Btn = By.className("ico-logout");

    // Constructor
    public LoginPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }


    // Steps
    @Step("Click On The Login Button From The Home Page.")
    public void ClickOnLoginButtonFromHomePage(){
        driver.element().click(Login_Button);
    }
    @Step("Fill Out The Email Field With Valid Data.")
    public void FillOutTheEmailFieldWithValidData(){
        driver.element().type(Email_Txt, testData.getTestData("UserOneEmail"));
    }
    @Step("Fill Out The Email Field With Invalid Data [Email Not Registered].")
    public void FillOutTheEmailFieldWithEmailNotRegistered(){
        driver.element().type(Email_Txt, testData.getTestData("EmailNotRegistered"));
    }
    @Step("Fill Out The Email Field With Invalid Email Format.")
    public void FillOutTheEmailFieldWithInvalidFormat(){
        driver.element().type(Email_Txt, testData.getTestData("InvalidEmailFormat"));
    }
    @Step("Fill Out The Password Field With Valid Data.")
    public void FillOutThePasswordFieldWithValidData(){
        driver.element().type(Password_Txt, testData.getTestData("Password"));
    }
    @Step("Click On Remember Me Check-Box.")
    public void ClickOnRememberMeCheckBox(){
        driver.element().click(RememberMe_CheckBox);
    }
    @Step("Click On Log-in Button.")
    public void ClickOnLoginBTN(){
        driver.element().click(Login_BTN);
    }
    @Step("Click On Register Button To Create New User From The Login Page Path.")
    public void ClickOnRegisterBTN(){
        driver.element().click(RegisterFromLoginPage_Btn);
    }

}
