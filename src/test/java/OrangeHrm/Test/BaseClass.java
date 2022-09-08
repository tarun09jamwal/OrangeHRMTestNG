package OrangeHrm.Test;

import OrangeHrm.Page.PageFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass
{
    static WebDriver driver;

    public static PageFactory pageFactory;

    @Parameters("browserName")
    @BeforeClass
    public static void Setup(String browserName)
    {
        if (browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        }
        else if (browserName.equalsIgnoreCase("firefox"))
        {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
            driver.manage().window().maximize();
            pageFactory = new PageFactory(driver);
        }
    }
        @AfterClass
        public static void Logout ()
        {
            driver.findElement(By.xpath("//span[@class='oxd-userdropdown-tab']")).click();
            driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
            driver.close();
        }
}

