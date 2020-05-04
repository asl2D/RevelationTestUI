package open;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * �������� ������ Google.
 */
public class SearchPage {
    private WebDriver driver;

    SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    // ���� ������.
    @FindBy(xpath = "//*[@title='�����']")
    public WebElement searchField;

    //������ "����� � Google".
    @FindBy(xpath = "//div[@class = 'tfB0Bf']//*[@value='����� � Google']")
    public WebElement searchButton;

    //��������� ��������� ������.
    @FindBy(xpath = "//*[@class='g']//a[@href='https://www.open.ru/']")
    public WebElement expectedSearchResult;

    //��������� �������� �������� �� ����������� ������.
    public HomePage openHomePage(){
        expectedSearchResult.click();
        return new HomePage(driver);
    }

    /**
     * ������ ������ �� ��������� � ���� ������ � ��������� � �����������.
     *
     * @param search ��������� ������.
     */
    public void search(String search) {
        searchField.sendKeys(search);
        searchButton.click();
    }
}
