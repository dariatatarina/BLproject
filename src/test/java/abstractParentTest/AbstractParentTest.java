package abstractParentTest;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ClientAndLocation;
import pages.LoginPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class AbstractParentTest {
   WebDriver webDriver;
   protected LoginPage loginPage;
   protected ClientAndLocation clientAndLocation;

    @Before
    public void setUp() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage ().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        loginPage = new LoginPage (webDriver);
        clientAndLocation = new ClientAndLocation(webDriver);

    }
    @After
    public void tearDown () {
        webDriver.quit();
    }


    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);
    }

    protected void checkExpectedResult(String message,boolean expectedResult
            , boolean actualResult) {
        Assert.assertEquals(message, expectedResult, actualResult);
    }

}
