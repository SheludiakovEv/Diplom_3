import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page_object_model.AccountPage;
import page_object_model.LoginPage;
import page_object_model.MainPage;
import java.time.Duration;

@DisplayName("Личный кабинет")
public class AccountTest extends BaseTest {

    private String email = "12345Qwerty@mail.ru";
    private String password = "Qwerty123!";

    LoginPage loginPage;
    AccountPage accountPage;
    MainPage mainPage;

    @Before //Подготовка тестовых данных
    public void setUp() {

        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);
        driver.get(mainPage.getUrl());
        mainPage.waitSignInButton();
        mainPage.clickInButton();

        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        loginPage.enterEmailAndPassword(email, password);  //залогинился в прложении
        loginPage.clickLoginButton();
        mainPage.waitOrderButton();

        mainPage.clickPersonalAccount();  //перейти в профиль
        accountPage = new AccountPage(driver);
        PageFactory.initElements(driver, accountPage);
        accountPage.waitProfileLink();
    }

    @Test
    @DisplayName("Переход в профиль по клику на кнопку Личный кабинет")
    public void clickPersonalAccountButton() {
        Assert.assertEquals("В этом разделе вы можете изменить свои персональные данные", accountPage.getTextAccount());
    }

    @Test
    @DisplayName("Переход из личного кабинета в конструктор")
    public void constructorFromPersonalAccount() {
        accountPage.clickConstructor();
        mainPage.waitOrderButton();
        Assert.assertEquals("Булки", mainPage.getCurrentTab());
    }

    @Test
    @DisplayName("Клик из личного кабинета по лого")
    public void clickOnTheLogo() {
        mainPage.clickLogo();
        Assert.assertEquals("Булки", mainPage.getCurrentTab());
    }

    @Test
    @DisplayName("Выход из личного кабинета")
    public void exitFromPersonalAccount() {
        accountPage.clickButtonExit();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Assert.assertTrue(loginPage.loginButtonDisplay());
    }
}
