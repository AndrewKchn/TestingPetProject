package pageObject.pages.demoQa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.pages.BasePage;

public class ElementsPage extends BasePage {

    By dynamicProperties = new By.ByXPath("//span[text()='Dynamic Properties']");

    public ElementsPage(WebDriver driver) {
        super(driver);
    }

    public DynamicPropertiesPage dynamicPropertiesPage() {
        navigateToElement(dynamicProperties).click();
        return new DynamicPropertiesPage(driver);
    }
}
