package driver;

import common.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class DriverManagerFactory {
    private static ThreadLocal<DriverManager> drivers = new ThreadLocal<>();

    public static WebDriver getDriver() {
        return drivers.get().getDriver();
    }

    public static Object execJavaScript(String script, Object... objs) {
        return ((JavascriptExecutor) getDriver()).executeScript(script, objs);
    }

    public static String captureScreenshot(String filename, String filepath) {
        String relativePath = "";
        try {
            // Taking the screen using TakesScreenshot Class
            File objScreenCaptureFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);

            // Storing the image in the local system.
            File dest = new File(
                    System.getProperty("user.dir") + File.separator + filepath + File.separator + filename + ".png");
            FileUtils.copyFile(objScreenCaptureFile, dest);
            relativePath = "../screenshots" + File.separator + filename + ".png";
        } catch (Exception e) {

        }
        return relativePath;
    }

    public static void createDriver(Constants.BROWSER browser, Constants.RUN_MODE mode) throws Exception {
        DriverManager driverManager = new DriverManager();
        driverManager.createDriver(browser, mode);
        drivers.set(driverManager);
    }
}
