package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class My_Account_PO {
    Actions act ;

    public My_Account_PO(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath="//a[contains(@href,\"http://automationpractice.com/index.php?mylogout=\")]")
    private WebElement signOutBtn ;

    public WebElement getSignOutBtn(){
        // encapsulation
        return signOutBtn;
    }

    @FindBy(xpath="//a[contains(@href,\"http://automationpractice.com/index.php?controller=my-account\")]")
    private WebElement account;

    public WebElement getAccount() {
        // encapsulation
        return account;
    }




    public void clickOnSignOutBtn(WebDriver driver){
        WebElement signOutBtn = getSignOutBtn();
        act = new Actions(driver);
        act.moveToElement(signOutBtn).click().perform();

    }


}
