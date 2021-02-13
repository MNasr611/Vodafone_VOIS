package AutomationAssessment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.HasInputDevices;
import org.openqa.selenium.interactions.Locatable;
import org.openqa.selenium.interactions.Mouse;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Utilities {
    public void scrollIntoElement(WebElement element, WebDriver driver) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollIntoElementAndClick(WebElement element, WebDriver driver) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }


    public void intializeEnvironment() throws IOException, InterruptedException {
        Base.driver = Base.capabilities();
        Base.driver.get(Base.link);
        //Base.driver.manage().window().maximize();
    }

    public void Terminate()  {
        Base.driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        Base.driver.quit();
    }



    public String generateRandomString() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        return generatedString;

    }

    public void takeScreenshot(WebDriver driver ,String nameOfFailedTst) throws IOException {
        // TODO Auto-generated method stub
        File scrnshots =     ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        // take the screenshot as a type of file and put it in scrnshots object
        //cast the driver to the mood of taking screenshots
        String screenName = nameOfFailedTst + ".jpg";
        String path = System.getProperty("user.dir")+"\\ScreenShots\\"+ screenName ;
        FileUtils.copyFile(scrnshots,new File (path));
        //store that file from the object to the path in ur machine

    }



}