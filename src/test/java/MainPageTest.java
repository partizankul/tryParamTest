import Utilites.Driver;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

public class MainPageTest {
    private MainPage mainPage;
    JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();

    @Before
    public void setUp() {
        Driver.getDriver().get("https://dev.by/");
        mainPage = new MainPage(Driver.getDriver());

    }

    @Test
    public void clickEntranceLink() {
        mainPage.clickEntranceLink();
        String url = js.executeScript("return document.URL;").toString();
        Assert.assertEquals("https://id.dev.by/@/hello", url);
        System.out.println(Driver.getDriver().getTitle());
    }


    @Ignore
    @Test
    public void testJSEx() {
        js.executeScript("window.scrollBy (0, 1000)");
    }

   /* @After
    public void tearDown() {
        Driver.close();
    }
*/

}


