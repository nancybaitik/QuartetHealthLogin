package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Set;

public class Browser {

    public static void switchWindowByTitle(WebDriver driver, String targetTitle){
        Set<String> ids  = driver.getWindowHandles();
        for(String id:ids){
            if (!driver.getTitle().equals(targetTitle)){
                driver.switchTo().window(id);
            }
        }

    }

    public static void closeWindows(WebDriver driver, String parentId){
        Set<String> ids = driver.getWindowHandles();
        for (String id: ids){
            if (!id.equals(parentId)){
                driver.switchTo().window(id);
                driver.close();
            }
        }
    }

    public static String  takeScreenShot(){

        File src = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.FILE);
        String destination = System.getProperty("user.dir")+"/Screenshot/"+System.currentTimeMillis()+".png";
        File location = new File(destination);
        try {
            FileUtils.copyFile(src, location);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return destination;
    }



}
