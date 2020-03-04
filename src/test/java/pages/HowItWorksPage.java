package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class HowItWorksPage {
    static WebDriver howItWorkdsDriver;


    public WebDriver setBrowser() throws IOException {
        String browser = Utils.getConfig("chromebrowser");
        String url = Utils.getConfig("rewards");
        howItWorkdsDriver = Utils.setUp(browser, url);
        return howItWorkdsDriver;
    }

    @Test(groups = "careerPageTraversal")
    public void careerTraverseFromHowitWorksPage() throws Exception {
        setBrowser();
        Utils.clickCareersElement();
        howItWorkdsDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(Utils.validateURL(howItWorkdsDriver), "careers page not found");

    }




}
