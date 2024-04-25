package Pages;

import com.shaft.driver.SHAFT;
import io.qameta.allure.Step;
import lombok.Getter;
import org.openqa.selenium.By;

public class RegisterPage {

    private final SHAFT.GUI.WebDriver driver;
    SHAFT.TestData.JSON testData = new SHAFT.TestData.JSON("simpleJSON.json");

    // Locators
    private final By Register_Button = By.className("ico-register");
    private final By GenderMaleType_RadioBtn = By.id("gender-male");
    private final By GenderFemaleType_RadioBtn = By.id("gender-female");
    private final By FirstName_Txt = By.id("FirstName");
    private final By LastName_Txt = By.id("LastName");
    private final By DateOfBirthDay_DDL = By.name("DateOfBirthDay");
    private final By DateOfBirthMonth_DDL = By.name("DateOfBirthMonth");
    private final By DateOfBirthYear_DDL = By.name("DateOfBirthYear");
    private final By Email_Txt = By.id("Email");
    private final By CompanyName_Txt = By.id("Company");
    private final By Password_Txt = By.id("Password");
    private final By ConfirmPassword_Txt = By.id("ConfirmPassword");
    private final By Register_Btn = By.id("register-button");
    @Getter
    private final static By RegistrationSuccessMessage = By.xpath("//div[@class='result']");
    @Getter
    private final static By RegistrationFailMessage = By.xpath("//li[normalize-space()='The specified email already exists']");

    // Constructor
    public RegisterPage(SHAFT.GUI.WebDriver driver){
        this.driver = driver;
    }


    // Steps
    @Step("Click On The Register Button From The Home Page.")
    public void ClickOnRegisterButtonFromHomePage(){
        driver.element().click(Register_Button);
    }
    @Step("Select Gender Type [Male].")
    public void ClickOnMaleGenderType(){
        driver.element().click(GenderMaleType_RadioBtn);
    }

    @Step("Select Gender Type [Female].")
    public void ClickOnFemaleGenderType(){
        driver.element().click(GenderFemaleType_RadioBtn);
    }
    @Step("Fill Out The First Name Field With Valid Data [UserOne].")
    public void FillOutTheFirstNameWithValidDataUserOne(){
        driver.element().type(FirstName_Txt,testData.getTestData("FirstNameUserOne"));
    }
    @Step("Fill Out The First Name Field With Valid Data [UserTwo].")
    public void FillOutTheFirstNameWithValidDataUserTwo(){
        driver.element().type(FirstName_Txt,testData.getTestData("FirstNameUserTwo"));
    }
    @Step("Fill Out The First Name Field With Valid Data [UserThree].")
    public void FillOutTheFirstNameWithValidDataUserThree(){
        driver.element().type(FirstName_Txt,testData.getTestData("FirstNameUserThree"));
    }
    @Step("Fill Out The Last Name Field With Valid Data.")
    public void FillOutTheLastNameWithValidData(){
        driver.element().type(LastName_Txt,testData.getTestData("LastName"));
    }
    @Step("Fill Out The Date Of Birth Field With Valid Data [Day-Month-Year].")
    public void FillOutTheDateOfBirthField(){
        driver.element().select(DateOfBirthDay_DDL,"8");
        driver.element().select(DateOfBirthMonth_DDL,"5");
        driver.element().select(DateOfBirthYear_DDL,"1920");
    }
    @Step("Fill Out The Email Field With Valid Data [UserOne].")
    public void FillOutTheEmailWithValidDataUserOne(){
        driver.element().type(Email_Txt,testData.getTestData("UserOneEmail"));
    }
    @Step("Fill Out The Email Field With Valid Data [UserTwo].")
    public void FillOutTheEmailWithValidDataUserTwo(){
        driver.element().type(Email_Txt,testData.getTestData("UserTwoEmail"));
    }
    @Step("Fill Out The Email Field With Valid Data [UserThree].")
    public void FillOutTheEmailWithValidDataUserThree(){
        driver.element().type(Email_Txt,testData.getTestData("UserThreeEmail"));
    }
    @Step("Fill Out The Company Name Field With Valid Data.")
    public void FillOutTheCompanyNameWithValidData(){
        driver.element().type(CompanyName_Txt,testData.getTestData("CompanyName"));
    }
    @Step("Fill Out The Password Field With Valid Data.")
    public void FillOutThePasswordWithValidData(){
        driver.element().type(Password_Txt,testData.getTestData("Password"));
    }
    @Step("Fill Out The Confirmation Password Field With Valid Data.")
    public void FillOutTheConfirmationPasswordWithValidData(){
        driver.element().type(ConfirmPassword_Txt,testData.getTestData("Password"));
    }
    @Step("Click Button Register To Finish Up The User Registration.")
    public void ClickOnRegisterButton(){
        driver.element().click(Register_Btn);
    }

}
