package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RewardsPage {
    static WebDriver rewardsDriver;

    @BeforeClass
    public WebDriver setBrowser() throws IOException {
        String browser = Utils.getConfig("chromebrowser");
        String url = Utils.getConfig("rewards");
        rewardsDriver = Utils.setUp(browser, url);
        return rewardsDriver;
    }

    @Test(groups = "careerPageTraversal")
    public void careerTraverseFromRewardsPage() throws IOException {
        Utils.clickCareersElement();
        rewardsDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Assert.assertTrue(Utils.validateURL(rewardsDriver), "careers page not found");
    }




}
