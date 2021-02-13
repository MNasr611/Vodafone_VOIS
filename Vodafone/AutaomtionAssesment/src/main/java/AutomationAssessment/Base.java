package AutomationAssessment;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import static org.openqa.selenium.remote.CapabilityType.BROWSER_NAME;

public class Base {
    public static WebDriver driver ;
    public static String link;
    public static String afterSignUpCompleteLink;
    public static String blousesLink;
    public static String resultedProductLink;
    public static String singInLink;


    public static WebDriver capabilities() throws IOException, InterruptedException {

        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\globalattributes.properties.txt");
        Properties prop = new Properties();
        prop.load(fis);
        link=(String) prop.get("landingPage");
        afterSignUpCompleteLink = (String) prop.get("afterSignUpPageUrl");
        blousesLink = (String) prop.get("blouses");
        resultedProductLink = (String) prop.get("resultedProductLink");
        singInLink = (String) prop.get("signInLink");

        DesiredCapabilities cp = new DesiredCapabilities();
        cp.setCapability(BROWSER_NAME,"Firefox");
        System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().setPosition(new Point(120,50));
        driver.manage().window().setSize(new Dimension(1024,768));
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
        return driver;

    }



}



	
	