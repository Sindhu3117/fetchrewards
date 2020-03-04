package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Utils;

import java.io.IOException;

public class BrandsPage {


    static WebDriver brandsDriver;


    public WebDriver setBrowser() throws IOException {
        String browser = Utils.getConfig("chromebrowser");
        String url = Utils.getConfig("brands");
        brandsDriver = Utils.setUp(browser, url);
        return brandsDriver;
    }

    @Test(groups = "careerPageTraversal")
    public void careerTraverseFromBrandsPage() throws IOException {
        Utils.clickCareersElement();
        Assert.assertTrue(Utils.validateURL(brandsDriver), "careers page not found");
    }





}
