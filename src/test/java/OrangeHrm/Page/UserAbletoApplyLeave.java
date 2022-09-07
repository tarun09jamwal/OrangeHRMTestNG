package OrangeHrm.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UserAbletoApplyLeave
{
    WebDriver driver;
    WebDriverWait wait;

    By leaveButton = By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']");

    By apply = By.xpath("//a[contains(text(),'Apply')]");

    By leaveType = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
    By leaveTypeDropDown = By.xpath("//*[contains(text(),'CAN - Bereavement')]");

    By fromDate = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");


    By comments = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");

    By toDate = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");

    By applyButton = By.xpath("//button[@type='submit']");



    public UserAbletoApplyLeave(WebDriver driver)
    {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void Leave()
    {
        driver.findElement(leaveButton).click();
        driver.findElement(apply).click();
        wait.until(ExpectedConditions.elementToBeClickable(leaveType));
        driver.findElement(leaveType).click();
        driver.findElement(leaveTypeDropDown).click();
        driver.findElement(fromDate).sendKeys("2022-09-08");

        driver.findElement(comments).sendKeys("I want leave");
        wait.until(ExpectedConditions.elementToBeClickable(toDate));
        driver.findElement(toDate).clear();
        driver.findElement(toDate).sendKeys("2022-09-10");
        driver.findElement(applyButton).click();
    }
}
