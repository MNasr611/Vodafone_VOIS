package PageObject;

import AutomationAssessment.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Product_PO {
    Utilities ul ;
    Select s ;
    Actions act ;
    public Product_PO(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="//a[contains(@href,\"http://automationpractice.com/index.php?controller=order&step=1\")]")
    private WebElement proceedToCheckOut;

    public WebElement getProceedToCheckOut() {
        // encapsulation
        return proceedToCheckOut;
    }


    @FindBy(xpath="//button[@type='submit']//span[contains(text(),'Proceed to checkout')]")
    private WebElement proceedToCheckOutBtn;
    public WebElement getProceedToCheckOutBtn() {
        // encapsulation
        return proceedToCheckOutBtn;
    }



    @FindBy(xpath="//input[@id='cgv']")
    private WebElement agreeTerms;
    public WebElement getAgreeTerms() {
        // encapsulation
        return agreeTerms;
    }


    @FindBy(xpath="//a[@class='bankwire']")
    private WebElement bankwire;
    public WebElement getBankwire() {
        // encapsulation
        return bankwire;
    }

    @FindBy(xpath="//span[contains(text(),'I confirm my order')]")
    private WebElement confirmOrder;
    public WebElement getConfirmOrder() {
        // encapsulation
        return confirmOrder;
    }

    @FindBy(xpath="//strong[contains(text(),'Your order on My Store is complete.')]")
    private WebElement orderCompletionText;
    public WebElement getOrderCompletionText() {
        // encapsulation
        return orderCompletionText;
    }

    @FindBy(xpath="//a[@class='button-exclusive btn btn-default']")
    private WebElement backToOrders;
    public WebElement getBackToOrders() {
        // encapsulation
        return backToOrders;
    }

   public void scrollAndClickProceedToCheckOutBtnSummary(WebDriver driver){
        //Validate the product
        //scroll
       //click
       ul = new Utilities();
       WebElement getProceedToCheckOut = getProceedToCheckOut();
       ul.scrollIntoElement(getProceedToCheckOut , driver);
       act=new Actions(driver);
       act.moveToElement(getProceedToCheckOut).click().perform();
   }
    public void scrollAndClickProceedToCheckOutBtn(WebDriver driver){
        //Validate the product
        //scroll
        //click
        ul = new Utilities();

        WebElement getProceedToCheckOutBtn = getProceedToCheckOutBtn();
        ul.scrollIntoElement(getProceedToCheckOutBtn , driver);
        act=new Actions(driver);
        act.moveToElement(getProceedToCheckOutBtn).click().perform();
    }

   public void chooseAgreeTerms (){
       WebElement getAgreeTerms = getAgreeTerms();
       if(!getAgreeTerms.isSelected())
           getAgreeTerms.click();

   }

   public void clicKBankWire(WebDriver driver){
       ul = new Utilities();
       WebElement getBankwire = getBankwire();
       ul.scrollIntoElement(getBankwire , driver);
       act=new Actions(driver);
       act.moveToElement(getBankwire).click().perform();

   }

    public void clickConfirmMyOrder(WebDriver driver){
        ul = new Utilities();
        WebElement getConfirmOrder = getConfirmOrder();
        ul.scrollIntoElement(getConfirmOrder , driver);
        act=new Actions(driver);
        act.moveToElement(getConfirmOrder).click().perform();

    }

    public void scrollAndClickBackToOrders(WebDriver driver){
        //Validate the product
        //scroll
        //click
        ul = new Utilities();
        WebElement getBackToOrders = getBackToOrders();
        ul.scrollIntoElement(getBackToOrders , driver);
        act=new Actions(driver);
        act.moveToElement(getBackToOrders).click().perform();
    }




}
