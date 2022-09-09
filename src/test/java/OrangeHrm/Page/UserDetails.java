package OrangeHrm.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class UserDetails {
    WebDriver driver;
    WebDriverWait wait;
    By userRoleDropdown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[1]");
    By employeeName = By.xpath("(//div/input)[2]");
    By statusDropdown = By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    By username = By.xpath("(//div/input[@class='oxd-input oxd-input--active'])[2]");
    By password = By.xpath("(//div/input[@type='password'])[1]");
    By confirmPassword = By.xpath("(//div/input[@type='password'])[2]");
    By saveButton = By.xpath("//button[@type='submit']");
    By userNameVerify = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]");
    By userRoleVerify = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    By adminVerify = By.xpath("//*[contains(text(),'Admin')]");
    By searchVerify = By.xpath("//button[@type='submit']");
    By errorMessage = By.xpath("//span[contains(@class,'oxd-input-field-error-message')]");
    By verifyAdminPage = By.xpath("(//h6[contains(@class,'oxd-text--h6')])[2]");

    String uniqueName;
    public UserDetails(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void Detail() {
        String randomNumber = String.valueOf((int) (Math.random() * (100 - 50 + 1) + 50));
        uniqueName = "Odis09adalwin" + randomNumber;
        driver.findElement(userRoleDropdown).click();
        driver.findElement(By.xpath("//*[contains(text(),'Admin')]")).click();
        driver.findElement(employeeName).sendKeys("Odis");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        driver.findElement(By.xpath("//*[contains(text(),'Odis')]")).click();
        driver.findElement(statusDropdown).click();
        driver.findElement(By.xpath("//*[contains(text(),'Enabled')]")).click();
        driver.findElement(username).sendKeys(uniqueName);
        driver.findElement(password).sendKeys("Tarun@123");
        driver.findElement(confirmPassword).sendKeys("Tarun@123");
        wait.until(ExpectedConditions.invisibilityOfElementLocated(errorMessage));
        driver.findElement(saveButton).sendKeys(Keys.ENTER);
    }

    public void Verify() {
        wait.until(ExpectedConditions.textToBePresentInElementLocated(verifyAdminPage, "User Management"));
        driver.findElement(userNameVerify).sendKeys(uniqueName);
        driver.findElement(userRoleVerify).click();
        driver.findElement(adminVerify).click();
        driver.findElement(searchVerify).click();
        boolean isAdminDisplayed = driver.findElement(By.xpath(String.format("//div[contains(text(),'%s')]", uniqueName))).isDisplayed();
        Assert.assertTrue(isAdminDisplayed, "User is not added");
    }

}