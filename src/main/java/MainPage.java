import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;


    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By entrance = By.xpath("//*[text()=\"Вход\"]");
    private By login = By.xpath("/html/body/div[5]/header/div[1]/div[3]/a");


    public MainPage clickEntranceLink() {
        driver.findElement(entrance).click();
        return new MainPage(driver);
    }


}
