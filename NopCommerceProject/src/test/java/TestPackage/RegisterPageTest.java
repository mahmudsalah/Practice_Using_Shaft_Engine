package TestPackage;

import Pages.RegisterPage;
import org.testng.annotations.Test;
import io.qameta.allure.TmsLink;

public class RegisterPageTest extends TestBase {

    @TmsLink("TC01")
    @Test(description = "Verify that the user is able to register as a new user [UserOne].")
    public void CheckThatTheUserCanCreateNewUserAsMaleUser(){
        new RegisterPage(driver).ClickOnRegisterButtonFromHomePage();
        new RegisterPage(driver).ClickOnMaleGenderType();
        new RegisterPage(driver).FillOutTheFirstNameWithValidDataUserOne();
        new RegisterPage(driver).FillOutTheLastNameWithValidData();
        new RegisterPage(driver).FillOutTheDateOfBirthField();
        new RegisterPage(driver).FillOutTheEmailWithValidDataUserOne();
        new RegisterPage(driver).FillOutTheCompanyNameWithValidData();
        new RegisterPage(driver).FillOutThePasswordWithValidData();
        new RegisterPage(driver).FillOutTheConfirmationPasswordWithValidData();
        new RegisterPage(driver).ClickOnRegisterButton();

        driver.verifyThat().element(RegisterPage.getRegistrationSuccessMessage()).text().contains("Your registration completed").perform();
    }
    @TmsLink("TC02")
    @Test(description = "Verify that the user is able to register as a new user [UserTwo].")
    public void CheckThatTheUserCanCreateNewUserAsFemaleUser(){
        new RegisterPage(driver).ClickOnRegisterButtonFromHomePage();
        new RegisterPage(driver).ClickOnFemaleGenderType();
        new RegisterPage(driver).FillOutTheFirstNameWithValidDataUserTwo();
        new RegisterPage(driver).FillOutTheLastNameWithValidData();
        new RegisterPage(driver).FillOutTheDateOfBirthField();
        new RegisterPage(driver).FillOutTheEmailWithValidDataUserTwo();
        new RegisterPage(driver).FillOutTheCompanyNameWithValidData();
        new RegisterPage(driver).FillOutThePasswordWithValidData();
        new RegisterPage(driver).FillOutTheConfirmationPasswordWithValidData();
        new RegisterPage(driver).ClickOnRegisterButton();

        driver.verifyThat().element(RegisterPage.getRegistrationSuccessMessage()).text().contains("Your registration completed").perform();
    }
    @TmsLink("TC03")
    @Test(dependsOnMethods = {"CheckThatTheUserCanCreateNewUserAsMaleUser"}, description = "Verify The Registration With Email Already Exist.")
    public void CheckThatTheUserCannotRegisterWithEmailAlreadyExist(){
        new RegisterPage(driver).ClickOnRegisterButtonFromHomePage();
        new RegisterPage(driver).ClickOnMaleGenderType();
        new RegisterPage(driver).FillOutTheFirstNameWithValidDataUserOne();
        new RegisterPage(driver).FillOutTheLastNameWithValidData();
        new RegisterPage(driver).FillOutTheDateOfBirthField();
        new RegisterPage(driver).FillOutTheEmailWithValidDataUserOne();
        new RegisterPage(driver).FillOutTheCompanyNameWithValidData();
        new RegisterPage(driver).FillOutThePasswordWithValidData();
        new RegisterPage(driver).FillOutTheConfirmationPasswordWithValidData();
        new RegisterPage(driver).ClickOnRegisterButton();

        driver.verifyThat().element(RegisterPage.getRegistrationFailMessage()).text().contains("The specified email already exists").perform();

    }

}
