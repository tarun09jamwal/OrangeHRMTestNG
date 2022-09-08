package OrangeHrm.Test;

import OrangeHrm.Page.PageFactory;
import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class BaseClass
{
    static WebDriver driver;

    public static PageFactory pageFactory;
    @BeforeClass
    public static void SetUp()
    {
        System.setProperty("webdriver.chrome.driver","chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        pageFactory = new PageFactory(driver);
    }
    @AfterClass
    public static void Logout()
    {
        driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
        driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
        driver.close();
    }
}
