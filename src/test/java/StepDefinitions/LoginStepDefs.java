package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDefs {
    @Given("user is on login page")
    public void userIsOnLoginPage() {
        System.out.println("User is on Login page");
    }

    @When("user enters username and password")
    public void userEntersUsernameAndPassword() {
        System.out.println("User enters name and password");
    }

    @And("clicks on login button")
    public void clicksOnLoginButton() {
        System.out.println("User clicks on login button");
    }

    @Then("user is navigated to homepage")
    public void userIsNavigatedToHomepage() {
        assert true;
    }


}
