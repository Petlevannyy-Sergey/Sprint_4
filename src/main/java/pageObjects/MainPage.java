package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/** Класс описывающий главную страницу */
public class MainPage {
    /** WebDriver */
    private final WebDriver webDriver;

    /** Заголовок раскрывающегося элемента */
    private final By accordionHeaders = By.className("accordion__heading");

    /** Содержание раскрывающегося блока */
    private final By accordionItems = By.xpath(".//*[contains(@id, 'accordion__panel')]");

    /** Кнопка "Принять куки" */
    private final By cookieAcceptButton = By.id("rcc-confirm-button");

    /**
     * Конструктор класса MainPage
     * @param webDriver веб-драйвер
     */
    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Метод для нажатия на заголовок раскрывающегося длока
     * @param index Индекс элемента
     * */
    public void clickAccordionHeader(int index) {
        webDriver.findElements(accordionHeaders).get(index).click();
    }

    /**
     * Метод для получения текста в заголовке раскрывающегося блока
     * @param index индекс элемента
     * @return текст из заголовка раскрывающегося блока
     */
    public String getAccordionHeaderText(int index) {
        return this.webDriver.findElements(accordionHeaders).get(index).getText();
    }

    /**
     * Метод для получения текста в раскрывающемся блоке
     * @param index индекс элемента
     * @return текст из раскрывающегося блока
     * */
    public String getAccordionItemText(int index) {
        return this.webDriver.findElements(accordionItems).get(index).getText();
    }

    /**
     * Метод для нажатия на кнопку "Принять куки"
     */
    public void clickOnCookieAcceptButton() {
        this.webDriver.findElement(cookieAcceptButton).click();
    }

}
