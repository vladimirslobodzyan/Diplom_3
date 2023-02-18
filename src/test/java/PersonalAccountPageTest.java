import Pages.LoginPage;
import Pages.MainPage;
import Pages.PersonalAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.MatcherAssert;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


import static org.hamcrest.CoreMatchers.containsString;


@RunWith(Parameterized.class)
public class PersonalAccountPageTest {

    private final String email;
    private final String password;

    private final String personalAccUrl;
    private final String loginUrl;
    private final String constructorUrl;

    private final String profileUrl;



    public PersonalAccountPageTest(String email, String password, String personalAccUrl, String constructorUrl, String loginUrl, String profileUrl) {
        this.email = email;
        this.password = password;
        this.personalAccUrl = personalAccUrl;
        this.constructorUrl = constructorUrl;
        this.loginUrl = loginUrl;
        this.profileUrl = profileUrl;
    }

    WebDriver driver;

    @Parameterized.Parameters
    public static Object[][] getCostumersData() {
        return new Object[][] {
                { "vladimir@yandex.ru", "123456", "https://stellarburgers.nomoreparties.site/account", "https://stellarburgers.nomoreparties.site/", "https://stellarburgers.nomoreparties.site/login", "https://stellarburgers.nomoreparties.site/account/profile"},
        };
    }

    @Before
    public void startDriver () throws InterruptedException {
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
        // Нажали на кнопку Личный кабинет
        objMainPage.clickPersonalAccountButton();
        // создать объект страницы логин;
        LoginPage loginPage = new LoginPage(driver);
        //Авторизовались
        loginPage.fillLooginPage(email, password);
        // Нажали на кнопку Личный кабинет
        objMainPage.clickPersonalAccountButton();
    }

    @After
    public void quit() {
        driver.quit();
    }


    @Test
    public void goToConstructorTest () throws InterruptedException  {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // создать объект класса страницы Личный кабинет
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickConstructorLink();
        String currentUrl = driver.getCurrentUrl();
        String constructorText = objMainPage.getOConstructorText();
        Assert.assertEquals(constructorUrl, currentUrl);
        MatcherAssert.assertThat(constructorText, containsString("Конструктор"));
    }

    @Test
    public void goToConstructorWithLogoTest () throws InterruptedException {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        // создать объект класса страницы Личный кабинет
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickLogo();
        String currentUrl = driver.getCurrentUrl();
        String constructorText = objMainPage.getOConstructorText();
        Assert.assertEquals(constructorUrl, currentUrl);
        MatcherAssert.assertThat(constructorText, containsString("Конструктор"));
    }

    @Test
    public void exitFromAccountTest () throws InterruptedException {
        // создать объект класса страницы Личный кабине
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        PersonalAccountPage personalAccountPage = new PersonalAccountPage(driver);
        personalAccountPage.clickExitButton();
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.urlContains(loginUrl));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(loginUrl, currentUrl);
    }
}
