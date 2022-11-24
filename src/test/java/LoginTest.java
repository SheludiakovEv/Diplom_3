import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page_object_model.LoginPage;
import page_object_model.MainPage;
import page_object_model.PasswordPage;
import page_object_model.RegistrationPage;

@DisplayName("Вход в приложение со страницы логина")
public class LoginTest extends BaseTest {

    PasswordPage passwordPage;
    MainPage mainPage;
    LoginPage loginPage;
    RegistrationPage registrationPage;

    private String email = "12345Qwerty@mail.ru";
    private String password = "Qwerty123!";

    @Before
    public void setUp() {
        mainPage = new MainPage(driver);
        PageFactory.initElements(driver, mainPage);

        loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);

        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);

        passwordPage = new PasswordPage(driver);
        PageFactory.initElements(driver, passwordPage);

        driver.get(mainPage.getUrl());
    }


    @Test
    @DisplayName("Логин по кнопке Войти в аккаунт")
    public void homePageButtonIn() {

        mainPage.waitSignInButton();
        mainPage.clickInButton();
        loginPage.enterEmailAndPassword(email, password);
        loginPage.clickLoginButton();
        mainPage.waitOrderButton();
        Assert.assertTrue(mainPage.isDisplayedGetOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку личный кабинет")
    public void entrancePersonalAccount() {

        mainPage.waitSignInButton();
        mainPage.clickPersonalAccount();
        loginPage.enterEmailAndPassword(email, password);
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isDisplayedGetOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме регистрации")
    public void regPageSignInLink() {

        driver.get(registrationPage.getUrl());
        registrationPage.expectationButtonRegistration();
        passwordPage.clickSignLink();
        loginPage.enterEmailAndPassword(email, password);
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isDisplayedGetOrderButton());
    }

    @Test
    @DisplayName("Вход через кнопку в форме восстановления пароля")
    public void forgotPageSignInLink() {

        driver.get(passwordPage.getUrl());
        passwordPage.clickSignLink();
        loginPage.enterEmailAndPassword(email, password);
        loginPage.clickLoginButton();
        Assert.assertTrue(mainPage.isDisplayedGetOrderButton());
    }
}
