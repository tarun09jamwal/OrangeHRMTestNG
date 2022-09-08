package OrangeHrm.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UserAbletoApplyLeave {
    WebDriver driver;
    WebDriverWait wait;

    By leaveButton = By.xpath("//a[@href='/web/index.php/leave/viewLeaveModule']");

    By apply = By.xpath("//a[contains(text(),'Apply')]");

    By leaveType = By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
    By leaveTypeDropDown = By.xpath("//*[contains(text(),'CAN - Bereavement')]");

    By fromDate = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");


    By comments = By.xpath("//textarea[@class='oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");

    By toDate = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");

    By applyButton = By.xpath("//div[@class='oxd-form-actions']//button[contains(@class,'oxd-button')]");

    String enddate = "2022-09-08";
    String startdate = "2022-09-08";

    By myLeave = By.xpath("//a[contains(text(),'My Leave')]");

    By reports = By.xpath("(//li[@class='oxd-topbar-body-nav-tab --parent'])[2]");

    By leaveEntitlementAndReport = By.xpath("//a[contains(text(),'Leave Entitlements and Usage Report')]");

    By generate = By.xpath("//div/button[@type='submit']");


    public UserAbletoApplyLeave(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void Leave()
    {
        driver.findElement(leaveButton).click();
        driver.findElement(apply).click();
        wait.until(ExpectedConditions.elementToBeClickable(leaveType));
        driver.findElement(leaveType).click();
        driver.findElement(leaveTypeDropDown).click();
        driver.findElement(comments).sendKeys("Tarun want leave");
        wait.until(ExpectedConditions.elementToBeClickable(toDate));
        driver.findElement(toDate).clear();
        driver.findElement(toDate).sendKeys(enddate);
        wait.until(ExpectedConditions.elementToBeClickable(fromDate));
        driver.findElement(fromDate).sendKeys(startdate);
        wait.until(ExpectedConditions.elementToBeClickable(applyButton));
        driver.findElement(applyButton).sendKeys(Keys.RETURN);
        driver.findElement(myLeave).click();
        String actual = driver.findElement(By.xpath("//div[contains(text(),'Tarun want leave')]")).getText();
        Assert.assertTrue(actual.equals("Tarun want leave"), "Expected result does not match with actual result");
    }

    public void UserReport() throws InterruptedException//TCTC-02
    {
        driver.findElement(leaveButton).click();
        driver.findElement(reports).click();
        driver.findElement(leaveEntitlementAndReport).click();
        Thread.sleep(2000);
        driver.findElement(generate).sendKeys(Keys.ENTER);
        String actual = driver.findElement(By.xpath("//div[contains(text(),'Leave Entitlements (Days)')]")).getText();
        Assert.assertTrue(actual.equals("Leave Entitlements (Days)"), "Expected result does not match with actual result");


    }
}
