package OrangeHrm.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class LoginPage
{
   WebDriver driver;

   By username = By.name("username");

   By password = By.name("password");

    By submit =By.xpath("//button");

   public LoginPage(WebDriver driver)

   {
       this.driver = driver;
   }
   public void login()
   {
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
       driver.findElement(username).sendKeys("Admin");
       driver.findElement(password).sendKeys("admin123");
       driver.findElement(submit).click();
   }
}
