package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import parentPage.ParentPage;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void openPage() {
        try {
            webDriver.get ("https://www.brightlocal.com/");

        }catch ( Exception e){
            Assert.fail("Cannot work with browser");
        }
        try {
            webDriver.get("https://tools.brightlocal.com/seo-tools/admin/login?redirect_url=%252Fseo-tools%252Fadmin%252Fclients-and-locations&redirect_source=access_control");
        } catch (Exception e){
            Assert.fail("Cannot open site");
        }

    }

    public void enterEmailInToEmailAddress(String email) {
        WebElement clickOnLogIn = webDriver.findElement(By.linkText("Log in"));
        WebElement emailAddress = webDriver.findElement(By.name("email"));
        emailAddress.clear();
        emailAddress.sendKeys(email);
        logger.info(email + "was inputed in to input Email Address");

    }

    public void enterPassInToPassword(String password) {
        WebElement inputPass = webDriver.findElement(By.name("password"));
        inputPass.clear();
        inputPass.sendKeys(password);
        logger.info(password + "was inputed in to input Password");
    }

    public void clickOnButtonLogin() {
        WebElement buttonLogin = webDriver.findElement((By.tagName("button")));
        buttonLogin.click();
        logger.info("Button was clicked");

    }
}
