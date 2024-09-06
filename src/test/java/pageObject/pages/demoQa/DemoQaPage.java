package pageObject.pages.demoQa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.pages.BasePage;

public class DemoQaPage extends BasePage {

    By elements = new By.ByXPath("//*[text()='Elements']");

    public DemoQaPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/"); //todo: update to getting from config file
    }

    public ElementsPage elementsPage() {
        navigateToElement(elements).click();
        return new ElementsPage(driver);
    }
}
