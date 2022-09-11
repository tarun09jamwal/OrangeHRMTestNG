package OrangeHrm.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DelUser {
    WebDriver driver;
    WebDriverWait wait;
    By delButton = By.xpath("//button[@class='oxd-icon-button oxd-table-cell-action-space'][1]");

    public DelUser(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(50));
    }
    public void Del() {
        wait.until(ExpectedConditions.elementToBeClickable(delButton));
        driver.findElement(delButton).click();
    }
}
