package driver;

import common.Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class DriverManager {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public void createDriver(Constants.BROWSER browser, Constants.RUN_MODE mode) throws Exception {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        List<String> args = new ArrayList<String>();
        switch (mode) {
            case LOCAL:
                    switch (browser){
                        case CHROME:
                            WebDriverManager.chromedriver().setup();
                            ChromeOptions chromeOptions = new ChromeOptions();
                            chromeOptions.merge(capabilities);
                            chromeOptions.addArguments(args);
                            this.driver = new ChromeDriver(chromeOptions);
                            break;
                        case FIREFOX:
                            WebDriverManager.firefoxdriver().setup();
                            FirefoxOptions firefoxOptions = new FirefoxOptions();
                            firefoxOptions.merge(capabilities);
                            firefoxOptions.addArguments(args);
                            this.driver = new FirefoxDriver(firefoxOptions);
                            break;
                            default:
                                throw new Exception("No specific browser is selected");
                    }
                break;
            case REMOTE:
                switch (browser){
                    case CHROME:
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions chromeOptions = new ChromeOptions();
                        capabilities.setCapability("platform", "Windows 10");
                        capabilities.setBrowserName("chrome");
//                        args.add("--headless");
                        chromeOptions.merge(capabilities);
                        chromeOptions.addArguments(args);
                        this.driver = new RemoteWebDriver(new URL(Constants.URL.SAUCELABS), chromeOptions);
                        break;
                    case FIREFOX:
                        WebDriverManager.firefoxdriver().setup();
                        FirefoxOptions firefoxOptions = new FirefoxOptions();
                        capabilities.setCapability("platform", "Windows 10");
                        capabilities.setCapability("browserName", "firefox");
//                            args.add("--headless");
                        firefoxOptions.merge(capabilities);
                        firefoxOptions.addArguments(args);
                        this.driver = new RemoteWebDriver(new URL(Constants.URL.SAUCELABS), firefoxOptions);
                        break;
                    default:
                        throw new Exception("No specific browser is selected");
                }
                break;
                default:
                    throw new Exception("No specific run mode is selected");
        }
    }
}
