package managers;

import enums.DriverType;
import enums.EnvironmentType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverManager {
    private WebDriver driver;
    private static DriverType driverType;
    private static EnvironmentType environmentType;
    private static final String CHROME_DRIVER_PROPERTY = "webdriver.chrome.driver";

    public WebDriverManager() {
        driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
        environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
    }

    public WebDriver getDriver() throws MalformedURLException {
        if (driver == null)
            driver = createDriver();
        return driver;
    }

    private WebDriver createDriver() throws MalformedURLException {
        switch (environmentType) {
            case LOCAL:
                driver = createLocalDriver();
                break;
            case REMOTE:
                driver = createRemoteDriver();
                break;
            case ANDROID:
                driver = createAndroidDriver();
                break;

        }
        return driver;
    }

    private WebDriver createAndroidDriver() throws MalformedURLException {
        RemoteWebDriver driver;
        DesiredCapabilities capabilities;
        System.out.println("Starting Appium Tests");
        capabilities = new DesiredCapabilities();
        capabilities.setPlatform(Platform.ANDROID);
        capabilities.setCapability("deviceName", "Nexus_9_API_27");
//        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("udid", "05157df59b39d131");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.0");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("clearSystemFiles", "true");
        return driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    }

    private WebDriver createRemoteDriver() throws MalformedURLException {
        String USERNAME = "natarajankrishna1";
        String AUTOMATE_KEY = "9AKxJyCyDatMzUimdqRd";
        String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "7");
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "65.0");
        caps.setCapability("resolution", "1920x1080");
                caps.setCapability("browserstack.selenium_version", "3.10.0");
        caps.setCapability("project", "CucumberTests");
        caps.setCapability("browserstack.local", "true");
        caps.setCapability("browserstack.debug", "true");
           caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, "true");
        // driver = new RemoteWebDriver(new URL(URL), caps);
        System.out.println("Called openBrowser");
//        driver.manage().window().maximize();
        return new RemoteWebDriver(new URL(URL), caps);

    }

    private WebDriver createLocalDriver() {
        switch (driverType) {
            case FIREFOX:
                driver = new FirefoxDriver();
                break;
            case CHROME:
                System.setProperty(CHROME_DRIVER_PROPERTY, FileReaderManager.getInstance().getConfigReader().getDriverPath());
//        	ChromeOptions options = new ChromeOptions();
//        	options.addArguments("headless");
//        	options.addArguments("window-size=1920x1080");
                driver = new ChromeDriver();
                break;
            case INTERNETEXPLORER:
                driver = new InternetExplorerDriver();
                break;
        }

        if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
            driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        return driver;
    }

    public void closeDriver() {
        driver.close();
        driver.quit();
    }

}
