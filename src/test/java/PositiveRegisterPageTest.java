import Pages.MainPage;
import Pages.LoginPage;
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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class PositiveRegisterPageTest {

    private  String name;
    private  String email;
    private  String password;
    private final int passNumbers;

    private final String loginUrl;

    public PositiveRegisterPageTest(int passNumbers, String loginUrl) {

        this.passNumbers = passNumbers;
        this.loginUrl = loginUrl;
    }




    WebDriver driver;

    @Parameterized.Parameters
    public static Object[][] setTestData() {
        return new Object[][] {
                {6,"https://stellarburgers.nomoreparties.site/login"},
                {7, "https://stellarburgers.nomoreparties.site/login"},
                {100, "https://stellarburgers.nomoreparties.site/login"},
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



    }

    @After
    public void quit() {
   driver.quit();
   }

    @Test
    public void validRegistrationTest () throws InterruptedException {
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
        RegisterPage registerPage = new RegisterPage(driver);
        //driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        // Заполнили форму регистрации
        registerPage.fillRegisterPage(name, email, password);
        // Нажать кнопку Регистрация
        registerPage.clickRegisterButton();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains(loginUrl));
        //получение текста из подтверждения заказа
        String orderText = loginPage.getOrderSocsessText();
        MatcherAssert.assertThat(orderText, containsString("Вход"));
    }




}

