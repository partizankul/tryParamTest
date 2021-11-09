import Utilites.Driver;
import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;


public class LoginPageTest {
    private LoginPage loginPage;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Before
    public void setUp() {
        Driver.getDriver().get("https://id.dev.by/@/hello");
        loginPage = new LoginPage(Driver.getDriver());
    }

    @Test
    public void otherTest() {
        loginPage.enterLogin("LOgin");
        loginPage.enterPass("PAss");
        loginPage.clickInButton();
        Assert.assertEquals("Неверный логин или пароль.", loginPage.getError());

    }


    @Test
    public void testOther() {
        loginPage.loginMetod("Name", "Pass");
        Assert.assertEquals("Неверный логин или пароль.", loginPage.getError());

    }

    @Test
    public void getRegPageUrl() {
        loginPage.clickReg();
        Assert.assertEquals("https://id.dev.by/@/welcome", js.executeScript("return document.URL;").toString());

    }

    @Ignore
    @Test
    public void uslSite() {
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("этот урл = " + url);
    }

    @After
    public void tearDown() {
        Driver.close();
    }
}
