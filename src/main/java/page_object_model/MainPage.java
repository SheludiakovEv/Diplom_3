package page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage extends HomePage {

    public MainPage(WebDriver driver) {
        super(driver);
        currentUrl = baseUrl;
    }


    //Логотип
    @FindBy(xpath = ".//div[@class = 'AppHeader_header__logo__2D0X2']")
    private WebElement logo;

    //кнопка Войти в аккаунт
    @FindBy(xpath = ".//button[text()='Войти в аккаунт']")
    private WebElement inButton;

    //Булки
    @FindBy(xpath = ".//div/span[text()='Булки']")
    private WebElement bunSection;

    // Личный кабинет
    @FindBy(xpath = ".//p[text() = 'Личный Кабинет']")
    private WebElement personalArea;

    //Соусы
    @FindBy(xpath = ".//div/span[text()='Соусы']")
    private WebElement sauceSection;

    //текущий раздел
    @FindBy(xpath = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span")
    private WebElement currentSection;

    //Начинки
    @FindBy(xpath = ".//div/span[text()='Начинки']")
    private WebElement fillingSection;

    //кнопка Оформить заказ
    @FindBy(xpath = ".//button[text() = 'Оформить заказ']")
    private WebElement orderButton;

    //Методы
    //Ожидаем появления кнопки "Оформить заказ"
    public void waitOrderButton() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOf(orderButton));
    }

    @Step("Клик по логотипу")
    public void clickLogo() {
        logo.click();
    }

    @Step("Клик на кнопку Войти в аккаунт")
    public void clickInButton() {
        inButton.click();
    }

    @Step("Клик по кнопке Личный кабинет")
    public void clickPersonalAccount() {
        personalArea.click();
    }

    @Step("Получить название активного раздела ингредиентов")
    public String getCurrentTab() {
        return currentSection.getText();
    }

    @Step("Клик на раздел Булки")
    public void clickBunTab() {
        bunSection.click();
    }

    @Step("Клик на раздел Соусы")
    public void clickSaucesTab() {
        sauceSection.click();
    }

    @Step("Клик на раздел Начинки")
    public void clickFillingTab() {
        fillingSection.click();
    }

    @Step("Кнопка Оформить заказ отображается")
    public boolean isDisplayedGetOrderButton() {
        return orderButton.isDisplayed();
    }

    //Ждем появления кнопки Вход
    public void waitSignInButton() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(inButton));
    }
}