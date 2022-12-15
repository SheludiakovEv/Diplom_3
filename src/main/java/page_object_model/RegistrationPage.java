package page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage extends HomePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
        currentUrl = baseUrl + REGISTER;
    }

    //Веб элемент кнопки "Зарегестрироваться"
    @FindBy(xpath = ".//button[text()='Зарегистрироваться']")
    private WebElement buttonRegistration;

    //Веб элемент поля "Имя"
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement nameInputField;

    //Веб элемент поле ввода "Email"
    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement emailInputField;

    //Веб элемент поле ввода "Password"
    @FindBy(xpath = ".//fieldset[3]//input")
    private WebElement passwordInputField;

    //Веб элемент текста "Неверный пароль"
    @FindBy(xpath = ".//p[text()='Некорректный пароль']")
    private WebElement invalidPasswordError;

    //Методы
    //Ждем появления кнопки "Зарегестрироваться"
    public void expectationButtonRegistration() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(buttonRegistration));
    }

    @Step("Ввести Имя")
    public void enterName(String name) {
        nameInputField.sendKeys(name);
    }

    @Step("Ввести email")
    public void enterEmail(String email) {
        emailInputField.sendKeys(email);
    }

    @Step("Ввести пароль")
    public void enterPassword(String password) {
        passwordInputField.sendKeys(password);
    }

    @Step("Ввод всех полей Имя, email и парль регистрации")
    public void entryOfRegistrationFields(String name, String email, String password) {
        enterName(name);
        enterEmail(email);
        enterPassword(password);
    }

    @Step("Клик по кнопке регистрации")
    public void clickButtonRegistration() {
        buttonRegistration.click();
    }

    @Step("Текст ошибки Неккоректный пароль")
    public String getInvalidPasswordError() {
        return invalidPasswordError.getText();
    }

    //Ждем появления ошибки "Неверный пароль"
    public void expectationInvalidPasswordError() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(invalidPasswordError));
    }
}