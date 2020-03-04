package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Utils {
    private static WebDriver driver=null;

    public static WebDriver setUp(String browsername, String url ){
        if(browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver","C:\\Software\\SeleniumDrivers\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if(browsername.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.chrome.driver","C:\\Software\\SeleniumDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
        else{
            System.out.println("No such browser supported");
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;
    }

    public static void clickCareersElement() {
        try{
            InputStream locatorFile = new FileInputStream("src\\test\\java\\locators\\locators.properties");
            Properties prop = new Properties();
            prop.load(locatorFile);
            System.out.println("*************driver is "+driver);
            WebElement element = driver.findElement(By.xpath(prop.getProperty("careers")));

            if(element.isDisplayed())
                element.click();
        }
        catch(ElementNotVisibleException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }

    public static String getConfig(String property) throws IOException {
        InputStream configFile = new FileInputStream("src\\test\\java\\configs\\configuration.properties");
        Properties prop = new Properties();
        prop.load(configFile);
        return prop.getProperty(property);
    }

    public static String getlocator(String property) throws IOException {
        InputStream locatorFile = new FileInputStream("src\\test\\java\\locators\\locators.properties");
        Properties prop = new Properties();
        prop.load(locatorFile);
        return prop.getProperty(property);
    }

    public static void clickElement(String locator, WebDriver driver) throws IOException {
        driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
        InputStream locatorFile = new FileInputStream("src\\test\\java\\locators\\locators.properties");
        Properties prop = new Properties();
        prop.load(locatorFile);
        String xpath = prop.getProperty(locator);
        System.out.println("********xpath: "+xpath);
        WebElement element = driver.findElement(By.xpath(xpath));
        element.click();
    }

    public static Boolean validateURL(WebDriver driver) throws IOException {
        String careerURL = driver.getCurrentUrl();
        return careerURL.contains("careers");
    }

    public static void quitBrowser(WebDriver driver){
        driver.quit();
    }

}
