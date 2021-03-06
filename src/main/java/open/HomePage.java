package open;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * ������� �������� �����.
 */
public class HomePage {
    HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //������ ������� ���� ������ - ������� USD.
    @FindBy(xpath = "(//*[@class='main-page-exchange main-page-info__card']//*[@class='main-page-exchange__rate'])[1]")
    private WebElement exchangeRateUSDBuy;

    //������ ������� ���� ������ - ������� USD.
    @FindBy(xpath = "(//*[@class='main-page-exchange main-page-info__card']//*[@class='main-page-exchange__rate'])[2]")
    private WebElement exchangeRateUSDSell;

    //������ ������� ���� ������ - ������� EUR.
    @FindBy(xpath = "(//*[@class='main-page-exchange main-page-info__card']//*[@class='main-page-exchange__rate'])[3]")
    private WebElement exchangeRateEURBuy;

    //������ ������� ���� ������ - ������� EUR.
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
