package page_object_model;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PasswordPage extends HomePage{

    public PasswordPage(WebDriver driver) {
        super(driver);
        currentUrl = baseUrl + PASSWORD;
    }

    //Веб элемент ссылки войти
    @FindBy(linkText = "Войти")
    private WebElement signLink;

    //Методы
    @Step("Клик по ссылке Войти")
    public void clickSignLink() {
        signLink.click();
    }
}
