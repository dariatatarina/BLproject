package loginTest;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class LoginTest {
    WebDriver webDriver;
    @Test
    public void validLogin() {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.brightlocal.com/");


        webDriver.findElement(By.linkText("Log in")).click();
//        webDriver.get("https://tools.brightlocal.com/seo-tools/admin/login?redirect_url=%252Fseo-tools%252Fadmin%252Fclients-and-locations&redirect_source=access_control");
        webDriver.findElement(By.name("email")).clear();
        webDriver.findElement(By.name("email")).sendKeys("dtautotest@gmail.com");

        webDriver.findElement(By.name("password")).clear();
        webDriver.findElement(By.name("password")).sendKeys("90609060");

        webDriver.findElement(By.tagName("button")).click();
//        webDriver.findElement(By.className("has-dropdown my-account  not-click"));
        Assert.assertTrue("Avatar is not present", webDriver.findElement
                (By.xpath(".//li[@class='has-dropdown my-account  not-click']/a//*[contains(@src,'gravatar')]")).isDisplayed ());

        webDriver.quit();

    }


    @Test
    public void InvalidSignUp () {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage ().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get ("https://www.brightlocal.com/");


        webDriver.findElement(By.xpath ("//*[@id=\"menu-item-41\"]/a")).click();
        webDriver.get ("https://tools.brightlocal.com/seo-tools/admin/sign-up/2003");
        webDriver.findElement(By.name("fullName")).sendKeys("dariatatarina");
        webDriver.findElement(By.name("email")).sendKeys("dtautotest@gmail.com");
        webDriver.findElement(By.id("company-name")).sendKeys("Candy");
        webDriver.findElement(By.name("country")).sendKeys("AUS");
        webDriver.findElement(By.name("password")).sendKeys("123456789Aa");
        webDriver.findElement(By.name("privacyOptIn")).click();
        webDriver.findElement(By.name("marketingOptIn")).click();
//        webDriver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]/div[1]")).click(); capcha
        webDriver.findElement(By.xpath("/html/body/div[1]/form/div/div/div[10]/input")).click();
        webDriver.findElement(By.xpath ("//html/body/div[1]/form/div/div/div[11]"));



    }
    @Test
    public void invalidForm () {
        File file = new File("./src/drivers/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();

        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("https://www.brightlocal.com/");


        webDriver.findElement (By.xpath ("//*[@id=\"menu-item-33\"]/a")).click();
        webDriver.findElement (By.xpath("//*[@id=\"page-content\"]/div[1]/div/div/div[1]/a[2]")).click();
        webDriver.findElement (By.id("gform_submit_button_5")).click ();
        webDriver.findElement(By.xpath ("//*[@id=\"gform_5\"]/div[1]"));
        webDriver.findElement(By.xpath ("//*[@id=\"nav-container\"]/div/a")).click();

        Assert.assertTrue("Logo is not present", isLogoPresent ());

        webDriver.quit();
    }

    private boolean isLogoPresent () {
        try {
            return webDriver.findElement (By.xpath("//*[@id=\"nav-container\"]/div/a")).isDisplayed();
        }catch (Exception e){
            return false;
        }
    }


}


