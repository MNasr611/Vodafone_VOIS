package PageObject;

import AutomationAssessment.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Landing_Page_PO {
    WebDriverWait wait ;
    public Landing_Page_PO(WebDriver driver){
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath="//a[contains(@href,\"http://automationpractice.com/index.php?controller=my-account\")]")
    private WebElement signInBtn ;

    public WebElement getSignInBtn(){
        // encapsulation
        return signInBtn;
    }

    @FindBy(xpath="//a[contains(@href,\"http://automationpractice.com/index.php?id_category=3&controller=category\")]")
    private WebElement women ;

    public WebElement getWomen(){
        // encapsulation
        return women;
    }

    @FindBy(xpath="//a[contains(@href,\"http://automationpractice.com/index.php?id_category=7&controller=category\")]")
    private WebElement blouses ;

    public WebElement getBlouses(){
        // encapsulation
        return blouses;
    }

    public void chooseBlousesSubCategoryFromWomenCategory(WebDriver driver){
        WebElement womenCategory = getWomen();
        Mouse mouse = ((HasInputDevices) driver).getMouse();
        Locatable hoverItem = (Locatable) womenCategory;
        mouse.mouseMove(hoverItem.getCoordinates());
        WebElement blousesSubCategory = getBlouses();
        new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(blousesSubCategory));
        Locatable clickItem = (Locatable) blousesSubCategory;
        mouse.mouseDown(clickItem.getCoordinates());
        mouse.mouseUp(clickItem.getCoordinates());
    }

    public void goToSignInPage(WebDriver driver , WebDriverWait wait){
        getSignInBtn().click();
        wait = new WebDriverWait(driver , 30);
        wait.until(ExpectedConditions.urlToBe(Base.singInLink));
    }


}
