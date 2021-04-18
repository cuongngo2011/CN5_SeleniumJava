package utils.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentManager {
    public static ExtentReports extent;
    private static String fileNameWithoutExtension = "Test-Report-" + generateTimeStampString();
    private static String reportFileName = fileNameWithoutExtension + ".html";
    private static String fileSeperator = "\\";
    private static String reportFilepath = System.getProperty("user.dir") + fileSeperator + "output" + fileSeperator + System.getProperty("appName").toLowerCase() + "." + System.getProperty("suite").toLowerCase() + fileSeperator;
    private static String reportFileLocation = reportFilepath + reportFileName;

    public static ExtentReports getInstance() {
        if (extent == null)
            createInstance();
        return extent;
    }

    // Create an extent report instance
    public static ExtentReports createInstance() {
        String fileName = getReportPath(reportFilepath);
        System.setProperty("extentReportFileName", fileNameWithoutExtension);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(reportFileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(reportFileName);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        // Set environment details
        extent.setSystemInfo("OS", System.getProperty("OS"));
        extent.setSystemInfo("OS Version", System.getProperty("OSVersion"));
        extent.setSystemInfo("Browser", System.getProperty("Browser"));
        extent.setSystemInfo("QA", "LGG QA Team");

        return extent;
    }

    // Create the report path
    private static String getReportPath(String path) {
        File testDirectory = new File(path);
        if (!testDirectory.exists()) {
            if (testDirectory.mkdirs()) {
                System.out.println("Directory: " + path + " is created!");
                return reportFileLocation;
            } else {
                System.out.println("Failed to create directory: " + path);
                return System.getProperty("user.dir");
            }
        } else {
            System.out.println("Directory already exists: " + path);
        }
        return reportFileLocation;
    }

    public static String generateTimeStampString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");
        LocalDateTime now = LocalDateTime.now();
        String timestampStr = dtf.format(now);
        return timestampStr;
    }
}
