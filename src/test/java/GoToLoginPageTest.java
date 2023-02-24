import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LoginPage;
import pages.MainPage;
import pages.RecoveryPage;
import pages.RegisterPage;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class GoToLoginPageTest {
    private final String constructorUrl;
    private WebDriver driver;

    public GoToLoginPageTest(String constructorUrl) {
        this.constructorUrl = constructorUrl;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] getCostumersData() {
        return new Object[][]{
                {"https://stellarburgers.nomoreparties.site/login"},
        };
    }

    @Before
    public void startDriver() {
        //Драйвер Яндекс
        //System.setProperty("webdriver.chrome.driver","src/main/resources/yandexdriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver = new FirefoxDriver();
        // Разернули окно
        driver.manage().window().maximize();
        // Переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site/");
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
    }

    @After
    public void quit() {
        driver.quit();
    }

    @Test
    @DisplayName("Вход по кнопке Войти")
    public void goToLoginWithAccauntButtonTest() throws InterruptedException {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Нажали на кнопку войти в аккаунт
        objMainPage.clickEnterToAccauntButton();
        // создать объект страницы логин;
        LoginPage loginPage = new LoginPage(driver);
        //получение текста из подтверждения заказа
        String orderText = loginPage.getOrderSocsessText();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(constructorUrl, currentUrl);
        Assert.assertThat(orderText, containsString("Вход"));
    }

    @Test
    @DisplayName("Вход по кнопке Личный кабинет")
    public void goToLoginWithPersonalAccountButtonTest() throws InterruptedException {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Нажали на кнопку войти в аккаунт
        objMainPage.clickPersonalAccountButton();
        // создать объект страницы логин;
        LoginPage loginPage = new LoginPage(driver);
        //получение текста из подтверждения заказа
        String orderText = loginPage.getOrderSocsessText();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(constructorUrl, currentUrl);
        Assert.assertThat(orderText, containsString("Вход"));
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void goToLoginWithEnterLink() throws InterruptedException {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Нажали на кнопку войти в аккаунт
        objMainPage.clickEnterToAccauntButton();
        // создать объект страницы логин;
        LoginPage loginPage = new LoginPage(driver);
        // Нажали на кнопку зарегестрироваться
        loginPage.clickRegisterLoginPageTextButton();
        // создать объект страницы регистрация;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        RegisterPage registerPage = new RegisterPage(driver);
        // Нажать кнопку Вход
        registerPage.clickToEnterLink();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //получение текста из подтверждения заказа
        String orderText = loginPage.getOrderSocsessText();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(constructorUrl, currentUrl);
        Assert.assertThat(orderText, containsString("Вход"));
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void LoginFromRecoveryPageTest() throws InterruptedException {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // Нажали на кнопку войти в аккаунт
        objMainPage.clickEnterToAccauntButton();
        // создать объект страницы логин;
        LoginPage loginPage = new LoginPage(driver);
        // Нажали на кнопку зарегестрироваться
        loginPage.clickRecoveryPassText();
        // создать объект страницы регистрация;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        RecoveryPage recoveryPage = new RecoveryPage(driver);
        // Нажать кнопку Вход
        recoveryPage.clickToEnterLinkInRecoveryPage();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //получение текста из подтверждения заказа
        String orderText = loginPage.getOrderSocsessText();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(constructorUrl, currentUrl);
        Assert.assertThat(orderText, containsString("Вход"));
    }
}
