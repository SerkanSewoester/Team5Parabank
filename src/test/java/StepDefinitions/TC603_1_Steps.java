package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class TC603_1_Steps {
    DialogContent dc = new DialogContent(GWD.getDriver());
    LeftNav ln = new LeftNav(GWD.getDriver());


    @Given("The user navigates to the ParaBank website")
    public void theUserNavigatesToTheParaBankWebsite() {
        GWD.getDriver().get("https://parabank.parasoft.com");
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("https://parabank.parasoft.com/"));
    }

    @When("The user types username and password and clicks on the login button")
    public void theUserTypesUsernameAndPasswordAndClicksOnTheLoginButton() throws InterruptedException {
        ln.mySendKeys(ln.lnUsernameInput, "jackm123");
        ln.mySendKeys(ln.lnPasswordInput, "Team5.123");
        ln.myClick(ln.lnLoginButton);
        Thread.sleep(2000);
    }

    @Then("The user clicks on the Bill Pay Button")
    public void theUserClicksOnTheBillPayButton() {
        ln.myClick(ln.lnBillPayButton);
    }

    @And("The user types the name in the Payee Name box")
    public void theUserTypesTheNameInPayeeNameBox() {
        dc.mySendKeys(dc.billPayeeNameInput, "Elektrik Faturası Ödeme");
        dc.mySendKeys(dc.pillPayeeAddressInput, "Vatikan sokak 13.Cadde");
        dc.mySendKeys(dc.billPayeeCityInput, "İstanbul");
        dc.mySendKeys(dc.billPayeeStateInput, "Beylikdüzü");
        dc.mySendKeys(dc.billPayeeZipCodeInput, "99152");
        dc.mySendKeys(dc.billPayeePhoneNumberInput, "619 999 87 99");
    }

    @When("The user fills in the Billing Information for the Electricity Bill")
    public void theUserFillsInTheBillingInformationForTheElectricityBill() {
        dc.mySendKeys(dc.billPayeeAccountInput, "49874521");
        dc.mySendKeys(dc.billPayeeVerifyAccountInput, "49874521");
        dc.mySendKeys(dc.billPayeeAmountInput, "32");
        dc.myClick(dc.billPayeeSendPaymentButton);
    }

    @Then("The user should see the successful pay message")
    public void theUserShouldSeeTheSuccessfulPayMessage() {
        dc.verifyMessageContainsText(dc.billPaymentCompleteText, "Bill Payment Complete");
         Assert.assertTrue(dc.billPaymentCompleteText.isDisplayed(), "No successful payment message appears");
    }

    @And("The user clicks on the Accounts Overview and account number")
    public void theUserClicksOnTheAccountsOverviewAndAcoountNumber() {
        ln.myClick(ln.lnAccountsOverview);
        dc.myClick(dc.accountOverviewNumber);
        dc.myClick(dc.clickBillPaymentButtonInAccountsOverview);
    }

    @Then("The user sees the transaction details and verifies that the information is correct")
    public void theUserSeesTheTransactionDetailsAndVerifiesThatTheInformationIsCorrect()
    {
        Assert.assertTrue(dc.verifyDate.isDisplayed(), "Date verification failed");
        Assert.assertFalse(dc.verifyDate.getText().isEmpty(), "Tarih alanı boş");
        Assert.assertTrue(dc.verifyDate.getText().matches("\\d{2}-\\d{2}-\\d{4}"), "Tarih formatı uygun değil");
        Assert.assertTrue(dc.verifyBillName.getText().toLowerCase().contains("elektrik"));
        Assert.assertTrue(dc.verifyAmount.getText().contains("$32,00"));

    }
}
