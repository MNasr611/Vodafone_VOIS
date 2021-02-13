package PageObject;
import AutomationAssessment.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Sign_In_PO {
    Landing_Page_PO lp ;
    Utilities ul;
    String randomEmail;


    public Sign_In_PO(WebDriver driver){
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath="//button[@id = 'SubmitCreate']")
    private WebElement createAnAccountBtn ;
    public WebElement createAnAccountBtn(){
        // encapsulation
        return createAnAccountBtn;
    }

    @FindBy(xpath="//input[@id = 'email_create']")
    private WebElement insertEmail ;
    public WebElement insertEmail(){
        // encapsulation
        return insertEmail;
    }

    @FindBy(xpath="//input[@id = 'email']")
    private WebElement insertEmailLogin ;
    public WebElement getInsertEmailLogin(){
        // encapsulation
        return insertEmailLogin;
    }

    @FindBy(xpath="//input[@id = 'passwd']")
    private WebElement passwdLogin ;
    public WebElement getPasswdLogin(){
        // encapsulation
        return passwdLogin;
    }

    @FindBy(xpath="//button[@id = 'SubmitLogin']")
    private WebElement SubmitLogin ;
    public WebElement getSubmitLogin(){
        // encapsulation
        return SubmitLogin;
    }

    public void goToSignInPage(WebDriver driver , WebDriverWait wait){
        lp = new Landing_Page_PO(driver);
        wait = new WebDriverWait(driver , 30);
        lp.getSignInBtn().click();
        wait.until(ExpectedConditions.urlContains("controller=authentication&back=my-account"));
    }

    public void signIn(WebDriver driver , WebDriverWait wait , String userName ,String psswd){
        lp = new Landing_Page_PO(driver);
        ul = new Utilities();
        wait = new WebDriverWait(driver , 30);
        getInsertEmailLogin().sendKeys(userName);
        getPasswdLogin().sendKeys(psswd);
        WebElement getSubmitLogin = getSubmitLogin();
        ul.scrollIntoElement(getSubmitLogin , driver);
        getSubmitLogin.click();
        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=my-account"));
    }

    public void goToAccountCreationPage(WebDriver driver , WebDriverWait wait ){
        ul = new Utilities();
        randomEmail = ul.generateRandomString()+"@email.com";
        insertEmail().sendKeys(randomEmail);
        createAnAccountBtn().click();
        wait = new WebDriverWait(driver , 30);
        wait.until(ExpectedConditions.urlContains("controller=authentication&back=my-account#account-creation"));
    }

    public String getEmailAddress(){
        return randomEmail ;

    }


}
