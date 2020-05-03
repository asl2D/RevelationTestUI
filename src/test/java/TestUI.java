import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestUI {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        String driverPath = "src/test/resources/webdriver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void exchangeRateTest() throws InterruptedException {
        String searchURL = "https://www.google.com/";
        String searchTerm = "Открытие";
        driver.get(searchURL);
        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(searchTerm);
        Assert.assertTrue(searchPage.expectedSearchResult.isDisplayed());
        HomePage homePage = searchPage.openHomePage();
        Assert.assertTrue(homePage.verifyExchangeRateUSD());
        Assert.assertTrue(homePage.verifyExchangeRateEUR());
        driver.close();
    }
}