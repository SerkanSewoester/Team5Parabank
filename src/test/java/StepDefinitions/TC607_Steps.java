package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TC607_Steps {
    LeftNav ln = new LeftNav(GWD.getDriver());
    DialogContent dc = new DialogContent(GWD.getDriver());
    @Given("The user navigates to the Request Loan page")
    public void theUserNavigatesToTheRequestLoanPage() {
        ln.myClick(ln.lnRequestLoan);
    }

    @And("The user apply the loan")
    public void theUserApplyTheLoan() {
        dc.myClick(dc.applyNowButton);
    }

    @Then("The user should see the Loan Request Result")
    public void theUserShouldSeeTheLoanRequestResult() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.loanRequestResult));
        Assert.assertTrue(dc.loanRequestResult.isDisplayed());
    }

    @And("The user navigates to Account Details page")
    public void theUserNavigatesToAccountDetailsPage() {
        dc.myClick(dc.loanNewAccountNumber);
    }




    @And("The user should see the Account Type and Balance as {string}")
    public void theUserShouldSeeTheAccountTypeAndBalanceAs(String balance) {
        dc.wait.until(ExpectedConditions.textToBe(By.xpath("//*[@id='accountType']"),"LOAN"));
        Assert.assertTrue(dc.loanAccountType.getText().contains("LOAN"));
        dc.verifyMessageContainsText(dc.balance,balance);
        Assert.assertTrue(dc.noTransactionsFountText.isDisplayed());
    }
}
