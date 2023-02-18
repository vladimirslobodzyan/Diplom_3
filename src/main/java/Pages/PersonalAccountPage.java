package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {

    private WebDriver driver;

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор кнопки "Выход"
    private By exitButton = By.xpath("//ul[@class ='Account_list__3KQQf mb-20']/li/button");

    // Локатор Конструктор
    private By constructorLink = By.xpath("//p[contains(text(),'Конструктор')]");

    // Локатор Логотипа
    private By logo = By.className("AppHeader_header__logo__2D0X2");

    // Локатор текста в Личном кабинете
    private By personalAccountText = By.xpath("//p[contains(text(),'В этом разделе вы можете изменить свои персональные данные')]");

    //  Добавили метод, кликнуть по кнопке "Выход"
    public void clickExitButton() {
        driver.findElement(exitButton).click();}

    //  Добавили метод, кликнуть по Логотипу
    public void clickLogo() {
        driver.findElement(logo).click();}

    //  Добавили метод, кликнуть по Конструктор
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();}
}
