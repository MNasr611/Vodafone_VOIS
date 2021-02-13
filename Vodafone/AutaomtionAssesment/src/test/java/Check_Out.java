import AutomationAssessment.Base;
import AutomationAssessment.Utilities;
import DataProvider.Sign_In_Data_Provider;
import PageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;

public class Check_Out extends Base {
    Utilities ul ;
    Sign_In_PO si ;
    Landing_Page_PO lp;
    Blouses_Sub_Category_PO bsc ;
    WebDriverWait wait ;
    Choose_Sub_Category_From_Main_Category csc ;
    Product_PO pr1;
    String expectedResult ;
    String actualResult ;
    Order_History_PO oh ;
    @BeforeMethod
    public void beforeTestExecution() throws IOException, InterruptedException{
        ul = new Utilities();
        ul.intializeEnvironment();

    }

    @Test(dataProvider = "signIn", dataProviderClass = Sign_In_Data_Provider.class)
    public void checkOutProductProcedure(String userName , String paaswd) throws InterruptedException {
        //create new user account
        //Steps :
        //        1- go to the landing page
        //        2- click on sign_in button in the top right of the page
        //        3- login with your email
        //        4- click on sign in button
        //        5- hover onto women category
        //        6- choose blouses subcategory
        //        7- choose the selected product
        //        8- click add to cart button
        //        9- click proceed to checkout from popup
        //        10- scroll into proceed to check out button and click
        //        11- scroll into proceed to check out button and click
        //        12- choose agree terms check box
        //        13- scroll into proceed to check out button and click
        //        14- scroll and choose bank wire option
        //        15- click on confirm my order
        //        16- validate the order completion

        si  = new Sign_In_PO(Base.driver);
        lp  = new Landing_Page_PO(Base.driver);
        csc = new Choose_Sub_Category_From_Main_Category();
        pr1 = new Product_PO(Base.driver);
        bsc = new Blouses_Sub_Category_PO(Base.driver);
        si.goToSignInPage(Base.driver , wait);
        si.signIn(Base.driver , wait ,userName ,paaswd );
        lp.chooseBlousesSubCategoryFromWomenCategory(Base.driver);
        csc.validateThatItIsBlousesPage(Base.driver , wait);
        bsc.scrollIntoResultedProductAndSelect(Base.driver);
        csc.validateTheProductHasBeenSelected(Base.driver , wait);
        bsc.clickAddToCartBtn(Base.driver);
        bsc.clickProceedToCheckOutBtnFromPopUpLayer(Base.driver);
        pr1.scrollAndClickProceedToCheckOutBtnSummary(Base.driver);
        pr1.scrollAndClickProceedToCheckOutBtn(Base.driver);
        pr1.chooseAgreeTerms();
        pr1.scrollAndClickProceedToCheckOutBtn(Base.driver);
        pr1.clicKBankWire(Base.driver);
        pr1.clickConfirmMyOrder(Base.driver);
        validateOrderCompletion(Base.driver);
    }


    @Test(dataProvider = "signIn", dataProviderClass = Sign_In_Data_Provider.class)
    public void validateOrderWasPlaced(String userName , String paaswd) throws InterruptedException {
        //create new user account
        //Steps :
        //        1- go to the landing page
        //        2- click on sign_in button in the top right of the page
        //        3- login with your email
        //        4- click on sign in button
        //        5- hover onto women category
        //        6- choose blouses subcategory
        //        7- choose the selected product
        //        8- click add to cart button
        //        9- click proceed to checkout from popup
        //        10- scroll into proceed to check out button and click
        //        11- scroll into proceed to check out button and click
        //        12- choose agree terms check box
        //        13- scroll into proceed to check out button and click
        //        14- scroll and choose bank wire option
        //        15- click on confirm my order
        //        16- validate the order completion
        //        17- click on the back to orders button
        //        18- validate the status of the order

        si  = new Sign_In_PO(Base.driver);
        lp  = new Landing_Page_PO(Base.driver);
        csc = new Choose_Sub_Category_From_Main_Category();
        pr1 = new Product_PO(Base.driver);
        bsc = new Blouses_Sub_Category_PO(Base.driver);
        si.goToSignInPage(Base.driver , wait);
        si.signIn(Base.driver , wait ,userName ,paaswd );
        lp.chooseBlousesSubCategoryFromWomenCategory(Base.driver);
        csc.validateThatItIsBlousesPage(Base.driver , wait);
        bsc.scrollIntoResultedProductAndSelect(Base.driver);
        csc.validateTheProductHasBeenSelected(Base.driver , wait);
        bsc.clickAddToCartBtn(Base.driver);
        bsc.clickProceedToCheckOutBtnFromPopUpLayer(Base.driver);
        pr1.scrollAndClickProceedToCheckOutBtnSummary(Base.driver);
        pr1.scrollAndClickProceedToCheckOutBtn(Base.driver);
        pr1.chooseAgreeTerms();
        pr1.scrollAndClickProceedToCheckOutBtn(Base.driver);
        pr1.clicKBankWire(Base.driver);
        pr1.clickConfirmMyOrder(Base.driver);
        validateOrderCompletion(Base.driver);
        pr1.scrollAndClickBackToOrders(Base.driver);
        validateOrderWasPlaced(Base.driver);


    }
    public void validateOrderWasPlaced(WebDriver driver){
        oh  = new Order_History_PO(driver);
        expectedResult = "On backorder" ;
        actualResult = oh.getTextFromStatus();
        Assert.assertEquals(expectedResult, actualResult);

    }
    public void validateOrderCompletion(WebDriver driver){
        pr1 = new Product_PO(driver);
        WebElement expected = pr1.getOrderCompletionText();
        expectedResult = expected.getText();
        actualResult = "Your order on My Store is complete." ;
        Assert.assertEquals(expectedResult, actualResult);

    }


    @AfterMethod
    public void afterTestExecution() {
        ul.Terminate();
    }


}
