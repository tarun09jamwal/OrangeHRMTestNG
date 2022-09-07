package OrangeHrm.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MenuBar {
    WebDriver driver;
    By adminbutton = By.xpath("(//a[@class='oxd-main-menu-item'])[1]");

    public MenuBar(WebDriver driver)
    {
        this.driver = driver;
    }

    public void menu()
    {
        driver.findElement(adminbutton).click();
    }
}