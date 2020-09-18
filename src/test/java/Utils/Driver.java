package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import java.util.concurrent.TimeUnit;
public class Driver {

    /*
     for driver I've used Singleton Design Pattern - to have one instance for the driver and
     avoid it's instantiation in different classes

     Rules for Singleton Design Pattern:
     1- Create private static variable
     2- Create private constructor
     3- Create the method to get your driver
     instantiate the driver if it is equals to null
     */



    private static WebDriver driver;


    private Driver(){ }

    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("driverName")) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;

            }
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        return driver;
    }

}
