package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OrderStatusPage {
    /**
     * WebDriver
     */
    private final WebDriver webDriver;

    /**
     * Кнопка "статус заказа"
     */
    private final By orderStatusButton = By.xpath(".//div[starts-with(@class, 'Header_Nav')]/button[starts-with(@class, 'Header_Link')]");

    /**
     * Поле для ввода номера заказа
     */
    private final By orderNumberInput = By.xpath(".//div[starts-with(@class, 'Header_SearchInput')]//input[contains(@placeholder,'Введите номер заказа')]");

    /**
     * Кнопка для поиска заказа по статусу
     */
    private final By goButton = By.xpath(".//div[starts-with(@class, 'Header_SearchInput')]//button[contains(@class,'Header_Button')]");

    /**
     * Сообщение о том, что заказ не найден
     */
    private final By orderNotFoundMessage = By.xpath(".//div[starts-with(@class, 'Track_Content')]//div[contains(@class,'Track_NotFound')]");

    /**
     * Конструктор класса MainPage
     *
     * @param webDriver веб-драйвер
     */
    public OrderStatusPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Метод для нажатия на кнопку "статус заказа"
     */
    public void clickOrderStatusButton() {
        webDriver.findElement(orderStatusButton).click();
    }

    /**
     * Метод для ввода номера "заказа"
     */
    public void setOrderNumber(String number) {
        webDriver.findElement(orderNumberInput).sendKeys(number);
    }

    /**
     * Метод для нажатия на кнопку GO
     */
    public void clickGoButton() {
        webDriver.findElement(goButton).click();
    }

    /**
     * Ожидание загрузки формы ввода номера заказа
     */
    public void waitForOrderStatusInput() {
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOf(webDriver.findElement(orderNumberInput)));
    }

    /**
     * Метод, который проверяет отображение сообения об отсутствии заказа
     */
    public boolean isOrderNotFound() {
        return webDriver.findElement(orderNotFoundMessage).isDisplayed();
    }
}
