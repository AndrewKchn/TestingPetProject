package stepDefinitions.uiTests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import webDriverProvider.WebDriverFactory;

import java.time.Duration;

public class SetUpUi {

    private TestContextUI testContextUi;

    public SetUpUi(TestContextUI testContextUi) {
        this.testContextUi = testContextUi;
    }

    @Before
    public void setUpSuit(){
        // redirect System.out.println() to Logger
        System.out.println("SetUpUi @Before setUp()");
        WebDriver driver = WebDriverFactory.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        testContextUi.setDriver(driver);
    }

    @After
    public void terDown() {
        System.out.println("SetUpUi @After terDown()");
        testContextUi.getDriver().close();
        testContextUi.getDriver().quit();
    }
}
