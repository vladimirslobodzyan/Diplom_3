package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage {

    // Локатор поля "Email"
    private By emailField = By.xpath("//label[contains(text(),'Email')]/parent::div/input");
    // Локатор поля "Пароль"
    private By passwordField = By.xpath("//label[contains(text(),'Пароль')]/parent::div/input");
    private final WebDriver driver;
    // Локатор текста "Зарегестрироваться"
    private final By registerLoginPageText = By.xpath("//a[contains(text(),'Зарегистрироваться')]");
    // Локатор кнопки "Войти"
    private final By enterButton = By.xpath("//button[contains(text(),'Войти')]");
    // Локатор текста "Вход"
    private final By orderEnterLoginPageText = By.xpath("//*[@id='root']/div/main/div/h2");
    // Локатор Восстановить пароль
    private final By recoveryLoginText = By.xpath("//a[contains(text(),'Восстановить пароль')]");
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    // Метод получения тексата Вход
    public String getOrderSocsessText() {
        String orderText = driver.findElement(orderEnterLoginPageText).getText();
        return orderText;
    }
    //  Добавили метод, кликнуть по кнопке "Зарегестрироваться"
    @Step("кликнуть по кнопке Зарегестрироваться")
    public void clickRegisterLoginPageTextButton() {
        driver.findElement(registerLoginPageText).click();
    }
    //  Добавили метод, кликнуть по кнопке "Войти"
    @Step("кликнуть по кнопке Войти")
    public void clickEnterButton() {
        driver.findElement(enterButton).click();
    }
    //  Добавили метод, кликнуть по кнопке "Восстановить пароль"
    @Step("кликнуть по кнопке Восстановить пароль")
    public void clickRecoveryPassText() {
        driver.findElement(recoveryLoginText).click();
    }
    //  Добавили метод, который вносит Email
    @Step("внесли Email")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    //  Добавили метод, который вносит Пароль
    @Step("внесли Пароль")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    // Создаем шаг Заполнение полей страницы логин
    @Step("Заполнить данными страницу Вход")
    public void fillLooginPage(String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickEnterButton();
    }
}

