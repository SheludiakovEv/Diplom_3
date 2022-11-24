import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page_object_model.MainPage;

@DisplayName("Переключение вкладко конструктора")
public class ConstructorTest extends BaseTest {

    MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getUrl());
        mainPage.waitSignInButton();
    }

    @Test
    @DisplayName("Переключение на вкладку Соусы")
    public void sauceTabSwitch() {
        mainPage.clickSaucesTab();
        Assert.assertEquals("Соусы", mainPage.getCurrentTab());
    }

    @Test
    @DisplayName("Переключение на вкладку Булки")
    public void bunTabSwitch() {
        mainPage.clickFillingTab(); //переключил вкладку, тк вкладка Булки установлена по дефолту
        mainPage.clickBunTab();
        Assert.assertEquals("Булки", mainPage.getCurrentTab());
    }

    @Test
    @DisplayName("Переключение на вкладку Начинки")
    public void fillingTabSwitch() {
        mainPage.clickFillingTab();
        Assert.assertEquals("Начинки", mainPage.getCurrentTab());
    }
}
