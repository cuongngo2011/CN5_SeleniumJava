package utils.report;

import com.aventstack.extentreports.Status;
import driver.DriverManagerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class TestListener implements ITestListener {


    public void onTestFailure(ITestResult result) {
        ExtentTestManager.addIntoExtentReport(result, false, Status.FAIL);

        String screenshotsFolder = "output/screenshots";
        String fileNameScreenShot = System.getProperty("extentReportFileName") + "-" + System.currentTimeMillis();
        new File(screenshotsFolder).mkdirs();
        DriverManagerFactory.captureScreenshot(fileNameScreenShot, screenshotsFolder);
        ExtentTestManager.getNode().log(Status.FAIL, "<img src='" + "../screenshots/" + fileNameScreenShot + ".png' style='width: 100%; height: 70%;' >");
    }

    public void onTestStart(ITestResult result) {
        ExtentTestManager.addIntoExtentReport(result, true, null);
    }

    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.addIntoExtentReport(result, false, Status.PASS);
    }

    public void onTestSkipped(ITestResult result) {
        DriverManagerFactory.getDriver().quit();
        ExtentTestManager.addIntoExtentReport(result, true, Status.SKIP);
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    public void onStart(ITestContext context) {
        String suiteName = context.getCurrentXmlTest().getName();
        System.setProperty("suite", suiteName);

        //if running from Jenkins, set appName = empty
        if (System.getProperty("Mode") == null) {
            String[] arrNames = context.getCurrentXmlTest().getSuite().getFileName().replace("\\" + suiteName + ".xml", "").split("\\\\");
            System.setProperty("appName", arrNames[arrNames.length - 1]);
        } else {
            System.setProperty("appName", "");
        }
        ExtentManager.createInstance();
    }

    public void onFinish(ITestContext context) {
        // Extend Report
        ExtentTestManager.endTest();
        ExtentManager.getInstance().flush();
    }
}
