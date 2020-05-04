package open;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Страница поиска Google.
 */
public class SearchPage {
    private WebDriver driver;

    SearchPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver=driver;
    }

    // Поле поиска.
    @FindBy(xpath = "//*[@title='Поиск']")
    public WebElement searchField;

    //Кнопка "Поиск в Google".
    @FindBy(xpath = "//div[@class = 'tfB0Bf']//*[@value='Поиск в Google']")
    public WebElement searchButton;

    //Ожидаемый результат поиска.
    @FindBy(xpath = "//*[@class='g']//a[@href='https://www.open.ru/']")
    public WebElement expectedSearchResult;

    //Открывает домашнюю страницу из результатов поиска.
    public HomePage openHomePage(){
        expectedSearchResult.click();
        return new HomePage(driver);
    }

    /**
     * Вводит строку из аргумента в поле поиска и переходит к результатам.
     *
     * @param search поисковый запрос.
     */
    public void search(String search) {
        searchField.sendKeys(search);
        searchButton.click();
    }
}
