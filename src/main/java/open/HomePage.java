package open;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * √лавна€ страница сайта.
 */
public class HomePage {
    HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //€чейка таблицы курс обмена - покупка USD.
    @FindBy(xpath = "(//*[@class='main-page-exchange main-page-info__card']//*[@class='main-page-exchange__rate'])[1]")
    private WebElement exchangeRateUSDBuy;

    //€чейка таблицы курс обмена - продажа USD.
    @FindBy(xpath = "(//*[@class='main-page-exchange main-page-info__card']//*[@class='main-page-exchange__rate'])[2]")
    private WebElement exchangeRateUSDSell;

    //€чейка таблицы курс обмена - покупка EUR.
    @FindBy(xpath = "(//*[@class='main-page-exchange main-page-info__card']//*[@class='main-page-exchange__rate'])[3]")
    private WebElement exchangeRateEURBuy;

    //€чейка таблицы курс обмена - продажа EUR.
    @FindBy(xpath = "(//*[@class='main-page-exchange main-page-info__card']//*[@class='main-page-exchange__rate'])[4]")
    private WebElement exchangeRateEURSell;

    public float getExchangeRateUSDBuy() {
        return Float.parseFloat(exchangeRateUSDBuy.getText().replace(',', '.'));
    }

    public float getExchangeRateUSDSell() {
        return Float.parseFloat(exchangeRateUSDSell.getText().replace(',', '.'));
    }

    public float getExchangeRateEURBuy() {
        return Float.parseFloat(exchangeRateEURBuy.getText().replace(',', '.'));
    }

    public float getExchangeRateEURSell() {
        return Float.parseFloat(exchangeRateEURSell.getText().replace(',', '.'));
    }
}
