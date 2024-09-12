package webDriverProvider;

import config.MavenProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                yield new EdgeDriver();
            }
            default -> throw new IllegalStateException("Browser not found!");
        };
    }
}
