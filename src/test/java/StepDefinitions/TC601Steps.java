package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

public class TC601Steps {
    LeftNav ln=new LeftNav(GWD.getDriver());
    DialogContent dc=new DialogContent(GWD.getDriver());

    @Given("Navigate to website")
    public void navigateToWebsite() {
        GWD.getDriver().get("https://parabank.parasoft.com/");
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains("https://parabank.parasoft.com/"));

    }

    @And("Click the register button")
    public void clickTheRegisterButton() {
        ln.lnRegisterButton.click();
        Assert.assertTrue(ln.lnRegisterButton.isEnabled(),"Register butonuna tıklanmadı.");
    }



    @And("User sending name,address,and other details in sign up")
    public void userSendingNameAddressAndOtherDetailsInSignUp(DataTable dataTable) {

        List<List<String>>itemList=dataTable.asLists(String.class);

        for (int i = 0; i < itemList.size(); i++) {

            WebElement element=dc.getWebElement(itemList.get(i).get(0));
            dc.mySendKeys(element,itemList.get(i).get(1));

        }

    }


    @And("Click the register button in the registration")
    public void clickTheRegisterButtonInTheRegistration() {
        Assert.assertTrue(dc.registerButton2.isEnabled(),"Register butonuna tıklanmadı");
        dc.myClick(dc.registerButton2);
    }

    @Then("Verify that user logged in")
    public void verifyThatUserLoggedIn() {
        dc.verifyMessageContainsText(dc.verifyMessage, "successfully");
        Assert.assertTrue(dc.verifyMessage.isDisplayed(),"Giriş yapılamadı.");
    }
}
