package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор кнопки "Войти в аккаунт"
    private By enterToAccount = By.xpath("//button[contains(text(),'Войти в аккаунт')]");

        // Локатор кнопки "Личный Кабинет"
    private By personalAccount = By.xpath("//p[contains(text(),'Личный Кабинет')]");

    // Локатор Булки
    private By bunSection = By.xpath("//span[contains(text(),'Булки')]/parent::div");

    // Локатор Соусы
    private By sousesSection = By.xpath("//span[contains(text(),'Соусы')]/parent::div");

    // Локатор Начинки
    private By fillingSection = By.xpath("//span[contains(text(),'Начинки')]/parent::div");

    // Локатор Конструктор
    private By constructorLink = By.xpath("//p[contains(text(),'Конструктор')]");

    //  Добавили метод, кликнуть по секции булки
    public void clickBunSection() {
        driver.findElement(bunSection).click();}

    //  Добавили метод, кликнуть по секции начинка
    public void clickFillingsSection() {
        driver.findElement(fillingSection).click();}

    //  Добавили метод, кликнуть по секции соусы
    public void clickSousesSection() {
        driver.findElement(sousesSection).click();}

    //    Добавили метод, кликнуть по кнопке "Войти в аккаунт"
    public void clickEnterToAccauntButton() {
        driver.findElement(enterToAccount).click();}

    //  Добавили метод, кликнуть по кнопке "Персональный аккаунт"
    public void clickPersonalAccountButton() {
        driver.findElement(personalAccount).click();}

    public String getOConstructorText() {
        String orderText = driver.findElement(constructorLink).getText();
        return orderText;
    }

    public String getBunAttribute() {
        return driver.findElement(bunSection).getAttribute("class");
    }

    public String getSousesAttribute() {
        return driver.findElement(sousesSection).getAttribute("class");
    }

    public String getFillingAttribute() {
        return driver.findElement(fillingSection).getAttribute("class");
    }


}
