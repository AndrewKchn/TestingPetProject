package stepDefinitions.uiTests;

import org.openqa.selenium.WebDriver;
import pageObject.pages.demoQa.DynamicPropertiesPage;
import pageObject.pages.demoQa.MainDemoQaPage;

public class TestContextUI {

    private WebDriver driver;
    private MainDemoQaPage demoQaPage;
    private DynamicPropertiesPage dynamicPropertiesPage;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public MainDemoQaPage getMainDemoQaPage() {
        return new MainDemoQaPage(driver);
    }

    public DynamicPropertiesPage getDynamicPropertiesPage() {
        return dynamicPropertiesPage;
    }

    public void setDynamicPropertiesPage(DynamicPropertiesPage dynamicPropertiesPage) {
        this.dynamicPropertiesPage = dynamicPropertiesPage;
    }
}
