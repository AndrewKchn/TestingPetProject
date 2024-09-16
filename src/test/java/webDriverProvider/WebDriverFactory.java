package webDriverProvider;

import config.MavenProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

    public WebDriverFactory() {
    }

    public static WebDriver getWebDriver() {
        String testingBrowser = MavenProperties.getTestingBrowser();
        return initDriver(testingBrowser);
    }

    private static WebDriver initDriver(String browser) {
        return switch (browser) {
            case "chrome" -> {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--headless"); //TODO: move to property file and setup
                options.addArguments("--start-maximized");
                yield WebDriverManager.chromedriver().capabilities(options).create();
//                yield new ChromeDriver(options);

            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                yield new FirefoxDriver();
            }
            default -> throw new IllegalStateException("Browser not found!");
        };
    }
}
