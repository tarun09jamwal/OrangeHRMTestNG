package OrangeHrm.Test;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class TestPage extends BaseClass {
    @Test
    public void Login() {
        pageFactory.loginPage().login();
    }
    @Test(dependsOnMethods = "Login")
    public void AdminMenuClick() {
        pageFactory.menuBar().menu();
    }

    @Test(dependsOnMethods = "AdminMenuClick")
    public void AddUser() throws InterruptedException
    {
        pageFactory.addUser().user();
        pageFactory.userDetails().detail();
        pageFactory.userDetails().verify();
    }

    @Test(dependsOnMethods = "AddUser")
    public void DelUser()
    {
        pageFactory.delUser().del();
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
    }


}
