package open;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestUI {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = Driver.init();
    }

    @Test
    public void exchangeRateTest() throws InterruptedException {
        driver.get(TestData.getSearchUrl());

        SearchPage searchPage = new SearchPage(driver);
        searchPage.search(TestData.getSearchTerm());
        Assert.assertTrue(searchPage.expectedSearchResult.isDisplayed());
        HomePage homePage = searchPage.openHomePage();

        Assert.assertTrue(homePage.getExchangeRateUSDBuy() > homePage.getExchangeRateUSDSell());
        Assert.assertTrue(homePage.getExchangeRateEURBuy() > homePage.getExchangeRateEURSell());
    }

    @AfterClass
    public void teardown() {
        driver.close();
    }
}