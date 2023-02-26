package pages;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class RecoveryPage {
    private final WebDriver driver;
    // Локатор кнопки "Войти"
    private final By enterToAccount = By.xpath("//a[contains(text(),'Войти')]");
    public RecoveryPage(WebDriver driver) {
        this.driver = driver;
    }
    //  Добавили метод, который переходит на страницу регистрации через ссылку Войти
    @Step("Переход на страницу Войти")
    public void clickToEnterLinkInRecoveryPage() {
        driver.findElement(enterToAccount).click();
    }
}
