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

    @FindBy(xpath = "//*[@name='payee.name']")
    public WebElement billPayeeNameInput;

    @FindBy(xpath = "//*[@name='payee.address.street']")
    public WebElement pillPayeeAddressInput;

    @FindBy(xpath = "//*[@name='payee.address.city']")
    public WebElement billPayeeCityInput;

    @FindBy(xpath = "//*[@name='payee.address.state']")
    public WebElement billPayeeStateInput;

    @FindBy(xpath = "//*[@name='payee.address.zipCode']")
    public WebElement billPayeeZipCodeInput;

    @FindBy(xpath = "//*[@name='payee.phoneNumber']")
    public WebElement billPayeePhoneNumberInput;



    @FindBy(xpath = "//*[@name='payee.accountNumber']")
    public WebElement billPayeeAccountInput;

    @FindBy(xpath = "//*[@name='verifyAccount']")
    public WebElement billPayeeVerifyAccountInput;

    @FindBy(xpath = "//*[@name='amount']")
    public WebElement billPayeeAmountInput;

    @FindBy(xpath = "//*[@name='fromAccountId']")
    public WebElement billPayeeFromAccountSelect;

    @FindBy(xpath = "//*[@value='Send Payment']")
    public WebElement billPayeeSendPaymentButton;

    @FindBy(xpath = "//*[@id='billpayResult']//h1")
    public WebElement billPaymentCompleteText;

    @FindBy(xpath = "//*[@id='payeeName']")
    public WebElement billPayedName;

    @FindBy(xpath = "//*[@id='amount']")
    public WebElement billPayedAmount;

    @FindBy(xpath = "//*[@id='accountTable']//a")
    public WebElement accountOverviewNumber;


    @FindBy(xpath = "(//*[@id='rightPanel']//tr)[2]//td[2]")
    public WebElement transterDetailsDate;

    @FindBy(xpath = "(//*[@id='rightPanel']//tr)[3]//td[2]")
    public WebElement transterDetailsDescription;

    @FindBy(xpath = "(//*[@id='rightPanel']//tr)[5]//td[2]")
    public WebElement transterDetailsAmount;


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

    @FindBy(xpath = "//input[@name='username']")
    public WebElement LogInUsername;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement LogInPassword;

    @FindBy(xpath = "//input[@value='Log In']")
    public WebElement LogInButton;

    @FindBy(xpath = "//p[@class='smallText']")
    public WebElement LogInSuccessText;

    @FindBy(xpath = "//p[@class='error']")
    public WebElement LogInErrorText;
/// //////////////////////////////////////////////////////
    @FindBy(xpath = "//*[@id='customer.firstName']")
    public WebElement ContactFirstName;

    @FindBy(xpath = "//*[@id='customer.lastName']")
    public WebElement ContactLastName;

    @FindBy(xpath = "//*[@id='customer.address.street']")
    public WebElement ContactAddress;

    @FindBy(xpath = "//*[@id='customer.address.city']")
    public WebElement ContactCity;

    @FindBy(xpath = "//*[@id='customer.address.state']")
    public WebElement ContactState;

    @FindBy(xpath = "//*[@id='customer.address.zipCode']")
    public WebElement ContactZipcode;

    @FindBy(xpath = "//*[@id='customer.phoneNumber']")
    public WebElement ContactPhone;

    @FindBy(xpath = "//*[@type='button']")
    public WebElement ContactUpdateButton;

    @FindBy(xpath = "//h1[@class='title' and text()='Profile Updated']")
    public WebElement ContactUpdateProfile;

    @FindBy(xpath = "//span[@id='city-error']")
    public WebElement ContactErrorMessage;



    @FindBy(xpath = "//*[@id='amount']")
    public WebElement loanAmountInput;

    @FindBy(xpath = "//*[@id='downPayment']")
    public WebElement downPaymentInput;

    @FindBy(xpath = "//*[@value='Apply Now']")
    public WebElement applyNowButton;

    @FindBy(xpath = "//*[@id='loanRequestApproved']//p")
    public WebElement loanRequestResult;

    @FindBy(xpath = "//*[@id='newAccountId']")
    public WebElement loanNewAccountNumber;

    @FindBy(xpath = "//*[@id='balance']")
    public WebElement balance;

    @FindBy(xpath = "//*[@id='noTransactions']")
    public WebElement noTransactionsFountText;

    @FindBy(xpath = "//*[@id='accountType']")
    public WebElement loanAccountType;

    @FindBy(xpath = "//*[@value='Go']")
    public WebElement goButton;

    public WebElement getWebElement(String strElement)
    {
        switch (strElement)
        {

            case "billPayeeNameInput": return this.billPayeeNameInput;
            case "pillPayeeAddressInput": return this.pillPayeeAddressInput;
            case "billPayeeCityInput": return this.billPayeeCityInput;
            case "billPayeeStateInput": return this.billPayeeStateInput;
            case "billPayeeZipCodeInput": return this.billPayeeZipCodeInput;
            case "billPayeePhoneNumberInput": return this.billPayeePhoneNumberInput;
            case "billPayeeAccountInput": return this.billPayeeAccountInput;
            case "billPayeeVerifyAccountInput": return this.billPayeeVerifyAccountInput;
            case "billPayeeAmountInput": return this.billPayeeAmountInput;
            case "billPayeeFromAccountSelect": return this.billPayeeFromAccountSelect;
            case "billPayeeSendPaymentButton": return this.billPayeeSendPaymentButton;
            case "billPaymentCompleteText": return this.billPaymentCompleteText;
            case "billPayedName": return this.billPayedName;
            case "billPayedAmount": return this.billPayedAmount;
            case "accountOverviewNumber": return this.accountOverviewNumber;
            case "transterDetailsDate": return  this.transterDetailsDate;
            case "transterDetailsDescription": return  this.transterDetailsDescription;
            case "transterDetailsAmount": return  this.transterDetailsAmount;
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

            case "loanAmountInput": return this.loanAmountInput;
            case "downPaymentInput": return this.downPaymentInput;
            case "applyNowButton": return this.applyNowButton;
            case "loanNewAccountNumber": return this.loanNewAccountNumber;
            case "balance": return this.balance;
            case "noTransactionsFountText": return this.noTransactionsFountText;
            case "loanAccountType": return this.loanAccountType;
            case "goButton": return this.goButton;



        }
        return null;
    }

    public void verifyMessageContainsText(WebElement element, String serchText){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains(serchText.toLowerCase()));

    }
}
