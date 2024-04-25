package TestPackage;

import Pages.LoginPage;
import Pages.RegisterPage;
import io.qameta.allure.TmsLink;
import org.testng.annotations.*;

public class LoginPageTest extends TestBase {

    @TmsLink("TC01")
    @Test(description = "Verify that the user is not able to log-in with invalid Email format.")
    public void CheckThatTheUserCannotLoginWithInvalidEmailFormat() {
        new LoginPage(driver).ClickOnLoginButtonFromHomePage();
        new LoginPage(driver).FillOutTheEmailFieldWithInvalidFormat();
        new LoginPage(driver).FillOutThePasswordFieldWithValidData();
        new LoginPage(driver).ClickOnLoginBTN();

        driver.verifyThat().element(LoginPage.getEmailError_Message()).text().contains("Wrong email").perform();
    }

    @TmsLink("TC02")
    @Test(description = "Verify that the user is not able to log-in with valid Email but not registered.")
    public void CheckThatTheUserCannotLoginWithValidEmailNotRegisteredBefore() {
        new LoginPage(driver).ClickOnLoginButtonFromHomePage();
        new LoginPage(driver).FillOutTheEmailFieldWithEmailNotRegistered();
        new LoginPage(driver).FillOutThePasswordFieldWithValidData();
        new LoginPage(driver).ClickOnLoginBTN();

        driver.verifyThat().element(LoginPage.getNoCustomerFound_Message()).text().contains("No customer account found").perform();
    }

    @TmsLink("TC03")
    @Test(description = "Verify that the user is able to create new user from the log-in page [UserThree].")
    public void CheckThatTheUserIsAbleToCreateNewUserFromTheLoginPage() {
        new LoginPage(driver).ClickOnLoginButtonFromHomePage();
        new LoginPage(driver).ClickOnRegisterBTN();
        new RegisterPage(driver).ClickOnMaleGenderType();
        new RegisterPage(driver).FillOutTheFirstNameWithValidDataUserThree();
        new RegisterPage(driver).FillOutTheLastNameWithValidData();
        new RegisterPage(driver).FillOutTheDateOfBirthField();
        new RegisterPage(driver).FillOutTheEmailWithValidDataUserThree();
        new RegisterPage(driver).FillOutTheCompanyNameWithValidData();
        new RegisterPage(driver).FillOutThePasswordWithValidData();
        new RegisterPage(driver).FillOutTheConfirmationPasswordWithValidData();
        new RegisterPage(driver).ClickOnRegisterButton();

        driver.verifyThat().element(RegisterPage.getRegistrationSuccessMessage()).text().contains("Your registration completed").perform();
    }

    @TmsLink("TC04")
    @Test(dependsOnMethods = {"CheckThatTheUserCannotLoginWithInvalidEmailFormat","CheckThatTheUserCannotLoginWithValidEmailNotRegisteredBefore","CheckThatTheUserIsAbleToCreateNewUserFromTheLoginPage"},
            description = "Verify that the user is able to log-in with valid credentials.")
    public void CheckThatTheUserIsAbleToLoginWithValidCredentials() {
        new LoginPage(driver).ClickOnLoginButtonFromHomePage();
        new LoginPage(driver).FillOutTheEmailFieldWithValidData();
        new LoginPage(driver).FillOutThePasswordFieldWithValidData();
        new LoginPage(driver).ClickOnRememberMeCheckBox();
        new LoginPage(driver).ClickOnLoginBTN();

        driver.verifyThat().element(LoginPage.getLogout_Btn()).exists().perform();
    }

}
