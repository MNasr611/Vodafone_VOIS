package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Order_History_PO {

    public Order_History_PO(WebDriver driver) {
        PageFactory.initElements(driver, this);

    }
    @FindBy(xpath="//tr[contains(@class,'first_item')]//td[@class='history_state']//span[@class='label dark'][contains(text(),'On backorder')]")
    private WebElement status;

    public WebElement getStatus() {
        // encapsulation
        return status;
    }

public String getTextFromStatus(){
        WebElement getStatus = getStatus();
        String actualResult  = getStatus.getText();
        return actualResult ;
}


}
