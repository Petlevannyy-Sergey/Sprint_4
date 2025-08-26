package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Класс описывающий главную страницу
 */
public class MainPage {
    /**
     * WebDriver
     */
    private final WebDriver webDriver;

    /**
     * Заголовок раскрывающегося элемента
     */
    private final By accordionHeaders = By.className("accordion__heading");

    /**
     * Содержание раскрывающегося блока
     */
    private final By accordionItems = By.xpath(".//*[contains(@id, 'accordion__panel')]");

    /**
     * Кнопка "Принять куки"
     */
    private final By cookieAcceptButton = By.id("rcc-confirm-button");

    /**
     * Кнопка "Заказать" в хедере сайта
     */
    private final By orderButtonInHeader = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[starts-with(@class, 'Button_Button')]");

    /**
     * Кнопка "Заказать" в хедере сайта
     */
    private final By orderButtonInBody = By.xpath(".//div[starts-with(@class, 'Home_FinishButton')]/button[starts-with(@class, 'Button_Button')]");

    /**
     * Ссылка-логотип Яндекс в хедере
     */
    private final By yandexLogoLink = By.xpath(".//div[starts-with(@class, 'Header_Logo')]/a[starts-with(@class, 'Header_LogoYandex')]");

    /**
     * Ссылка-логотип Самокат в хедере
     */
    private final By scooterLogoLink = By.xpath(".//div[starts-with(@class, 'Header_Logo')]/a[starts-with(@class, 'Header_LogoScooter')]");

    /**
     * Конструктор класса MainPage
     *
     * @param webDriver веб-драйвер
     */
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Метод для нажатия на заголовок раскрывающегося длока
     *
     * @param index Индекс элемента
     */
    public void clickAccordionHeader(int index) {
        webDriver.findElements(accordionHeaders).get(index).click();
    }

    /**
     * Метод для получения текста в заголовке раскрывающегося блока
     *
     * @param index индекс элемента
     * @return текст из заголовка раскрывающегося блока
     */
    public String getAccordionHeaderText(int index) {
        return webDriver.findElements(accordionHeaders).get(index).getText();
    }

    /**
     * Метод для получения текста в раскрывающемся блоке
     *
     * @param index индекс элемента
     * @return текст из раскрывающегося блока
     */
    public String getAccordionItemText(int index) {
        return webDriver.findElements(accordionItems).get(index).getText();
    }

    /**
     * Метод для нажатия на кнопку "Принять куки"
     */
    public void clickOnCookieAcceptButton() {
        webDriver.findElement(cookieAcceptButton).click();
    }

    /**
     * Метод для нажатия на кнопку оформления заказа в хедере сайта
     */
    public void clickOrderButtonInHeader() {
        webDriver.findElement(orderButtonInHeader).click();
    }

    /**
     * Метод для нажатия на кнопку оформления заказа в теле сайта
     */
    public void clickOrderButtonInBody() {
        webDriver.findElement(orderButtonInBody).click();
    }

    /**
     * Метод для получения ссылки из логотипа "Яндекс"
     *
     * @return ссылка
     */
    public String getYandexLogoLink() {
        return webDriver.findElement(yandexLogoLink).getAttribute("href");
    }

    /**
     * Метод для получения ссылки из логотипа "Самокат"
     *
     * @return ссылка
     */
    public String getScooterLogoLink() {
        return webDriver.findElement(scooterLogoLink).getAttribute("href");
    }
}
