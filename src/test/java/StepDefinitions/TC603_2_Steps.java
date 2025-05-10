package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.FakerUtil;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TC603_2_Steps {
    LeftNav ln = new LeftNav(GWD.getDriver());
    DialogContent dc = new DialogContent(GWD.getDriver());
    @Given("The user navigates to the Bill Pay page")
    public void theUserNavigatesToTheBillPayPage() {
        ln.myClick(ln.lnBillPayButton);
    }

    @When("The user enters the following water bill details")
    public void theUserEntersTheFollowingWaterBillDetails(DataTable inputFieldsAndValues) {
        List<List<String>> inputFieldAndText = inputFieldsAndValues.asLists();
        for (int i = 0; i < inputFieldAndText.size(); i++) {
            dc.mySendKeys(dc.getWebElement(inputFieldAndText.get(i).get(0)),
                    inputFieldAndText.get(i).get(1));
        }
    }

    @And("The user confirms the payment")
    public void theUserConfirmsThePayment() {
        dc.myClick(dc.billPayeeSendPaymentButton);
    }

    @Then("A successful payment message and amount should be displayed")
    public void aSuccessfulPaymentMessageAndAmountShouldBeDisplayed() {
        dc.verifyMessageContainsText(dc.billPaymentCompleteText,"complete");
    }

    @And("The user should see the {string}, {string}, in the transaction details")
    public void theUserShouldSeeTheInTheTransactionDetails(String payeeName, String amount) {
        dc.verifyMessageContainsText(dc.billPayedName,payeeName);
        dc.verifyMessageContainsText(dc.billPayedAmount,amount);

    }

    @And("The user should verify that the account balance is updated in the account overview")
    public void theUserShouldVerifyThatTheAccountBalanceIsUpdatedInTheAccountOverview() {
        ln.myClick(ln.lnAccountsOverview);
        dc.myClick(dc.accountOverviewNumber);
        dc.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//*[contains(text(),'Faturasi')]"),1));
        List<WebElement> transactionBillName = GWD.getDriver().findElements(By.xpath("//*[contains(text(),'Faturasi')]"));
        System.out.println(transactionBillName.size());
        WebElement lastElement = transactionBillName.get(transactionBillName.size() - 1);
        dc.wait.until(ExpectedConditions.elementToBeClickable(lastElement)).click();
    }

    @And("The user should see the payment listed in the transaction history")
    public void theUserShouldSeeThePaymentListedInTheTransactionHistory() {
        Assert.assertTrue(dc.transterDetailsDate.isDisplayed());
        Assert.assertTrue(dc.transterDetailsDescription.isDisplayed());
        Assert.assertTrue(dc.transterDetailsAmount.isDisplayed());
    }
}
