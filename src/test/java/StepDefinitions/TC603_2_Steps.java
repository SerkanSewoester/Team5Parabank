package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TC603_2_Steps {
    LeftNav ln = new LeftNav();
    DialogContent dc = new DialogContent();
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
        dc.mySendKeys(dc.billPayeeName,"İski Su Faturasi");
        dc.mySendKeys(dc.billPayeeAddress,FakerUtil.getAddress());
        dc.mySendKeys(dc.billPayeeCity,FakerUtil.getCity());
        dc.mySendKeys(dc.billPayeeState,FakerUtil.getState());
        dc.mySendKeys(dc.billPayeeZipCode,FakerUtil.getZipCode());
        dc.mySendKeys(dc.billPayeePhoneNumber,FakerUtil.getPhoneNumber());
        dc.mySendKeys(dc.billPayeeAccountNumber,"12345");
        dc.mySendKeys(dc.billPayeeVerifyAccountNumber,"12345");
        dc.mySendKeys(dc.billPayeeAmount,"1");
    }

    @And("the user submits the payment")
    public void theUserSubmitsThePayment() {
        dc.myClick(dc.sendPaymentButton);
    }

    @Then("the payment confirmation should display the correct amount and account number")
    public void thePaymentConfirmationShouldDisplayTheCorrectAmountAndAccountNumber() throws InterruptedException {
        ln.myClick(ln.lnAccountsOverview);
        dc.myClick(dc.account);
        Thread.sleep(5000);
        dc.myClick(dc.paymentButtons.get(dc.paymentButtons.size()-1));
        /*
        Sadece Transaction Details bolumundeki assertler yapilmadi.!
         */
    }
}
