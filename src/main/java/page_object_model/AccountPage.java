package page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AccountPage extends HomePage {

    public AccountPage(WebDriver driver) {
        super(driver);
        currentUrl = baseUrl + PROFILE;
    }

    //Веб элемент ссылки Профиль
    @FindBy(linkText = "Профиль")
    private WebElement profileLink;

    //Веб элемент текста в профиле
    @FindBy(xpath = "//*[@id=\"root\"]/div/main/div/nav/p")
    private WebElement textAccount;

    //Веб элемент для кнопки Выход
    @FindBy(xpath = ".//button[text()='Выход']")
    private WebElement buttonExit;

    //Веб элемент Конструктора
    @FindBy(xpath = ".//p[text() = 'Конструктор']")
    private WebElement constructor;

    //Методы
    //Ждем веб элемент ссылку профиля
    public void waitProfileLink() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(profileLink));
    }

    @Step("Нажимаем кнопку выхода")
    public void clickButtonExit() {
        buttonExit.click();
    }

    @Step("Создать конструктор")
    public void clickConstructor() {
        constructor.click();
    }

    @Step("Текст со старницы Профиля")
    public String getTextAccount() {
        return textAccount.getText();
    }
}
