import java.io.IOException;
import java.util.Random;
import AutomationAssessment.Base;
import AutomationAssessment.Utilities;
import DataProvider.Sign_Up_Data_Provider;
import PageObject.Account_Creation_PO;
import PageObject.Landing_Page_PO;
import PageObject.My_Account_PO;
import PageObject.Sign_In_PO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import org.testng.Assert;


public class Account_Creation extends Base {
    public static WebDriver driver;
    Select s;
    WebDriverWait wait;
    String landingPage;
    //Page Object Model Attributes
    Landing_Page_PO lp;
    Sign_In_PO si ;
    Account_Creation_PO ac ;
    String expectedResult ;
    String actualResult ;
    My_Account_PO ma ;
    Utilities ul ;


    @BeforeMethod
    public void beforeTestExecution() throws IOException, InterruptedException{
        ul = new Utilities();
        ul.intializeEnvironment();
    }



    @Test(dataProvider = "createNewUser", dataProviderClass = Sign_Up_Data_Provider.class)
    public void createNewAccountUser(String firstName,String lastName, String password , String company , String address , String city , String additional_info ,String home_phone , String mobile_phone)  {
        //create new user account
        //Steps :
        //        1- go to the landing page
        //        2- click on sign_in button in the top right of the page
        //        3- insert any email address "test@email.com"
        //        4- click on create an account button
        //        5- fill the required data
        //        6- click register button
        //        7- validate
        ac = new Account_Creation_PO(Base.driver);
        lp = new Landing_Page_PO(Base.driver) ;
        si = new Sign_In_PO(Base.driver);
        lp.goToSignInPage(Base.driver , wait);
        si.goToAccountCreationPage(Base.driver , wait);
        ac.insertNewAccountData(Base.driver ,firstName, lastName , password , company , address , city , additional_info , home_phone , mobile_phone);
        ValidateSignUpCompleted(Base.driver,wait);

    }
    @Test(dataProvider = "createNewUser", dataProviderClass = Sign_Up_Data_Provider.class)
    public void authenticateAsNewUser(String firstName,String lastName, String password , String company , String address , String city , String additional_info ,String home_phone , String mobile_phone)  {
        //create new user account
        //Steps :
        //1- go to the landing page
        //2- click on sign_in button in the top right of the page
        ac = new Account_Creation_PO(Base.driver);
        lp = new Landing_Page_PO(Base.driver) ;
        si = new Sign_In_PO(Base.driver);
        lp.goToSignInPage(Base.driver , wait);
        si.goToAccountCreationPage(Base.driver , wait);
        ac.insertNewAccountData(Base.driver ,firstName, lastName , password , company , address , city , additional_info , home_phone , mobile_phone);
        validateTheAuthenticationOfTheNewUser(Base.driver, wait , firstName , lastName );


    }

    public void ValidateSignUpCompleted(WebDriver driver , WebDriverWait wait ){
        wait = new WebDriverWait(driver , 15);
        wait.until(ExpectedConditions.urlToBe("http://automationpractice.com/index.php?controller=my-account"));
        expectedResult = afterSignUpCompleteLink ;
        actualResult = Base.driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
    }
    public void validateTheAuthenticationOfTheNewUser(WebDriver driver,WebDriverWait wait , String fName , String lName){
        // Validate the parameter controller
        wait = new WebDriverWait(driver , 15);
        wait.until(ExpectedConditions.urlContains("controller=my-account"));
        expectedResult = Base.afterSignUpCompleteLink ;
        actualResult = Base.driver.getCurrentUrl();
        Assert.assertEquals(expectedResult, actualResult);
        // Validate the Account name
        ma = new My_Account_PO(driver);
        String accountName = ma.getAccount().getText();
        expectedResult = fName+" "+lName ;
        actualResult = accountName ;
        Assert.assertEquals(expectedResult, actualResult);
        String signOutText = ma.getSignOutBtn().getText();
        expectedResult = "Sign out" ;
        actualResult   = signOutText ;
        Assert.assertEquals(expectedResult, actualResult);
    }






    @AfterMethod
    public void afterTestExecution() {
        ul.Terminate();
    }


}