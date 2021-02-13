package PageObject;
import AutomationAssessment.Utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Account_Creation_PO {
    Utilities ul ;

    public Account_Creation_PO(WebDriver driver){
        PageFactory.initElements(driver, this);

    }


    @FindBy(xpath="//input[@id = 'id_gender1']")
    private WebElement id_gender1 ;
    public WebElement getId_gender1(){
        // encapsulation
        return id_gender1;
    }
    @FindBy(xpath="//input[@id = 'customer_firstname']")
    private WebElement customer_firstname ;
    public WebElement getCustomer_firstname(){
        // encapsulation
        return customer_firstname;
    }
    @FindBy(xpath="//input[@id = 'firstname']")
    private WebElement firstname ;
    public WebElement getFirstname(){
        // encapsulation
        return firstname;
    }
    @FindBy(xpath="//input[@id = 'customer_lastname']")
    private WebElement customer_lastname ;
    public WebElement getCustomer_lastname(){
        // encapsulation
        return customer_lastname;
    }

    @FindBy(xpath="//input[@id = 'passwd']")
    private WebElement passwd ;
    public WebElement getPasswd(){
        // encapsulation
        return passwd;
    }

    /////Date of birth
    @FindBy(xpath="//select[@id = 'days']")
    private WebElement days ;
    public WebElement getDays(){
        // encapsulation
        return days;
    }
    @FindBy(xpath="//select[@id = 'months']")
    private WebElement months ;
    public WebElement getMonths(){
        // encapsulation
        return months;
    }
    @FindBy(xpath="//select[@id = 'years']")
    private WebElement years ;
    public WebElement getYears(){
        // encapsulation
        return years;
    }

    @FindBy(xpath="//input[@id = 'company']")
    private WebElement company ;
    public WebElement getCompany(){
        // encapsulation
        return company;
    }
    @FindBy(xpath="//input[@id = 'address1']")
    private WebElement address1 ;
    public WebElement getAddress1(){
        // encapsulation
        return address1;
    }
    @FindBy(xpath="//input[@id = 'city']")
    private WebElement city ;
    public WebElement getCity(){
        // encapsulation
        return city;
    }
    @FindBy(xpath="//select[@id = 'id_state']")
    private WebElement id_state ;
    public WebElement getIdState(){
        // encapsulation
        return id_state;
    }


    @FindBy(xpath="//input[@id = 'postcode']")
    private WebElement postcode ;
    public WebElement getPostcode(){
        // encapsulation
        return postcode;
    }
    @FindBy(xpath="//div[@id = 'uniform-id_country']")
    private WebElement uniform_id_country ;
    public WebElement getUniform(){
        // encapsulation
        return uniform_id_country;
    }
    @FindBy(xpath="//textarea[@id = 'other']")
    private WebElement other ;
    public WebElement getOther(){
        // encapsulation
        return other;
    }
    @FindBy(xpath="//input[@id = 'phone']")
    private WebElement phone ;
    public WebElement getPhone(){
        // encapsulation
        return phone;
    }
    @FindBy(xpath="//input[@id = 'phone_mobile']")
    private WebElement phone_mobile ;
    public WebElement getPhone_mobile(){
        // encapsulation
        return phone_mobile;
    }
    @FindBy(xpath="//button[@id = 'submitAccount']")
    private WebElement submitAccount ;
    public WebElement getSubmitAccount(){
        // encapsulation
        return submitAccount;
    }

    public void insertNewAccountData(WebDriver driver ,String firstName,String lastName, String password , String company , String address , String city , String additional_info ,String home_phone , String mobile_phone){
        WebElement element ;
        home_phone   = home_phone.replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
        mobile_phone = mobile_phone.replaceFirst("\\.0*$|(\\.\\d*?)0+$", "$1");
        element = getId_gender1();
        ul = new Utilities();
        ul.scrollIntoElement(element , driver);
        getId_gender1().click();
        getCustomer_firstname().sendKeys(firstName);
        getCustomer_lastname().sendKeys(lastName);
        getPasswd().sendKeys(password);
        //select date of birth
        //Days
        element = getDays();
        Select select = new Select(element);
        select.selectByValue("30");
        //Months
        element = getMonths();
        select = new Select(element);
        select.selectByValue("1");
        //Years
        element = getYears();
        select = new Select(element);
        select.selectByValue("1995");
        element = getFirstname();
        ul.scrollIntoElement(element , driver);
        getCompany().sendKeys(company);
        getAddress1().sendKeys(address);
        getCity().sendKeys(city);
        element = getIdState();
        select = new Select(element);
        select.selectByValue("1");
        //value = 1 for Alabama
        getPostcode().sendKeys("00000");
        element = getOther();
        ul.scrollIntoElement(element , driver);
        element.sendKeys(additional_info);
        getPhone().sendKeys(home_phone);
        getPhone_mobile().sendKeys(mobile_phone);
        getSubmitAccount().click();



    }




}
