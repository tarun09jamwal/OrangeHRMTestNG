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
        pageFactory.menuBar().Menu();
    }

    @Test(dependsOnMethods = "AdminMenuClick")
    public void AddUser()
    {
        pageFactory.addUser().User();
        pageFactory.userDetails().Detail();
        pageFactory.userDetails().Verify();
    }

    @Test(dependsOnMethods = "AddUser")
    public void DelUser()
    {
        pageFactory.delUser().Del();
        driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--label-danger orangehrm-button-margin']")).click();
    }


}
