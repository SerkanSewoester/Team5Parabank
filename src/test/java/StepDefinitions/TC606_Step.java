package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TC606_Step {
    LeftNav ln=new LeftNav(GWD.getDriver());
    DialogContent dc=new DialogContent(GWD.getDriver());

    @Given("Navigate to website ParaBank")
    public void navigateToWebsiteParaBank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }

    @When("Enter username and password")
    public void enterUsernameAndPassword() {
        ln.mySendKeys(ln.lnUsernameInput, "jackm123 ");
        ln.mySendKeys(ln.lnPasswordInput, "Team5.123");
        ln.myClick(ln.lnLoginButton);
    }

    @Then("should be login successfully")
    public void shouldBeLoginSuccessfully() {
        Assert.assertTrue(dc.LogInSuccessText.isDisplayed());
    }
////////////////////////////////////////////////////////////////
    @Given("Navigate to update contact info")
    public void navigateToUpdateContactInfo() {
        ln.myClick(ln.lnUpdateContactButton);
    }

    @When("User enters new valid data")
    public void userEntersNewValidData() {
        dc.mySendKeys(dc.ContactFirstName, "Jack ");
        dc.mySendKeys(dc.ContactLastName, "Harrison");
        dc.mySendKeys(dc.ContactAddress, "492 Elmwood Dr");
        dc.mySendKeys(dc.ContactCity, "San Diego");
        dc.mySendKeys(dc.ContactState, "CA");
        dc.mySendKeys(dc.ContactZipcode, "73301");
        dc.mySendKeys(dc.ContactPhone, "(512) 342-8989");
    }

    @And("User click on the update profile button")
    public void userClickOnTheUpdateProfileButton() {
        dc.myClick(dc.ContactUpdateButton);
    }

    @Then("User should be see the profile update message")
    public void userShouldBeSeeTheProfileUpdateMessage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.ContactUpdateProfile));
        Assert.assertTrue(dc.ContactUpdateProfile.isDisplayed(), "No visible message");
    }

    @When("User enters invalid data or empty profile field")
    public void userEntersInvalidDataOrEmptyProfileField() {
        dc.mySendKeys(dc.ContactFirstName, "Jack ");
        dc.mySendKeys(dc.ContactLastName, "");
        dc.mySendKeys(dc.ContactAddress, "492 Elmwood Dr");
        dc.mySendKeys(dc.ContactCity, "");
        dc.mySendKeys(dc.ContactState, "");
        dc.mySendKeys(dc.ContactZipcode, "73301");
        dc.mySendKeys(dc.ContactPhone, "(512) 342-8989");
    }

    @Then("User should be see the error message")
    public void userShouldBeSeeTheErrorMessage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.ContactErrorMessage));
        Assert.assertTrue(dc.ContactErrorMessage.isDisplayed(), "No visible message");

    }
}
