package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.FakerUtil;
import Utilities.GWD;
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
    String accountNumber = "";
    String payingAmount = "";

    @When("the user navigates to the Bill Pay page")
    public void theUserNavigatesToTheBillPayPage() {
        ln.myClick(ln.lnBillPayButton);
    }

    @And("the user fills in the water bill form with valid random data")
    public void theUserFillsInTheWaterBillFormWithValidRandomData() {
        dc.mySendKeys(dc.payeName, "İski Su Faturasi");
        dc.mySendKeys(dc.payeAddressStreet, FakerUtil.getAddress());
        dc.mySendKeys(dc.payeAddressCity, FakerUtil.getCity());
        dc.mySendKeys(dc.payeAddressState, FakerUtil.getState());
        dc.mySendKeys(dc.payeAddressZipCode, FakerUtil.getZipCode());
        dc.mySendKeys(dc.payePhoneNumber, FakerUtil.getPhoneNumber());
        dc.mySendKeys(dc.payeAccountNumber, "12345");
        dc.mySendKeys(dc.verifyAccount, "12345");
        dc.mySendKeys(dc.amountOdenecekTutar, "45");
        accountNumber = dc.senderAccountSelector.getText();
    }

    @And("the user submits the payment")
    public void theUserSubmitsThePayment() {
        dc.myClick(dc.buttonSendPayment);
    }

    @Then("the payment confirmation should display the correct amount and account number")
    public void thePaymentConfirmationShouldDisplayTheCorrectAmountAndAccountNumber() {
        ln.myClick(ln.lnAccountsOverview);
        dc.myClick(dc.Account);
        WebElement a = dc.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='transactionTable']//a")));
        a.click();

        dc.wait.until(ExpectedConditions.visibilityOf(dc.transactionDate));
        String actualDate = dc.transactionDate.getText();

        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MM-dd-yyyy"));
        Assert.assertEquals(actualDate, expectedDate, "Tarih beklenenden farklı!");

        Assert.assertTrue(dc.transactionDescription.getText().contains("Bill Payment to İski Su Faturasi"));

        Assert.assertTrue(dc.transactionAmount.getText().contains("$45"));

    }
}
