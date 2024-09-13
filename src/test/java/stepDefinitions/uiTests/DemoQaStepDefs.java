package stepDefinitions.uiTests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import pageObject.pages.demoQa.DynamicPropertiesPage;

public class DemoQaStepDefs {

    private WebElement visibleAfter = null;
    private WebElement enableAfter = null;
    private TestContextUI testContextUI;

    public DemoQaStepDefs(TestContextUI testContextUI) {
        this.testContextUI = testContextUI;
    }

    @Given("Open DemoQA Dynamic Properties page")
    public void openDemoQADynamicPropertiesPage() {
        DynamicPropertiesPage dynamicPropertiesPage = testContextUI.getMainDemoQaPage().elementsPage().dynamicPropertiesPage();
        testContextUI.setDynamicPropertiesPage(dynamicPropertiesPage);
    }

    @When("Click on button after 5 seconds")
    public void clickOnButtonAfterSeconds() {
        visibleAfter = testContextUI.getDynamicPropertiesPage().getVisibleAfter();
        visibleAfter.click();
    }

    @When("Click on button after enable after 5 seconds")
    public void clickOnButtonAfterEnableAfterSeconds() {
        enableAfter = testContextUI.getDynamicPropertiesPage().getEnableAfter();
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
