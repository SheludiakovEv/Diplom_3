import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import page_object_model.LoginPage;
import page_object_model.RegistrationPage;

import java.time.Duration;

@DisplayName("Регистрация нового пользователя")
public class RegistrationTest extends BaseTest {

    RegistrationPage registrationPage;

    private final String name = "Евгений";
    private String email = RandomStringUtils.randomAlphanumeric(8) + "@mail.ru";

    private String password;

    @Before
    public void setUp() {
        registrationPage = new RegistrationPage(driver);
        PageFactory.initElements(driver, registrationPage);
        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        driver.get(registrationPage.getUrl());
        registrationPage.expectationButtonRegistration();
    }

    @Test
    @DisplayName("Создание пользователя с корректным паролем")
    public void createUserWithCorrectPassword() {
        password = RandomStringUtils.randomAlphanumeric(7);
        registrationPage.entryOfRegistrationFields(name, email, password);
        registrationPage.clickButtonRegistration();

        LoginPage loginPage = new LoginPage(driver);
        PageFactory.initElements(driver, loginPage);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
        Assert.assertTrue(loginPage.loginButtonDisplay());
    }

    @Test
    @DisplayName("Проверка ошибки поля Пароль при создании пользователя")
    public void createUserWithIncorrectPassword() {
        password = RandomStringUtils.randomAlphanumeric(5);

        registrationPage.entryOfRegistrationFields(name, email, password);
        registrationPage.clickButtonRegistration();

        registrationPage.expectationInvalidPasswordError();
        Assert.assertEquals("Некорректный пароль", registrationPage.getInvalidPasswordError());
    }
}
