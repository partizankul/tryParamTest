package Utilites;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private  static WebDriver driver;

    private Driver(){}

    public static WebDriver getDriver(){
        if (driver == null){
            System.setProperty("webdriver.chrome.driver",
                    "src\\drivers\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }   return driver;
    }
    public static void close(){
        driver.close();
        driver = null;
    }
}
