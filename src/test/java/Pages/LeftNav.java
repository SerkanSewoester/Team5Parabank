package Pages;

import Utilities.GWD;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftNav extends ParentPage{

    public LeftNav(WebDriver driver) {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(xpath = "//*[text()='Register']")
    public WebElement lnRegisterButton;

    @FindBy(xpath = "//*[@name='username']")
    public WebElement lnUsernameInput;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement lnPasswordInput;

    @FindBy(xpath = "//*[@value='Log In']")
    public WebElement lnLoginButton;

    @FindBy(xpath = "//*[text()='Bill Pay']")
    public WebElement lnBillPayButton;

    @FindBy(xpath = "//*[text()='Accounts Overview']")
    public WebElement lnAccountsOverview;

    @FindBy(xpath = "//*[text()='Open New Account']")
    public WebElement openNewAccountButton;

    @FindBy(xpath = "//a[@href='updateprofile.htm']")
    public WebElement lnUpdateContactButton;




    public WebElement getWebElement(String strElement)
    {
        switch (strElement)
        {
            case "lnRegisterButton" : return this.lnRegisterButton;
            case "lnUsernameInput" : return this.lnUsernameInput;
            case "lnLoginButton" : return this.lnLoginButton;
            case "lnPasswordInput" : return this.lnPasswordInput;
            case "lnBillPayButton" : return this.lnBillPayButton;
            case "lnAccountsOverview" : return this.lnAccountsOverview;
            case "lnUpdateContactButton" : return this.lnUpdateContactButton;


        }

        return null;
    }


}
