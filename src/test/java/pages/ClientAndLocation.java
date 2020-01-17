package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parentPage.ParentPage;

public class ClientAndLocation extends ParentPage {
    public ClientAndLocation(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isAvatarDisplayed (){
        try {
            WebElement avatar = webDriver.findElement(By.xpath(".//li[@class='has-dropdown my-account  not-click']/a//*[contains(@src,'gravatar')]"));
            return avatar.isDisplayed();

        }catch (Exception e){
            return false;
        }
    }
}
