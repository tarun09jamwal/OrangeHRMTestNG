package OrangeHrm.Test;

import org.testng.annotations.Test;

public class TestUserAbletoApplyLeave extends BaseClass
{
    @Test
    public void Login()
    {
        pageFactory.loginPage().login();
    }
    @Test
    public void UserLeave()
    {
        pageFactory.userAbletoApplyLeave().Leave();
    }
}
