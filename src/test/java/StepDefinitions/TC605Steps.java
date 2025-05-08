package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC605Steps {


    DialogContent dc = new DialogContent(GWD.getDriver());
    LeftNav ln = new LeftNav(GWD.getDriver());




    @Given("Navigate to ParaBank")
    public void navigateToParaBank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
    }

    @When("Enter username and password and click login button")
    public void enterUsernameAndPasswordAndClickLoginButton() {

        dc.mySendKeys(dc.userNameLogin,"murat123");
        dc.mySendKeys(dc.passwordLogin,"pass1243");
        dc.myClick(dc.loginButton);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
    }


    @Given("enter transfer information and submit")
    public void enterTransferInformationAndSubmit () {

        dc.mySendKeys(dc.amount, ParentPage.random(100));
        dc.selectByIndex(dc.senderAccountSelector, 1);
        dc.selectByIndex(dc.recipientAccountSelector, 1);
        dc.myClick(dc.transferButton);

    }
}
