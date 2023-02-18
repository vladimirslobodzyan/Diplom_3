import Pages.LoginPage;
import Pages.MainPage;
import Pages.RegisterPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class NegativeRegistrationPageTest {
    private  String name;
    private  String email;
    private  String password;
    private final int passNumbers;

    public NegativeRegistrationPageTest(int passNumbers) {
        this.passNumbers = passNumbers;
    }


    WebDriver driver;

    @Parameterized.Parameters
    public static Object[][] setTestData() {
        return new Object[][] {
                {5},
                {3},
                {1},
        };
    }


    @Before
    public void startDriver () {
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
    public void invalidRegistrationTest () throws InterruptedException {
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
        MatcherAssert.assertThat(orderText, containsString("Некорректный пароль"));
    }
}
