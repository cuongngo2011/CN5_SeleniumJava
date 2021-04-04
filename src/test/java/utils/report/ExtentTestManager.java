package utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {

    static Map<Integer, ExtentTest> extentTestMap = new HashMap<Integer, ExtentTest>();
    static ExtentReports extent = ExtentManager.getInstance();
    static ExtentTest childTest = null;
    static ExtentTest parentTest = null;

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) (Thread.currentThread().getId()));
    }

    public static void createNode(String node) {
        childTest = getTest().createNode(node);
    }

    public static ExtentTest getNode() {
        return childTest;
    }

    public static synchronized void endTest() {
        extent.flush();
    }

    public static synchronized ExtentTest startTest(String testName) {
        // Check Start test already existed, if not, create it
        if ((getTest() == null) || (!getTest().getModel().getName().equals(testName))) {
            ExtentTest test = extent.createTest(testName);
            extentTestMap.put((int) (Thread.currentThread().getId()), test);
            return test;
        }
        return getTest();
    }

    public static void addIntoExtentReport(ITestResult result, boolean createNode, Status status) {
        //Browser name
        String browser = System.getProperty("browser");

        //Generate Stack Trace string & Exception message
        String stackTrace = "";
        String exceptionMessage = "";
        if (status != Status.PASS && result.getThrowable() != null) {
//            for (StackTraceElement e : result.getThrowable().getStackTrace()) {
//                if (e.toString().contains("...")) {
//                    stackTrace = stackTrace + e.toString() + "</br>";
//                }
//            }
            stackTrace = "</br><b style='color: #FF0101;'>STACK TRACE: </b>" + stackTrace;
            exceptionMessage = result.getThrowable().getMessage();
        }

        //Generate color status
        String color = "#FF0101";
        if (status == Status.PASS) {
            color = "#44aa44";
        }

        // Extend Report - Start Test
        String[] classPath = result.getInstanceName().split("\\.");
        startTest(classPath[classPath.length - 1]);

        //Extend Report - Create a Node
        String description = result.getMethod().getDescription();
        if (createNode) {
            String nodeName = String.format("%s - %s", result.getName(), description);
            createNode(nodeName);
        }

        //Extend Report - Add status Pass, Fail, Skip
        if (status != null) {
            getNode().log(status, "<b style='color: " + color + ";'>" + status.toString().toUpperCase() + "</b> " + exceptionMessage + stackTrace);
        }
    }
}
