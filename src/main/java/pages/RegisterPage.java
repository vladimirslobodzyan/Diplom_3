package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RegisterPage {
    // Локатор поля "Имя"
    private By nameField = By.xpath("//label[contains(text(),'Имя')]/parent::div/input");
    // Локатор поля "Email"
    private By emailField = By.xpath("//label[contains(text(),'Email')]/parent::div/input");
    // Локатор поля "Пароль"
    private By passwordField = By.xpath("//label[contains(text(),'Пароль')]/parent::div/input");
    // Локатор поля "Некорректный пароль"
    private By invalidPasswordText = By.xpath("//fieldset/div/p[contains(text(),'Некорректный пароль')]");
    // Локатор ссылки на страницу регистрации
    private By enterLinkToLoginPage = By.xpath("//a[contains(text(),'Войти')] ");
    private final WebDriver driver;
    // Локатор кнопки "Зарегестрироваться"
    private final By registerButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    //  Добавили метод, который переходит на страницу регистрации через ссылку Войти
    @Step("Переход на страницу регистрации через ссылку Войти")
    public void clickToEnterLink() {
        driver.findElement(enterLinkToLoginPage).click();
    }
    //  Добавили метод, который вносит Имя
    @Step("Внести Имя")
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }
    //  Добавили метод, который вносит Email
    @Step("Внести Email")
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }
    //  Добавили метод, который вносит Пароль
    @Step("Внести Пароль")
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    //  Добавили метод, кликнуть по кнопке Зарегестрироваться
    @Step("Кликнуть по кнопке Зарегестрироваться")
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
    // Метод получения тексата Вход
    @Step("Получить текст Вход")
    public String getInvalidPasswordText() {
        String orderText = driver.findElement(invalidPasswordText).getText();
        return orderText;
    }
    // Создаем шаг Заполнение полей регистрации
    @Step("Заполнение полей регистрации")
    public void fillRegisterPage(String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
    }
}
