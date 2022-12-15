package page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage extends HomePage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        super(driver);
        currentUrl = baseUrl + LOGIN;
    }

    //Веб элемент поля Email
    @FindBy(xpath = ".//fieldset[1]//input")
    private WebElement emailField;

    //Веб элемент поля Пароль
    @FindBy(xpath = ".//fieldset[2]//input")
    private WebElement passwordField;

    //Веб элемент кнопки входа
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/form/button")
    private WebElement loginButton;

    //Методы
    //Метод ожидания кнопки Войти
    public void expectedLoginButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(loginButton));
    }

    @Step("Ввод почты")
    public void mailFieldInput(String email) {
        emailField.sendKeys(email);
    }

    @Step("Ввод пароля")
    public void passwordFieldInput(String password) {
        passwordField.sendKeys(password);
    }

    @Step("Ввод полей email и пароль")
    public void enterEmailAndPassword(String email, String password) {
        mailFieldInput(email);
        passwordFieldInput(password);
    }

    @Step("Клик по кнопке Войти")
    public void clickLoginButton() {
        loginButton.click();
    }

    @Step("Отображение кноки Входа")
    public boolean loginButtonDisplay() {
        return loginButton.isDisplayed();
    }
}
