package pageObject.pages.demoQa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageObject.pages.BasePage;

public class DynamicPropertiesPage extends BasePage {
    By visibleAfter = new By.ById("visibleAfter");
    By colorChange = new By.ById("colorChange");

    By enableAfter = new By.ById("enableAfter");

    public DynamicPropertiesPage(WebDriver driver) {
        super(driver);
    }

    public WebElement getVisibleAfter() {
        return navigateToElement(visibleAfter);
    }

    public WebElement getEnableAfter() {
        return navigateToElement(enableAfter);
    }
}
