package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class MainPage {
    private final WebDriver driver;
    // Локатор кнопки "Войти в аккаунт"
    private final By enterToAccount = By.xpath("//button[contains(text(),'Войти в аккаунт')]");
    // Локатор кнопки "Личный Кабинет"
    private final By personalAccount = By.xpath("//p[contains(text(),'Личный Кабинет')]");
    // Локатор Булки
    private final By bunSection = By.xpath("//span[contains(text(),'Булки')]/parent::div");
    // Локатор Соусы
    private final By sousesSection = By.xpath("//span[contains(text(),'Соусы')]/parent::div");
    // Локатор Начинки
    private final By fillingSection = By.xpath("//span[contains(text(),'Начинки')]/parent::div");
    // Локатор Конструктор
    private final By constructorLink = By.xpath("//p[contains(text(),'Конструктор')]");
    public MainPage(WebDriver driver) {
        this.driver = driver;
    }
    //  Добавили метод, кликнуть по секции булки
    @Step("кликнуть по секции Булки")
    public void clickBunSection() {
        driver.findElement(bunSection).click();
    }
    //  Добавили метод, кликнуть по секции начинка
    @Step("кликнуть по секции Начинка")
    public void clickFillingsSection() {
        driver.findElement(fillingSection).click();
    }
    //  Добавили метод, кликнуть по секции соусы
    @Step("кликнуть по секции Соусы")
    public void clickSousesSection() {
        driver.findElement(sousesSection).click();
    }
    //    Добавили метод, кликнуть по кнопке "Войти в аккаунт"
    @Step("кликнуть по кнопке Войти в аккаунт")
    public void clickEnterToAccauntButton() {
        driver.findElement(enterToAccount).click();
    }
    //  Добавили метод, кликнуть по кнопке "Персональный аккаунт"
    @Step("кликнуть по кнопке Персональный аккаунт")
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccount).click();
    }
    @Step("Получить текст из конструктора")
    public String getOConstructorText() {
        String orderText = driver.findElement(constructorLink).getText();
        return orderText;
    }
    @Step("Проверка вкладки Булки")
    public boolean getBunAttribute() {
        boolean bunVisible = driver.findElement(bunSection).isDisplayed();
        return bunVisible;
    }
    @Step("Проверка вкладки Соуса")
    public boolean getSousesAttribute() {
        boolean souseVisible = driver.findElement(sousesSection).isDisplayed();
        return souseVisible;
    }
    @Step("Проверка вкладки Начинки")
    public boolean getFillingAttribute() {
        boolean fillingVisible = driver.findElement(fillingSection).isDisplayed();
        return fillingVisible;
    }
}
