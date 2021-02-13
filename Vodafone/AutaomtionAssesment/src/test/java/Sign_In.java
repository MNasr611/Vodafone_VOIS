import AutomationAssessment.Base;
import AutomationAssessment.Utilities;
import DataProvider.Sign_Up_Data_Provider;
import PageObject.Account_Creation_PO;
import PageObject.Landing_Page_PO;
import PageObject.My_Account_PO;
import PageObject.Sign_In_PO;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class Sign_In extends Base {
    Utilities ul ;
    Landing_Page_PO lp;
    Sign_In_PO si ;
    Account_Creation_PO ac ;
    WebDriverWait wait;
    Account_Creation accountCreation ;
    My_Account_PO ma ;
    String expectedResult ;
    String actualResult ;
    String userEmailToLogin ;

    @BeforeMethod
    public void beforeTestExecution() throws IOException, InterruptedException{
        ul = new Utilities();
        ul.intializeEnvironment();
    }

    @Test(dataProvider = "createNewUser", dataProviderClass = Sign_Up_Data_Provider.class)
    public void signInWithCreatedAccount(String firstName,String lastName, String password , String company , String address , String city , String additional_info ,String home_phone , String mobile_phone){
//        Steps :
//                1- go to the landing page
//                2- click on the sign in button
//                3- insert an email address
//                4- click on create an account button
//                5- fill in the required fields
//                6- click on register button
//                7- click on the sign_out button
//                8- click on the sign_in button in the top of the page
//                9- insert the email address
//                10- insert the password
//                11- click on the sing_in button in the below of the page
//                12- validate that the crated mail is the one that is signed_in
//                  String randomEmail = ul.generateRandomString();
//                  String emailAddress = randomEmail+"email.com";
                  String passwd = "12345" ;
                  ac = new Account_Creation_PO(Base.driver);
                  lp = new Landing_Page_PO(Base.driver) ;
                  si = new Sign_In_PO(Base.driver);
                  accountCreation = new Account_Creation();
                  ma = new My_Account_PO(Base.driver);
                  wait = new WebDriverWait(Base.driver , 30);
                  lp.goToSignInPage(Base.driver , wait);
                  si.goToAccountCreationPage(Base.driver , wait);
                  ac.insertNewAccountData(Base.driver ,firstName, lastName , passwd , company , address , city , additional_info , home_phone , mobile_phone);
                  accountCreation.validateTheAuthenticationOfTheNewUser(Base.driver, wait , firstName , lastName );
                  ma.clickOnSignOutBtn(Base.driver);
                  validateItsSignInPage(Base.driver , wait);
                  userEmailToLogin = si.getEmailAddress();
                  si.signIn(Base.driver , wait ,userEmailToLogin ,"12345" );
                  accountCreation.validateTheAuthenticationOfTheNewUser(Base.driver , wait , "testFName" , "TestLName" );

    };

    public void validateItsSignInPage(WebDriver driver , WebDriverWait wait){
        wait = new WebDriverWait(driver , 30);
        wait.until(ExpectedConditions.urlToBe(Base.singInLink));
    }


    @AfterMethod
    public void afterTestExecution() {

        ul.Terminate();
    }


}

