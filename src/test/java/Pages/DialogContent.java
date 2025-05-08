package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DialogContent extends ParentPage{

    public DialogContent(WebDriver driver) {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='payee.name']")
    public WebElement payeName;

    @FindBy(xpath = "//input[@name='payee.address.street']")
    public WebElement payeAddressStreet;

    @FindBy(xpath = "//input[@name='payee.address.city']")
    public WebElement payeAddressCity;

    @FindBy(xpath = "//input[@name='payee.address.state']")
    public WebElement payeAddressState;

    @FindBy(xpath = "//input[@name='payee.address.zipCode']")
    public WebElement payeAddressZipCode;

    @FindBy(xpath = "//input[@name='payee.phoneNumber']")
    public WebElement payePhoneNumber;

    @FindBy(xpath = "//input[@name='payee.accountNumber']")
    public WebElement payeAccountNumber;

    @FindBy(xpath = "//input[@name='verifyAccount']")
    public WebElement verifyAccount;

    @FindBy(xpath = "//input[@name='amount']")
    public WebElement amountOdenecekTutar;

    @FindBy(xpath = "//input[@value='Send Payment']")
    public WebElement buttonSendPayment;

    @FindBy(xpath = "//*[text()='Bill Payment Complete']")
    public WebElement successfulMessageBillPaymentComplate;

    @FindBy(xpath = "//*[@id='accountTable']//tbody//a")
    public WebElement Account;

    @FindBy(xpath = "//*[@id='transactionTable']//a")
    public List<WebElement> successfulMessageBillPaymentToGasBill;

    @FindBy(xpath = "//*[text()='05-05-2025']")
    public WebElement historyDatee;

    @FindBy(id = "customer.firstName")
    public WebElement firstName;

    @FindBy(id = "customer.lastName")
    public WebElement lastName;

    @FindBy(id = "customer.address.street")
    public WebElement Address;

    @FindBy(id = "customer.address.city")
    public WebElement City;

    @FindBy(id = "customer.address.state")
    public WebElement State;

    @FindBy(id = "customer.address.zipCode")
    public WebElement ZipCode;

    @FindBy(id = "customer.phoneNumber")
    public WebElement Phone;

    @FindBy(id = "customer.ssn")
    public WebElement SSN;

    @FindBy(id = "customer.username")
    public WebElement UserName;

    @FindBy(id = "customer.password")
    public WebElement Password;

    @FindBy(id = "repeatedPassword")
    public WebElement Confirm;

    @FindBy(xpath = "//input[@class='button' and @value='Register']")
    public WebElement registerButton2;

    @FindBy(xpath = "//*[contains(text(),'successfully')]")
    public WebElement verifyMessage;

    @FindBy(xpath = "//select[@id='type']")
    public WebElement accountTypeSelect;

    @FindBy(xpath = "//*[text()='SAVINGS']")
    public WebElement savingSelect;

    @FindBy(xpath = "//input[@value='Open New Account']")
    public WebElement openNewAccountLogin;

    @FindBy(xpath = "//p[text()='Congratulations, your account is now open.']")
    public WebElement assertAccountText;

    @FindBy(xpath = "//*[@id='newAccountId']")
    public WebElement accountNumberClick;

    @FindBy(xpath = "//*[@id='accountId']")
    public WebElement newAccountNumberAssert;

    @FindBy(xpath = "//*[@id='accountType']")
    public WebElement newAccountTypeAssert;

    @FindBy(name = "username")
    public WebElement userNameLogin;

    @FindBy(name = "password")
    public WebElement passwordLogin;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement loginButton;

    @FindBy(id = "amount")
    public WebElement amount;

    @FindBy(name = "fromAccountId")
    public WebElement senderAccountSelector;

    @FindBy(name = "toAccountId")
    public WebElement recipientAccountSelector;

    @FindBy(xpath = "//input[@value='Transfer']")
    public WebElement transferButton;

    @FindBy(xpath = "//*[text()='Open New Account']")
    public WebElement openNewAccountButton;





    public WebElement getWebElement(String strElement)
    {
        switch (strElement)
        {
            case "firstName": return this.firstName;
            case "lastName": return this.lastName;
            case "Address": return this.Address;
            case "City": return this.City;
            case "State": return this.State;
            case "ZipCode": return this.ZipCode;
            case "Phone": return this.Phone;
            case "SSN": return this.SSN;
            case "UserName": return this.UserName;
            case "Password": return this.Password;
            case "Confirm": return this.Confirm;
            case "openNewAccountLogin": return this.openNewAccountLogin;
            case "userNameLogin": return this.userNameLogin;
            case "passwordLogin": return this.passwordLogin;
            case "loginButton": return this.loginButton;
            case "senderAccountSelector": return this.senderAccountSelector;
            case "recipientAccountSelector": return this.recipientAccountSelector;
            case "transferButton": return this.transferButton;
            case "amount": return this.amount;

        }
        return null;
    }

    public void verifyMessageContainsText(WebElement element, String serchText){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains(serchText.toLowerCase()));

    }
}
