package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class PersonalAccountPage {
    private final WebDriver driver;
    // Локатор кнопки "Выход"
    private final By exitButton = By.xpath("//ul[@class ='Account_list__3KQQf mb-20']/li/button");
    // Локатор Конструктор
    private final By constructorLink = By.xpath("//p[contains(text(),'Конструктор')]");
    // Локатор Логотипа
    private final By logo = By.className("AppHeader_header__logo__2D0X2");
    // Локатор текста в Личном кабинете
    private final By personalAccountText = By.xpath("//p[contains(text(),'В этом разделе вы можете изменить свои персональные данные')]");
    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }
    //  Добавили метод, кликнуть по кнопке "Выход"
    @Step("Кликнуть по кнопке Выход")
    public void clickExitButton() {
        driver.findElement(exitButton).click();
    }
    //  Добавили метод, кликнуть по Логотипу
    @Step("Кликнуть по Логотипу")
    public void clickLogo() {
        driver.findElement(logo).click();
    }
    //  Добавили метод, кликнуть по Конструктор
    public void clickConstructorLink() {
        driver.findElement(constructorLink).click();
    }
}
