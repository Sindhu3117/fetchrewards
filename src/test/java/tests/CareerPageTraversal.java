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

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CareerPageTraversal {
    InviteFriendsPage invitePage = new InviteFriendsPage();
    BrandsPage brands = new BrandsPage();
    HowItWorksPage howItWorks = new HowItWorksPage();
    RewardsPage rewards = new RewardsPage();

    @Test(groups = "careerPage")
    public void careerTraverseFromInvitePage() throws Exception {
        WebDriver inviteFriendsDriver = invitePage.setBrowser();
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

}
