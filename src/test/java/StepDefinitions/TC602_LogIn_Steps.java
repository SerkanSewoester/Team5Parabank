package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC602_LogIn_Steps {

    DialogContent dc = new DialogContent(GWD.getDriver());

    @Given("Navigate to the website")
    public void navigateToTheWebsite() {
        GWD.getDriver().get("https://parabank.parasoft.com/");

    }

    @When("Enter valid username as {string} and password as {string}")
    public void enterValidUsernameAsAndPasswordAs(String username, String password) {

        dc.mySendKeys(dc.LogInUsername, username);
        dc.mySendKeys(dc.LogInPassword, password);
    }

    @When("Enter invalid username as {string} and password as {string}")
    public void enterInvalidUsernameAsAndPasswordAs(String username, String password) {

        dc.mySendKeys(dc.LogInUsername, username);
        dc.mySendKeys(dc.LogInPassword, password);
    }

    @And("Click on LoginOrSign Up button")
    public void clickOnLoginSignUpButton() {

        dc.myClick(dc.LogInButton);
    }

    @Then("SuccessMessage should be displayed")
    public void SuccessMessageShouldBeDisplayed() {
        GWD.getDriver();
        Assert.assertTrue(dc.LogInSuccessText.isDisplayed());
    }

    @Then("Error message should be displayed as {string}")
    public void errorMessageShouldBeDisplayedAs(String arg0) {
        dc.verifyMessageContainsText(dc.LogInErrorText,arg0);
    }
}
