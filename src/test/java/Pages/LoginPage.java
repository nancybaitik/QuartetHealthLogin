package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@type='warning']")
    public WebElement warningBanner;

    @FindBy(xpath = "//input[@id='email']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@data-test='field-error']")
    public WebElement loginErrorMessage;

    @FindBy(xpath = "//div[text()='Enter an email address']")
    public WebElement emailErrorMessage;

    @FindBy(xpath = "//div[@data-test='banner-message']")
    public WebElement bannerMessage;

    @FindBy(xpath = "//div[@class='PasswordField__Reveal-k5wv0j-1 eHlEWL']")
    public WebElement passwordEncryption;

    @FindBy(xpath = "//a[@data-test='link-patient-forgot-password']")
    public WebElement forgotPassword;










}
