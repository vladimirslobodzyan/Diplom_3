package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор текста "Зарегестрироваться"
    private By registerLoginPageText = By.xpath("//a[contains(text(),'Зарегистрироваться')]");

    // Локатор кнопки "Войти"
    private By enterButton = By.xpath("//button[contains(text(),'Войти')]");

    // Локатор текста "Вход"
    private By orderEnterLoginPageText = By.xpath("//*[@id='root']/div/main/div/h2");

    // Локатор Восстановить пароль
    private By recoveryLoginText = By.xpath("//a[contains(text(),'Восстановить пароль')]");

    // Локатор поля "Email"
    public By emailField = By.xpath("//label[contains(text(),'Email')]/parent::div/input");

    // Локатор поля "Пароль"
    public By passwordField = By.xpath("//label[contains(text(),'Пароль')]/parent::div/input");

    // Метод получения тексата Вход
    public String getOrderSocsessText() {
        String orderText = driver.findElement(orderEnterLoginPageText).getText();
        return orderText;
    }

    //  Добавили метод, кликнуть по кнопке "Зарегестрироваться"
    public void clickRegisterLoginPageTextButton() {
        driver.findElement(registerLoginPageText).click();}

    //  Добавили метод, кликнуть по кнопке "Войти"
    public void clickEnterButton() {
        driver.findElement(enterButton).click();}

    //  Добавили метод, кликнуть по кнопке "Восстановить пароль"
    public void clickRecoveryPassText() {
        driver.findElement(recoveryLoginText).click();}

    //  Добавили метод, который вносит Email
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //  Добавили метод, который вносит Пароль
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    // Создаем шаг Заполнение полей страницы логин
    public void fillLooginPage (String email, String password) {
        setEmailField(email);
        setPasswordField(password);
        clickEnterButton();
    }
}

