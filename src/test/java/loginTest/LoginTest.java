package loginTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {

    @Test
    public void validLogin () {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver webDriver = new ChromeDriver();

        webDriver.manage ().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get ("https://www.brightlocal.com/");


        webDriver.findElement(By.linkText ("Log in")).click();
        webDriver.get ("https://tools.brightlocal.com/seo-tools/admin/login?redirect_url=%252Fseo-tools%252Fadmin%252Fclients-and-locations&redirect_source=access_control");
        webDriver.findElement(By.name ("email")).clear();
        webDriver.findElement(By.name("email")).sendKeys("dtautotest@gmail.com");

        webDriver.findElement(By.name("password")).clear();
        webDriver.findElement(By.name("password")).sendKeys("");

        webDriver.findElement(By.tagName("button")).click();

        webDriver.quit();

    }


}
