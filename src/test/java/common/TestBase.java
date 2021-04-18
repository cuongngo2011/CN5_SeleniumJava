package common;

import driver.DriverManagerFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import utils.Logger;
import utils.report.ExtentTestManager;

public class TestBase {
    @Parameters({"browser", "runmode"})
    @BeforeClass(alwaysRun = true)
    public void startDriver(String browser, String runmode) throws Throwable {
        System.setProperty("browser", browser);

        String[] classPathName = this.getClass().getName().split("\\.");
        ExtentTestManager.startTest(classPathName[classPathName.length - 1]);
        ExtentTestManager.createNode("Pre-Condition");

        DriverManagerFactory.createDriver(Constants.BROWSER.get(browser), Constants.RUN_MODE.get(runmode));
        DriverManagerFactory.navigate(Constants.URL.RAILWAYS);
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        Logger.info("Quit Driver");
        DriverManagerFactory.getDriver().quit();
    }
}
