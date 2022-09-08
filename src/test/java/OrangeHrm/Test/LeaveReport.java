package OrangeHrm.Test;

import org.testng.annotations.Test;

public class LeaveReport extends BaseClass
{
    @Test
    public void Login()
    {
        pageFactory.loginPage().login();
    }
    @Test
    public void UserLeave() throws InterruptedException {
        pageFactory.userAbletoApplyLeave().UserReport();
    }
}
