package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TC604Steps {
    LeftNav ln=new LeftNav(GWD.getDriver());
    DialogContent dc=new DialogContent(GWD.getDriver());
    String accountNumber="";

    @Given("Navigate to open new account page")
    public void navigateToOpenNewAccountPage() {
        ln.myClick(ln.openNewAccountButton);
    }

    @When("Click user selects new account type as {string}")
    public void clickUserSelectsNewAccountTypeAs(String accountType) throws InterruptedException {
        Thread.sleep(2000);
            new Select(dc.accountTypeSelect).selectByVisibleText(accountType);
        Thread.sleep(2000);

    }

    @And("User clicks open new account button")
    public void userClicksOpenNewAccountButton() {
        dc.myClick(dc.openNewAccountLogin);
    }

    @And("User can see success message")
    public void userCanSeeSuccessMessage() {
        dc.verifyMessageContainsText(dc.assertAccountText,"congratulations, your account is now open.");
        accountNumber=dc.accountNumberClick.getText();

    }

    @And("User clicks on new account number")
    public void userClicksOnNewAccountNumber() {
        dc.myClick(dc.accountNumberClick);
    }

    @Then("The user must be able to verify the account number and type he has opened.")
    public void theUserMustBeAbleToVerifyTheAccountNumberAndTypeHeHasOpened() {
        dc.verifyMessageContainsText(dc.newAccountTypeAssert,"CHECKING");
        dc.verifyMessageContainsText(dc.newAccountNumberAssert,accountNumber);
    }
}
