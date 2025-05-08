package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.FakerUtil;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC603_2_Steps {
    LeftNav ln = new LeftNav(GWD.getDriver());
    DialogContent dc = new DialogContent(GWD.getDriver());
    @Given("the user is logged into the Para Bank website")
    public void theUserIsLoggedIntoTheParaBankWebsite() throws InterruptedException {
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        ln.mySendKeys(ln.lnUsernameInput,"annad456");
        ln.mySendKeys(ln.lnPasswordInput,"anna456");
        ln.myClick(ln.lnLoginButton);
        Thread.sleep(5000);
    }

    @When("the user navigates to the Bill Pay page")
    public void theUserNavigatesToTheBillPayPage() {
        ln.myClick(ln.lnBillPayButton);
    }

    @And("the user fills in the water bill form with valid random data")
    public void theUserFillsInTheWaterBillFormWithValidRandomData() {
        dc.mySendKeys(dc.payeName,"İski Su Faturasi");
        dc.mySendKeys(dc.payeAddressStreet, FakerUtil.getAddress());
        dc.mySendKeys(dc.payeAddressCity,FakerUtil.getCity());
        dc.mySendKeys(dc.payeAddressState,FakerUtil.getState());
        dc.mySendKeys(dc.payeAddressZipCode,FakerUtil.getZipCode());
        dc.mySendKeys(dc.payePhoneNumber,FakerUtil.getPhoneNumber());
        dc.mySendKeys(dc.payeAccountNumber,"12345");
        dc.mySendKeys(dc.verifyAccount,"12345");
        dc.mySendKeys(dc.amountOdenecekTutar,"1");
    }

    @And("the user submits the payment")
    public void theUserSubmitsThePayment() {
        dc.myClick(dc.buttonSendPayment);
    }

    @Then("the payment confirmation should display the correct amount and account number")
    public void thePaymentConfirmationShouldDisplayTheCorrectAmountAndAccountNumber() throws InterruptedException {
        ln.myClick(ln.lnAccountsOverview);
        dc.myClick(dc.Account);
        Thread.sleep(5000);
        dc.myClick(dc.successfulMessageBillPaymentToGasBill.get(dc.successfulMessageBillPaymentToGasBill.size()-1));
        /*
        Sadece Transaction Details bolumundeki assertler yapilmadi.!
         */
    }
}
