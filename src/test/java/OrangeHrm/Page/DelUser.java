package OrangeHrm.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DelUser
{
    WebDriver driver;
    By delbutton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]");

    public DelUser(WebDriver driver)
    {
        this.driver = driver;
    }
    public void del()
    {
        driver.findElement(delbutton).click();
    }
}
