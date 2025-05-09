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



public class _US603_3_BillPaymentSteps {

    LeftNav ln=new LeftNav(GWD.getDriver());
    DialogContent dc=new DialogContent(GWD.getDriver());

    @Given("Navigate to ParaBank")
    public void navigateToParaBank() {
        GWD.getDriver().get("https://parabank.parasoft.com/");

    }

    @When("Enter username and password and click login button")
  public void enterUsernameAndPasswordAndClickLoginButton() {
      ln.mySendKeys(ln.lnUsernameInput,"jackm123");
      ln.mySendKeys(ln.lnPasswordInput,"Team5.123");
      ln.myClick(ln.lnLoginButton);
//         ln.myClick(ln.registerButtonn);
//        ln.mySendKeys(ln.firstName,"Campus");
//        ln.mySendKeys(ln.lastName,"Techny");
//        ln.mySendKeys(ln.addressStreet,"Turkey");
//        ln.mySendKeys(ln.addressCity,"İstanbul");

//        ln.mySendKeys(ln.addressState,"Avcılar");
//        ln.mySendKeys(ln.zipCode,"675");
//        ln.mySendKeys(ln.phoneNumber,"6783563355");
//        ln.mySendKeys(ln.customerSsn,"Team5");
//        ln.mySendKeys(ln.customerUsername,"campusiimmm");
//        ln.mySendKeys(ln.customerPassword,"Team5");
//        ln.mySendKeys(ln.confirmPassword,"Team5");
//        ln.myClick(ln.registerBtn);

        ln.myClick(ln.lnBillPayButton);

        dc.mySendKeys(dc.payeName,"gas bill");
        dc.mySendKeys(dc.payeAddressStreet,"Turkey");
        dc.mySendKeys(dc.payeAddressCity,"İstanbul");
        dc.mySendKeys(dc. payeAddressState,"Avcılar");
        dc.mySendKeys(dc.payeAddressZipCode,"675");
        dc.mySendKeys(dc.payePhoneNumber,"6783563355");
        dc.mySendKeys(dc.payeAccountNumber,"23324");
        dc.mySendKeys(dc.verifyAccount,"23324");
        dc.mySendKeys(dc.amountOdenecekTutar,"1000");
        dc.myClick(dc.buttonSendPayment);

        ln.myClick(ln.lnAccountsOverview);
        GWD.getDriver().get("https://parabank.parasoft.com/parabank/activity.htm?id=21558");

        dc.myClick(dc.Account);
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {

    }

    @Given("Navigate to Bill Pay")
    public void navigateToBillPay() {
    }

    @When("Enter credentials and click Send Payment")
    public void enterCredentialsAndClickSendPayment() {
    }

    @Then("User completed the bill payment successfully")
    public void userCompletedTheBillPaymentSuccessfully() {
        dc.wait.until(ExpectedConditions.textToBePresentInElement(dc.successfulMessageBillPaymentComplate,"Bill Payment to gas bill in the amount of $1000.00"));
        Assert.assertTrue(dc.successfulMessageBillPaymentComplate.getText().equals("Bill Payment to gas bill in the amount of $1000.00"));
    }

    @And("User see payment details click Accounts Overview")
    public void userSeePaymentDetailsClickAccountsOverview() {


        dc.wait.until(ExpectedConditions.textToBePresentInElement(dc.historyDatee, "05-05-2025"));
        Assert.assertTrue(dc.historyDatee.getText().equals("05-05-2025"));

    }

    @And("User see payment details click Accounts Overview amount")
    public void userSeePaymentDetailsClickAccountsOverviewAmount() {
    }
}
