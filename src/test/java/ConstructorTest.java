import Pages.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;


@RunWith(Parameterized.class)
public class ConstructorTest {

    WebDriver driver;

    private  final String attribute;



    public ConstructorTest(String attribute) {
        this.attribute = attribute;
    }

    @Parameterized.Parameters
    public static Object[][] setTestData() {
        return new Object[][] {
                {"tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"},
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
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);


    }

    @After
    public void quit() {
        driver.quit();
    }

    @Test
    public void bunTransactionSectionTest () {
    // создать объект класса главной страницы
    MainPage objMainPage = new MainPage(driver);
    objMainPage.clickFillingsSection();
    objMainPage.clickBunSection();
    String bunAttribute = objMainPage.getBunAttribute();
    Assert.assertEquals(attribute, bunAttribute);
    }

    @Test
    public void fillingTransactionSectionTest () {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickFillingsSection();
        String fillingAttribute = objMainPage.getFillingAttribute();
        Assert.assertEquals(attribute, fillingAttribute);
    }

    @Test
    public void sousesTransactionSectionTest () {
        // создать объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);
        objMainPage.clickSousesSection();
        String sousesAttribute = objMainPage.getSousesAttribute();
        Assert.assertEquals(attribute, sousesAttribute);
    }

}
