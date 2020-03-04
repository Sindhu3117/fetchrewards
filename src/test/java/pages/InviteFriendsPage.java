package pages;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class InviteFriendsPage {
    static WebDriver inviteFriendsDriver=null;


    public WebDriver setBrowser() throws IOException {
        String browser = Utils.getConfig("chromebrowser");
        String url = Utils.getConfig("invitefriends");
        inviteFriendsDriver = Utils.setUp(browser, url);
        return inviteFriendsDriver;
    }

    @Test(groups = "careerPageTraversal")
    public void careerTraverseFromInvitePage() throws Exception {
        Utils.clickCareersElement();
        inviteFriendsDriver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        Assert.assertTrue(Utils.validateURL(inviteFriendsDriver), "careers page not found");
    }




}
