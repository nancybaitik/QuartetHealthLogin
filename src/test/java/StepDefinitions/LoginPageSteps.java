package StepDefinitions;

import Pages.LoginPage;
import Utils.ConfigReader;
import Utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPageSteps {

    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage(driver);
    String expErrorMessage = "Invalid username and/or password";
    String expErrorBanner = "Please fix the form errors below";
    String expEmailError = "Enter an email address";
    Actions actions = new Actions(driver);


    @When("user goes to Login Page")
    public void user_goes_to_Login_Page() throws InterruptedException {
        driver.get(ConfigReader.getProperty("url"));
         Thread.sleep(1000);
         Assert.assertTrue(loginPage.bannerMessage.isDisplayed());
    }

    @Then("user validates the title {string}")
    public void user_validates_the_title(String title) {
       Assert.assertEquals(title, driver.getTitle());
    }

    @Then("user validates Covid warning banner")
    public void user_validates_Covid_warning_banner() {
      Assert.assertTrue(loginPage.warningBanner.isDisplayed());
    }


    @When("the user enters invalid username {string} and invalid password {string}")
    public void the_user_enters_invalid_username_and_invalid_password(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("the user validates title after submit")
    public void the_user_validates_title_after_submit() {
        String expectedTitle = "Login - Quartet Health";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }


    @When("the user lives blank username and enters invalid password {string}")
    public void the_user_lives_blank_username_and_enters_invalid_password(String password) {
       loginPage.username.sendKeys("");
       loginPage.password.sendKeys(password);
       loginPage.loginButton.click();
    }

    @Then("the user validates error message")
    public void the_user_validates_error_message() {
       Assert.assertEquals(expEmailError,loginPage.emailErrorMessage.getText());
       Assert.assertTrue(loginPage.bannerMessage.isDisplayed());
    }

    @Then("the user doesn't enter any username and any password")
    public void the_user_doesn_t_enter_any_username_and_any_password() {
       loginPage.username.sendKeys("");
       loginPage.password.sendKeys("");
       loginPage.loginButton.click();
       Assert.assertEquals(expErrorBanner, loginPage.bannerMessage.getText());
       Assert.assertTrue(loginPage.emailErrorMessage.isDisplayed());
    }

    @Given("the user validates the encryption")
    public void the_user_validates_the_encryption() {
        loginPage.username.sendKeys("ABC");
        Assert.assertTrue(loginPage.passwordEncryption.isEnabled());
        loginPage.password.sendKeys("XYZ");
        loginPage.loginButton.click();

    }

    @Given("the user validates the forgot password function")
    public void the_user_validates_the_forgot_password_function() {
        loginPage.forgotPassword.click();
        Assert.assertEquals(ConfigReader.getProperty("resetPassword"), driver.getCurrentUrl());
    }


    @When("the user enters invalid username, invalid password and clicks ENTER key")
    public void the_user_enters_invalid_username_invalid_password_and_clicks_ENTER_key() {
        loginPage.username.sendKeys("abc");
        loginPage.password.sendKeys("xyz"+Keys.ENTER);
        Assert.assertEquals(expErrorMessage, loginPage.loginErrorMessage.getText());
    }


    @Then("the user enters invalid {string} and invalid {string}")
    public void the_user_enters_invalid_and_invalid(String username, String password) {
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.loginButton.click();
    }

    @Then("the user validates message and title")
    public void the_user_validates_message_and_title() {
        Assert.assertEquals(expErrorMessage,loginPage.loginErrorMessage.getText());
        Assert.assertEquals("Login - Quartet Health",driver.getTitle());
    }




}
