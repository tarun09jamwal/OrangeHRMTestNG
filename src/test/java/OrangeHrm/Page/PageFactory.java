package OrangeHrm.Page;

import org.openqa.selenium.WebDriver;

public class PageFactory
{
    WebDriver driver;
    private LoginPage loginPage;
    private MenuBar menuBar;
    private AddUser addUser;
    private UserDetails userDetails;
    private DelUser delUser;
    private UserAbletoApplyLeave userAbletoApplyLeave;

    public PageFactory(WebDriver driver)
    {
        this.driver = driver;
    }
    public LoginPage loginPage()
    {
        if(loginPage ==null)
        {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    public MenuBar menuBar()
    {
        if(menuBar ==null)
        {
            menuBar = new MenuBar(driver);
        }
        return menuBar;
    }
    public AddUser addUser()
    {
        if(addUser ==null)
        {
            addUser = new AddUser(driver);
        }
        return addUser;
    }
    public UserDetails userDetails()
    {
        if(userDetails ==null)
        {
            userDetails= new UserDetails(driver);
        }
        return userDetails;
    }
    public DelUser delUser()
    {
        if (delUser== null)
        {
            delUser = new DelUser(driver);
        }
        return delUser;
    }
    public UserAbletoApplyLeave userAbletoApplyLeave()
    {
        if (userAbletoApplyLeave == null)
        {
            userAbletoApplyLeave = new UserAbletoApplyLeave(driver);
        }
        return userAbletoApplyLeave;
    }
}
