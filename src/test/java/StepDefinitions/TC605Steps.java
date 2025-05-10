package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Pages.ParentPage;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class TC605Steps {


    DialogContent dc = new DialogContent(GWD.getDriver());
    LeftNav ln = new LeftNav(GWD.getDriver());
    String targetAccount="";
    int sendedAmount=0;

    @Given("Navigate to Transfer Funds page")
    public void navigateToTransferFundsPage() {
        ln.myClick(ln.lnTransferFundsButton);
    }

    @Given("Enter transfer information and submit")
    public void enterTransferInformationAndSubmit () {
        sendedAmount=ParentPage.random(100);
        dc.mySendKeys(dc.amount,String.valueOf(sendedAmount));

        Select fromAccount = new Select(GWD.getDriver().findElement(By.id("fromAccountId")));
        dc.wait.until(driver -> fromAccount.getOptions().size() > 1);
        fromAccount.selectByIndex(0);

        Select toAccount = new Select(GWD.getDriver().findElement(By.id("toAccountId")));
        dc.wait.until(driver -> toAccount.getOptions().size() > 1);
        toAccount.selectByIndex(1);
        targetAccount=dc.selectedAccount.getText();
        dc.myClick(dc.transferButton);


    }


    @And("The user should be see the success message")
    public void theUserShouldBeSeeTheSuccessMessage() {
        dc.verifyMessageContainsText(dc.transferCompleteText,"complete");
    }

    @And("The user navigates to Accounts Overview page")
    public void theUserNavigatesToAccountsOverviewPage() {
        ln.myClick(ln.lnAccountsOverview);

    }

    @And("User confirms that the money transfer was successful")
    public void userConfirmsThatTheMoneyTransferWasSuccessful() {


        WebElement target = dc.wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='" + targetAccount + "']")));
        target.click();

        dc.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("transactionTable")));

        dc.wait.until(driver -> driver.findElements(By.xpath("//*[@id='transactionTable']//tbody//tr//a")).size() > 0);

        List<WebElement> transfers = GWD.getDriver().findElements(By.xpath("//*[@id='transactionTable']//tbody//tr//a"));

        if (transfers.isEmpty()) {
            Assert.fail("Transfer işlemi bulunamadı!");
        } else {
            WebElement lastTransfer = transfers.get(transfers.size() - 1);
            dc.wait.until(ExpectedConditions.elementToBeClickable(lastTransfer)).click();
        }

        dc.verifyMessageContainsText(dc.transterDetailsAmount,String.valueOf(sendedAmount));

    }
}
