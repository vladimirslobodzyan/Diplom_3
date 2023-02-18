package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPage {

    private WebDriver driver;

    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }

    // Локатор кнопки "Войти"
    private By enterToAccount = By.xpath("//a[contains(text(),'Войти')]");

    //  Добавили метод, который переходит на страницу регистрации через ссылку Войти
    public void clickToEnterLinkInRecoveryPage() {
        driver.findElement(enterToAccount).click();}
}
