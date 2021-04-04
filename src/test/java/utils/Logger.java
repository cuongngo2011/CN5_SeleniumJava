package utils;

import org.apache.logging.log4j.LogManager;
import org.testng.Reporter;

public class Logger {
    private static org.apache.logging.log4j.Logger log = LogManager.getLogger(Logger.class);

    public static void info(String message) {
        Reporter.log("<b>INFO: </b>" + message);
        log.info(String.format("Thread #%s: %s", Thread.currentThread().getId(), message));

//        // Extent Report
//        if (ExtentManager.extent != null)
//            if (ExtentTestManager.getNode() != null)
//                ExtentTestManager.getNode().log(Status.INFO, message);
    }

    public static void error(String message, Exception exception) {
        Reporter.log("<b>ERROR: </b>" + message);
        log.error(String.format("Thread #%s: %s", Thread.currentThread().getId(), message), exception);

//        // Extent Report
//        if (ExtentManager.extent != null)
//            if (ExtentTestManager.getNode() != null)
//                ExtentTestManager.getNode().log(Status.ERROR, message + " Exception: " + exception.toString());
    }
}
