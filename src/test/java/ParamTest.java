import Utilites.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ParamTest {
    private String login;
    private String pass;
    private LoginPage loginPage;

    public ParamTest(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Before
    public void setUp() {
        Driver.getDriver().get("https://id.dev.by/@/hello");
        loginPage = new LoginPage(Driver.getDriver());
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{
                {"Lesia", "123"},
                {"Masha", "345"},
                {"Dima", "678"},
        };
        return Arrays.asList(data);
    }

    @Test
    public void enterLogin() {
        String log = login;
        String pas = pass;
        loginPage.loginMetod(log, pas);
        Assert.assertEquals("Неверный логин или пароль.", loginPage.getError());
    }

    @After
    public void tearDown() {
        Driver.close();
    }

}
