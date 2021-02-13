package PageObject;

import AutomationAssessment.Base;
import AutomationAssessment.Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Blouses_Sub_Category_PO {
    Utilities ul;
    WebDriverWait wait;
    Actions act ;

    public Blouses_Sub_Category_PO(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath = "//a[contains(@href,\"http://automationpractice.com/index.php?id_product=2&controller=product\")]")
    private WebElement product;

    public WebElement getProduct() {
        // encapsulation
        return product;
    }

    @FindBy(xpath = "//span[text()='Blouses ']")
    private WebElement Blouses;

    public WebElement getBlouses() {
        // encapsulation
        return Blouses;
    }

    @FindBy(xpath = "//a[contains(@href,\"http://automationpractice.com/index.php?id_product=2&controller=product\")]")
    private WebElement resultedProduct;

    public WebElement getResultedProduct() {
        // encapsulation
        return resultedProduct;
    }

    //xpath = "//a[contains(@href,\"http://automationpractice.com/index.php?controller=order\")]
    @FindBy(xpath = "//span[contains(text(),'\t\t\t\t\t\t\tProceed to checkout')][1]")
    private WebElement proceedToCheckOutBtn;
    public WebElement getProceedToCheckOutBtn() {
        // encapsulation
        return proceedToCheckOutBtn;
    }
    public void scrollIntoResultedProductAndSelect(WebDriver driver) {
        ul = new Utilities();
        WebElement product = getProduct();
        ul.scrollIntoElementAndClick(product, driver);

    }

    //(xpath="//span[text()='Add to cart']")
    @FindBy(xpath = "//p[@id = 'add_to_cart']")
    private WebElement add_to_cart_btn;

    public WebElement getAdd_to_cart_btn() {
        // encapsulation
        return add_to_cart_btn;
    }


    @FindBy(xpath = "//h1[@itemprop='name']")
    private WebElement itemName;
    public WebElement getItemName() {
        // encapsulation
        return itemName;
    }

    public void clickAddToCartBtn(WebDriver driver) {
        ul  = new Utilities();
        act = new Actions(driver);
        WebElement getAdd_to_cart_btn = getAdd_to_cart_btn();
        WebElement itemName = getItemName();
        ul.scrollIntoElement(itemName , driver);
        act.moveToElement(getAdd_to_cart_btn).pause(5).click().perform();

    }





    public void clickProceedToCheckOutBtnFromPopUpLayer(WebDriver driver) throws InterruptedException {
        //FluentWait fluentWait;
        //fluentWait = new FluentWait<>(driver);
        //fluentWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id = 'layer_cart']")));
        //wait = new WebDriverWait(driver , 15);
        //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[text()[contains(.,\"Product successfully added to your shopping cart\")]]")));
        //act=new Actions(driver);
        Thread.sleep(3000);
        WebElement getProceedToCheckOutBtn = getProceedToCheckOutBtn();
        new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'\t\t\t\t\t\t\tProceed to checkout')][1]"))).click();

    }




}