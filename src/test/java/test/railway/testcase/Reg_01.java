package test.railway.testcase;

import common.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.railway.page.HomePage;
import test.railway.page.RegisterPage;
import utils.Logger;

public class Reg_01 extends TestBase {

    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @Test(description = "Verify that user can open the Register page")
    public void Reg_01() {
        Logger.info("Step #1: Navigate to the Home page at http://www.railway.somee.com/Page/HomePage.cshtml");

        Logger.info("Step #2: Click on the Register tab");
        homePage.goToRegisterPage();

        Logger.info("Step #3: Observe the destination page");

        Logger.info("VP: User can open the Register page successfully");
        Assert.assertTrue(registerPage.isCreateAcountLabelDisplayed(), "The Register page should display");
    }
}
