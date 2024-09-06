package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.pages.demoQa.DemoQaPage;
import pageObject.pages.demoQa.DynamicPropertiesPage;

import java.time.Duration;

public class DemoQaStepDefs {
    WebDriver driver = null;
    DynamicPropertiesPage dynamicPropertiesPage = null;
    WebElement visibleAfter = null;
    WebElement enableAfter = null;

    @Before
    public void setUp() {
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
        WebDriverManager.chromedriver().setup(); // todo: implement driver factory using config
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @After
    public void terDown() {
        driver.close();
        driver.quit();
    }

    @Given("Open DemoQA Dynamic Properties page")
    public void openDemoQADynamicPropertiesPage() {
        DemoQaPage demoQaPage = new DemoQaPage(driver);
        dynamicPropertiesPage = demoQaPage.elementsPage().dynamicPropertiesPage();
    }

    @When("Click on button after 5 seconds")
    public void clickOnButtonAfterSeconds() {
        visibleAfter = dynamicPropertiesPage.getVisibleAfter();
        visibleAfter.click();
    }

    @When("Click on button after enable after 5 seconds")
    public void clickOnButtonAfterEnableAfterSeconds() {
        enableAfter = dynamicPropertiesPage.getEnableAfter();
        enableAfter.click();

    }

    @Then("Button is clickable")
    public void buttonIsClickable() {
        Assert.assertTrue(visibleAfter.isDisplayed());
        Assert.assertTrue(visibleAfter.isEnabled());
    }

    @Then("Enable after button is enable")
    public void enableAfterButtonIsEnable() {
        Assert.assertTrue("Button is not displayed", enableAfter.isDisplayed());
        Assert.assertTrue("Button is not enable", enableAfter.isEnabled());
    }
}
