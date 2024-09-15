package webDriverProvider;

import config.MavenProperties;
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
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-gpu");
                options.addArguments("--disable-extensions");
                options.addArguments("--no-sandbox");
                options.addArguments("--disable-dev-shm-usage");
//                options.addArguments("--headless"); //TODO: move to property file and setup
                options.addArguments("--start-maximized");
                yield new ChromeDriver(options);
            }
            case "edge" -> {
//                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
            default -> throw new IllegalStateException("Browser not found!");
        };
    }
}
