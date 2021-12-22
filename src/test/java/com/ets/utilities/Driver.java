package com.ets.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Driver {
    private Driver() {
    }

    private static WebDriver driver;
    public static String hubURL = "http://svqlknxtgweb01.servers.global.prv:4444/wd/hub";
    public static WebDriver getDriver() {
        //browser type can come from properties file or command line
        if (driver == null) {
String browser=ConfigurationReader.getProperty("browser");
            // if the System.getProperty("browser") is not null then the browser is equal to System.getProperty("browser")
            // if the System.getProperty("browser") is null then the browser is equal to ConfigurationReader.getProperty("browser")
//            String browser = System.getProperty("browser")
//                    != null ? System.getProperty("browser") : ConfigurationReader.getProperty("browser");
            switch (browser) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    MutableCapabilities capabilities;
                    ArrayList<String> arguments = new ArrayList<String>();
                    arguments.add("test-type");
                    arguments.add("start-maximized");
                    ChromeOptions caps = new ChromeOptions();
                    caps.setExperimentalOption("w3c", false);
                    caps.addArguments(arguments);
                    capabilities = caps;
                    if (ConfigurationReader.getProperty("remote").contains("true")) {
                        try {
                            driver = new RemoteWebDriver(new URL(hubURL), capabilities);
                            break;
                        } catch (MalformedURLException e) {
                            throw new RuntimeException(e);
                        } catch (WebDriverException driverException) {
                            System.out.println("WebDriverException: " + driverException);
                            System.out.println("======= Remote Driver failed to start on Node.  Trying again... =======");
                            try {
                                driver = new RemoteWebDriver(new URL(hubURL), capabilities);
                            } catch (MalformedURLException me) {
                                throw new RuntimeException(me);
                            }
                        }
                    }else if(ConfigurationReader.getProperty("headlessBrowser").contains("true")){
                        WebDriverManager.chromedriver().setup();
                        ChromeOptions options=new ChromeOptions();
                        options.addArguments("headless");
                        options.addArguments("window-size=1200x600");
                        driver=new ChromeDriver(options);
                        break;
                    }else {
                        WebDriverManager.chromedriver().setup();
//                        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
                        driver = new ChromeDriver();
                        break;
                    }
                case "ie":
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver=new EdgeDriver();
                    break;
            }
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }


}
