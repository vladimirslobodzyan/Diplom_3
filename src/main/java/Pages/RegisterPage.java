package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {

    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор кнопки "Зарегестрироваться"
    private By registerButton = By.xpath("//button[contains(text(),'Зарегистрироваться')]");

    // Локатор поля "Имя"
    public By nameField = By.xpath("//label[contains(text(),'Имя')]/parent::div/input");

    // Локатор поля "Email"
    public By emailField = By.xpath("//label[contains(text(),'Email')]/parent::div/input");

    // Локатор поля "Пароль"
    public By passwordField = By.xpath("//label[contains(text(),'Пароль')]/parent::div/input");
    // Локатор поля "Некорректный пароль"
    public By invalidPasswordText = By.xpath("//fieldset/div/p[contains(text(),'Некорректный пароль')]");

    // Локатор ссылки на страницу регистрации
    public By enterLinkToLoginPage = By.xpath("//a[contains(text(),'Войти')] ");

    //  Добавили метод, который переходит на страницу регистрации через ссылку Войти
    public void clickToEnterLink() {
        driver.findElement(enterLinkToLoginPage).click();}


    //  Добавили метод, который вносит Имя
    public void setNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    //  Добавили метод, который вносит Email
    public void setEmailField(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    //  Добавили метод, который вносит Пароль
    public void setPasswordField(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    //  Добавили метод, кликнуть по кнопке Зарегестрироваться
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();}

    // Метод получения тексата Вход
    public String getInvalidPasswordText() {
        String orderText = driver.findElement(invalidPasswordText).getText();
        return orderText;
    }

    // Создаем шаг Заполнение полей регистрации
    public void fillRegisterPage (String name, String email, String password) {
        setNameField(name);
        setEmailField(email);
        setPasswordField(password);
    }
}
