package stepDefinitions.uiTests;

import io.cucumber.java.*;
import logs.LogOutputStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import webDriverProvider.WebDriverFactory;

import java.time.Duration;

public class Hook {

    private TestContextUI testContextUi;
    private WebDriver driver;
    private Scenario scn;
    private static final Logger LOGGER = LogManager.getLogger(Hook.class);

    public Hook(TestContextUI testContextUi) {
        this.testContextUi = testContextUi;
    }

    @BeforeAll
    public static void setUpEnv() {
        LOGGER.info("Hello from @BeforeAll");
    }

    @Before
    public static void setUpLogger() {
        LogOutputStream.redirectPrintsToLogger();
    }
    @AfterAll
    public static void afterAll() {
        LOGGER.info("Hello from @AfterAll");
    }

    @Before
    public void setUpSuit(Scenario scn) {
        this.scn = scn;
        LOGGER.info("@Before: setUp(): Driver");
        driver = WebDriverFactory.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        testContextUi.setDriver(driver);
    }

    @After
    public void terDown() {
        LOGGER.info("@After terDown() from logger");
        if (scn.isFailed()) {
            TakesScreenshot screenshot = (TakesScreenshot) driver;
            byte[] screenshotData = screenshot.getScreenshotAs(OutputType.BYTES);
            this.scn.attach(screenshotData, "image/png", "ScreenShot");
        }
//        testContextUi.getDriver().close();    //closes only the current window on which Selenium is running automated tests
        testContextUi.getDriver().quit();     // closes all browser windows and ends the WebDriver session
    }
}
