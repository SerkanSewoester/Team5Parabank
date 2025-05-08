package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class DialogContent extends ParentPage{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath="//*[@id='customer.firstName']")
    public WebElement registerFirstNameInput;

    @FindBy(xpath="//*[@id='customer.lastName']")
    public WebElement registerLastNameInput;

    @FindBy(xpath="//*[@id='customer.address.street']")
    public WebElement registerAddressInput;

    @FindBy(xpath="//*[@id='customer.address.city']")
    public WebElement registerCityInput;

    @FindBy(xpath="//*[@id='customer.address.state']")
    public WebElement registerStateInput;

    @FindBy(xpath="//*[@id='customer.address.zipCode']")
    public WebElement registerZipCodeInput;

    @FindBy(xpath="//*[@id='customer.phoneNumber']")
    public WebElement registerPhoneNumberInput;

    @FindBy(xpath="//*[@id='customer.ssn']")
    public WebElement registerSsnInput;

    @FindBy(xpath="//*[@id='customer.username']")
    public WebElement registerUsernameInput;

    @FindBy(xpath="//*[@id='customer.password']")
    public WebElement registerPasswordInput;

    @FindBy(xpath="//*[@id='repeatedPassword']")
    public WebElement registerRePasswordInput;

    @FindBy(xpath="//*[@value='Register']")
    public WebElement registerButton;

    @FindBy(xpath = "//*[@class='smallText']")
    public WebElement welcomeText;

    @FindBy(xpath = "//*[@class='title']")
    public WebElement errorText;

    @FindBy(xpath = "//*[@name='payee.name']")
    public WebElement billPayeeName;

    @FindBy(xpath = "//*[@name='payee.address.street']")
    public WebElement billPayeeAddress;

    @FindBy(xpath = "//*[@name='payee.address.city']")
    public WebElement billPayeeCity;

    @FindBy(xpath = "//*[@name='payee.address.state']")
    public WebElement billPayeeState;

    @FindBy(xpath = "//*[@name='payee.address.zipCode']")
    public WebElement billPayeeZipCode;

    @FindBy(xpath = "//*[@name='payee.phoneNumber']")
    public WebElement billPayeePhoneNumber;

    @FindBy(xpath = "//*[@name='payee.accountNumber']")
    public WebElement billPayeeAccountNumber;

    @FindBy(xpath = "//*[@name='verifyAccount']")
    public WebElement billPayeeVerifyAccountNumber;

    @FindBy(xpath = "//*[@name='amount']")
    public WebElement billPayeeAmount;

    @FindBy(xpath = "//*[@name='fromAccountId']")
    public WebElement billPayeeFromAccountSelect;

    @FindBy(xpath = "//*[@value='Send Payment']")
    public WebElement sendPaymentButton;

    @FindBy(xpath = "//*[text()='Bill Payment Complete']")
    public WebElement billCompleteText;

    @FindBy(xpath = "//*[@id='amount']")
    public WebElement amountText;

    @FindBy(xpath = "//*[@id='fromAccountId']")
    public WebElement fromAccountText;

    @FindBy(xpath = "//*[@id='accountTable']//tbody//a")
    public WebElement account;

    @FindBy(xpath = "//*[text()='Bill Payment to İski Su Faturasi']")
    public List<WebElement> paymentButtons;

    @FindBy(xpath = "//td[b[text()='Transaction ID:']]/following-sibling::td")
    public WebElement transactionIDText;

    @FindBy(xpath = "//*[text()='Date:']/following::td")
    public WebElement dateText;

    @FindBy(xpath = "(//*[text()='Description:']/following::td)[1]")
    public WebElement descriptionText;

    @FindBy(xpath = "//*[text()='Amount:']/following::td")
    public WebElement detailsAmountText;






    public WebElement getWebElement(String strElement)
    {
        switch (strElement)
        {
            case "registerFirstNameInput" : return this.registerFirstNameInput;
            case "registerLastNameInput" : return this.registerLastNameInput;
            case "registerAddressInput" : return this.registerAddressInput;
            case "registerCityInput" : return this.registerCityInput;
            case "registerStateInput" : return this.registerStateInput;
            case "registerZipCodeInput" : return this.registerZipCodeInput;
            case "registerPhoneNumberInput" : return this.registerPhoneNumberInput;
            case "registerSsnInput" : return this.registerSsnInput;
            case "registerUsernameInput" : return this.registerUsernameInput;
            case "registerPasswordInput" : return this.registerPasswordInput;
            case "registerRePasswordInput" : return this.registerRePasswordInput;
            case "registerButton" : return this.registerButton;
            case "welcomeText" : return this.welcomeText;
            case "errorText" : return this.errorText;
            case "billPayeeName" : return this.billPayeeName;
            case "billPayeeAddress" : return this.billPayeeAddress;
            case "billPayeeCity" : return this.billPayeeCity;
            case "billPayeeState" : return this.billPayeeState;
            case "billPayeeZipCode" : return this.billPayeeZipCode;
            case "billPayeePhoneNumber" : return this.billPayeePhoneNumber;
            case "billPayeeAccountNumber" : return this.billPayeeAccountNumber;
            case "billPayeeVerifyAccountNumber" : return this.billPayeeVerifyAccountNumber;
            case "billPayeeAmount" : return this.billPayeeAmount;
            case "billPayeeFromAccountSelect" : return this.billPayeeFromAccountSelect;
            case "sendPaymentButton" : return this.sendPaymentButton;
            case "billCompleteText" : return this.billCompleteText;
            case "amountText" : return this.amountText;
            case "fromAccountText" : return this.fromAccountText;
            case "account" : return this.account;
            case "transactionIDText" : return this.transactionIDText;
            case "dateText" : return this.dateText;
            case "descriptionText" : return this.descriptionText;
            case "detailsAmountText" : return this.detailsAmountText;


        }
        return null;
    }

    public void verifyMessageContainsText(WebElement element, String serchText){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains(serchText.toLowerCase()));

    }
}
