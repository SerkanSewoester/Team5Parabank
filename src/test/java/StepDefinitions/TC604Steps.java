package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class TC604Steps {
    LeftNav ln = new LeftNav(GWD.getDriver());
    DialogContent dc = new DialogContent(GWD.getDriver());
    String accountNumber = "";

    @Given("Navigate to open new account page")
    public void navigateToOpenNewAccountPage() {
        ln.myClick(ln.openNewAccountButton);
    }

    @When("Click user selects new account type as {string}")
    public void clickUserSelectsNewAccountTypeAs(String accountType) {
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.accountTypeSelect));
        dc.myClick(dc.accountTypeSelect);
        Select select = new Select(dc.accountTypeSelect);
        select.selectByVisibleText(accountType);
    }

    @And("User clicks open new account button")
    public void userClicksOpenNewAccountButton() {
        dc.myClick(dc.openNewAccountLogin);
    }

    @And("User can see success message")
    public void userCanSeeSuccessMessage() {
        dc.verifyMessageContainsText(dc.assertAccountText, "congratulations, your account is now open.");
        accountNumber = dc.accountNumberClick.getText();
    }

    @And("User clicks on new account number")
    public void userClicksOnNewAccountNumber() {
        dc.myClick(dc.accountNumberClick);
    }


    @Then("The user must be able to verify the account number and {string} he has opened.")
    public void theUserMustBeAbleToVerifyTheAccountNumberAndHeHasOpened(String accountType) {
        dc.wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        Assert.assertTrue(dc.newAccountTypeAssert.isDisplayed());

    }
}
