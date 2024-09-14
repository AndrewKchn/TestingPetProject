package webDriverProvider;

import config.MavenProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;

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
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--headless"); //TODO: move to property file and setup
                yield WebDriverManager.chromedriver().capabilities(chromeOptions).create();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
            default -> throw new IllegalStateException("Browser not found!");
        };
    }
}
