package page_object_model;

import org.openqa.selenium.WebDriver;

public class HomePage {

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;

    protected static final String baseUrl = "https://stellarburgers.nomoreparties.site/";

    protected String currentUrl;

    public String getUrl() {
        return currentUrl;
    }

    //Перечисление для подстановки в URL
    public static final String LOGIN = "login";
    public static final String PASSWORD = "forgot-password";
    public static final String PROFILE = "account/profile";
    public static final String REGISTER = "register";
}