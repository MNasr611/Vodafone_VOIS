import java.io.IOException;
import AutomationAssessment.Base;
import AutomationAssessment.Utilities;
import DataProvider.Sign_In_Data_Provider;
import DataProvider.Sign_Up_Data_Provider;
import PageObject.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;

public class Choose_Sub_Category_From_Main_Category extends Base {
    public static WebDriver driver;
    WebDriverWait wait;
    //Page Object Model Attributes
    Landing_Page_PO lp;
    Utilities ul;
    String expectedResult ;
    String actualResult ;
    Blouses_Sub_Category_PO bsc ;
    Sign_In_PO si ;


    @BeforeMethod
    public void beforeTestExecution() throws IOException, InterruptedException{
        ul = new Utilities();
        ul.intializeEnvironment();
    }

    @Test
    public void chooseBlousesSubCategoryFromWomenCategory()  {
//        Steps :
//                1- go to the landing Page
//                2- Hover onto the Women Category
//                3- wait until the blouses subcategory appears
//                4- click on blouses
//                5- validate
        lp = new Landing_Page_PO(Base.driver);
        lp.chooseBlousesSubCategoryFromWomenCategory(Base.driver);
        validateThatItIsBlousesPage(Base.driver , wait);

    }


    @Test
    public void chooseResultedProduct()  {
//        Steps :
//                1- go to the landing Page
//                2- Hover onto the Women Category
//                3- wait until the blouses subcategory appears
//                4- click on blouses
//                5- scroll down to the resulted products
//                6- click on it
        lp = new Landing_Page_PO(Base.driver);
        bsc = new Blouses_Sub_Category_PO(Base.driver);
        lp.chooseBlousesSubCategoryFromWomenCategory(Base.driver);
        validateThatItIsBlousesPage(Base.driver , wait);
        bsc.scrollIntoResultedProductAndSelect(Base.driver);
        validateTheProductHasBeenSelected(Base.driver , wait);
    }

    @Test(dataProvider = "signIn", dataProviderClass = Sign_In_Data_Provider.class)
    public void selectProductFromSubProductAfterUserAuthenticated(String userName , String paaswd){
        //        Steps :
//                1- go to the landing Page
//                2- sign in with your account
//                2- Hover onto the Women Category
//                3- wait until the blouses subcategory appears
//                4- click on blouses
//                5- scroll down to the resulted products
//                6- click on it
        si = new Sign_In_PO(Base.driver);
        lp = new Landing_Page_PO(Base.driver);
        bsc = new Blouses_Sub_Category_PO(Base.driver);
        si.goToSignInPage(Base.driver , wait);
        si.signIn(Base.driver , wait ,userName ,paaswd );
        lp.chooseBlousesSubCategoryFromWomenCategory(Base.driver);
        validateThatItIsBlousesPage(Base.driver , wait);
        bsc.scrollIntoResultedProductAndSelect(Base.driver);
        validateTheProductHasBeenSelected(Base.driver , wait);

    }





    public void validateThatItIsBlousesPage(WebDriver driver,WebDriverWait wait){
        wait = new WebDriverWait(driver , 15);
        wait.until(ExpectedConditions.urlContains("id_category=7&controller=category"));
        expectedResult = Base.blousesLink ;
        actualResult = Base.driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);


    }
    public void validateTheProductHasBeenSelected(WebDriver driver,WebDriverWait wait){
        wait = new WebDriverWait(driver , 15);
        wait.until(ExpectedConditions.urlContains("id_category=7"));
        expectedResult = Base.resultedProductLink ;
        actualResult = Base.driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);


    }

    public void validateThatUserLoggedIn(){
        WebDriverWait wait ;
        new WebDriverWait(driver, 30).until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=my-account"));

    }

    @AfterMethod
    public void afterTestExecution() {
        ul.Terminate();
    }



}

