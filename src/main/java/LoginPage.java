
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    private By loginField = By.xpath("//input[@class=\"input\"]");
    private By passField = By.xpath("//input[@name=\"password\"]");
    private By enterButton = By.xpath("//span[text()=\"Войти\"]");
    private By errar = By.xpath("//*[text()=\"Неверный логин или пароль.\"]");
    private By reg = By.xpath("//*[text()=\"Регистрация\"]");

    public LoginPage enterLogin(String login) {
        driver.findElement(loginField).sendKeys(login);
        return this;
    }

    public LoginPage enterPass(String pass) {
        driver.findElement(passField).sendKeys(pass);
        return this;
    }

    public LoginPage clickInButton() {
        driver.findElement(enterButton).click();
        return new LoginPage(driver);
    }

    public String getError() {
        return driver.findElement(errar).getText();
    }

    public LoginPage loginMetod(String login, String pass) {
        this.enterLogin(login);
        this.enterPass(pass);
        clickInButton();
        return new LoginPage(driver);
    }

    public LoginPage clickReg() {
        driver.findElement(reg).click();
        return new LoginPage(driver);
    }
}
