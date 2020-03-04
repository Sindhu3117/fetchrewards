package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrandsPage;
import pages.HowItWorksPage;
import pages.InviteFriendsPage;
import pages.RewardsPage;
import utils.Utils;

import javax.rmi.CORBA.Util;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CareerPageTraversal {
    InviteFriendsPage invitePage = new InviteFriendsPage();
    BrandsPage brands = new BrandsPage();
    HowItWorksPage howItWorks = new HowItWorksPage();
    RewardsPage rewards = new RewardsPage();
    static WebDriver inviteFriendsDriver;

    @Test(groups = "careerPage")
    public void careerTraverseFromInvitePage() throws Exception {
        inviteFriendsDriver = invitePage.setBrowser();
        invitePage.careerTraverseFromInvitePage();
        Utils.quitBrowser(inviteFriendsDriver);
    }

    @Test(groups = "careerPage")
    public void careerTraverseFromBrandsPage() throws IOException {
        WebDriver brandsDriver = brands.setBrowser();
        brands.careerTraverseFromBrandsPage();
        Utils.quitBrowser(brandsDriver);
    }

    @Test(groups = "careerPage")
    public void careerTraverseFromHowitWorksPage() throws Exception {
        WebDriver howItWorkdsDriver = howItWorks.setBrowser();
        howItWorks.careerTraverseFromHowitWorksPage();
        Utils.quitBrowser(howItWorkdsDriver);
    }

    @Test(groups = "careerPage")
    public void careerTraverseFromRewardsPage() throws Exception {
        WebDriver rewardsDriver = rewards.setBrowser();
        rewards.careerTraverseFromRewardsPage();
        Utils.quitBrowser(rewardsDriver);
    }

    //open https://www.fetchrewards.com/referrals, go to home page and click career in footer section
    @Test(groups = "careerPage")
    public void homeToCareer() throws Exception {
        inviteFriendsDriver = invitePage.setBrowser();
        Utils.clickElement("homePagebutton", inviteFriendsDriver);
        invitePage.careerTraverseFromInvitePage();
        Utils.quitBrowser(inviteFriendsDriver);
    }

    /*
    Testcases that can be automated
    1. open https://www.fetchrewards.com/referrals, open help chat, minimize help chat and click career in footer section
    2. Open https://www.fetchrewards.com/ click "learn more" , click careers in footer
    3. Open https://www.fetchrewards.com/rewards, click "Art", click Art.com, and click careers in footer
    4. Open https://www.fetchrewards.com/how-it-works, click "Scan Receipts", click click careers in footer
    5. Open https://www.fetchrewards.com/how-it-works#scan, click "Invite Friends", click click careers in footer
     */




}
