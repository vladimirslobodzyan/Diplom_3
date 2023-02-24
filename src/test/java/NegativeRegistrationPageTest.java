import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
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
import pages.RegisterPage;
import java.util.concurrent.TimeUnit;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class NegativeRegistrationPageTest {
    private final int passNumbers;
    private WebDriver driver;
    private String name;
    private String email;
    private String password;

    public NegativeRegistrationPageTest(int passNumbers) {
        this.passNumbers = passNumbers;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}")
    public static Object[][] setTestData() {
        return new Object[][]{
                {5},
                {3},
                {1},
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
    @DisplayName("Ошибка для некорректного пароля")
    public void invalidRegistrationTest() throws InterruptedException {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        email = RandomStringUtils.randomAlphanumeric(8) + "@yandex.ru";
        password = RandomStringUtils.randomAlphabetic(passNumbers);
        name = RandomStringUtils.randomAlphabetic(8);
        // Нажали на кнопку войти в аккаунт
        objMainPage.clickEnterToAccauntButton();
        // создать объект страницы логин;
        LoginPage loginPage = new LoginPage(driver);
        // Нажали на кнопку войти в аккаунт
        loginPage.clickRegisterLoginPageTextButton();
        // создать объект страницы регистрация;
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        RegisterPage registerPage = new RegisterPage(driver);
        // Заполнили форму регистрации
        registerPage.fillRegisterPage(name, email, password);
        // Нажать кнопку Регистрация
        registerPage.clickRegisterButton();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        //получение текста из подтверждения заказа
        String orderText = registerPage.getInvalidPasswordText();
        Assert.assertThat(orderText, containsString("Некорректный пароль"));
    }
}
