package open;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/**
 * Класс конфигурации веб драйвера.
 */
public class Driver {
    private static final String DRIVER_PATH = "src/test/resources/webdriver/chromedriver.exe";
    private static final String DRIVER_TYPE = "webdriver.chrome.driver";
    private static final int TIMEOUT = 20;

    public static WebDriver init() {
        System.setProperty(DRIVER_TYPE, DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        return driver;
    }
}
