import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {

    WebDriver driver;

    @Before
    //Тестовые прогоны были в ChromeDriver
    public void setup() {
        //подключение к браузеру Chrome
        //    WebDriverManager.chromedriver().setup();
        //  driver = new ChromeDriver();
        //  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        WebDriverManager.chromedriver().driverVersion("104.0.5112.20").setup();
        driver = new ChromeDriver(new ChromeOptions().setBinary("C:\\Users\\Евгений\\AppData\\Local" +
                "\\Yandex\\YandexBrowser\\Application\\browser.exe"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
