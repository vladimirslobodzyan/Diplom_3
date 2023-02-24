import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.MainPage;
import java.util.concurrent.TimeUnit;

public class ConstructorTest {

    private WebDriver driver;

    @Before
    public void startDriver() throws InterruptedException {
        //Драйвер Яндекс
        //System.setProperty("webdriver.chrome.driver","src/main/resources/yandexdriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        //driver = new FirefoxDriver();
        // Разернули окно
        driver.manage().window().maximize();
        // Переход на главную страницу
        driver.get("https://stellarburgers.nomoreparties.site/");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    }

    @After
    public void quit() {
       driver.quit();
    }

    @Test
    @DisplayName("Переход к разделу Булки")
    public void bunTransactionSectionTest() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFillingsSection();
        objMainPage.clickBunSection();
        boolean bunIsVisible = objMainPage.getBunAttribute();
        Assert.assertEquals(true, bunIsVisible);
    }

    @Test
    @DisplayName("Переход к разделу Начинка")
    public void fillingTransactionSectionTest() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFillingsSection();
        boolean fillingIsVisible = objMainPage.getFillingAttribute();
        Assert.assertEquals(true, fillingIsVisible);
    }

    @Test
    @DisplayName("Переход к разделу Соусы")
    public void sousesTransactionSectionTest() {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSousesSection();
        boolean souseIsVisible = objMainPage.getSousesAttribute();
        Assert.assertEquals(true, souseIsVisible);
    }

}
