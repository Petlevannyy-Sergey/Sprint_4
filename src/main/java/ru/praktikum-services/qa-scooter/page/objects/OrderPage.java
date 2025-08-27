package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

/**
 * Тест для проверки позитивного сценария оформления заказа
 */
public class OrderPage {
    /**
     * Веб-драйвер
     */
    private WebDriver webDriver;

    /**
     * Форма заказа
     */
    private final By orderForm = By.xpath(".//div[starts-with(@class, 'Order_Form')]");

    /**
     * Поле для ввода имени
     */
    private final By nameInput = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Имя')]");

    /**
     * Поле отображения ошибки ввода имени
     */
    private final By nameInputError = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Имя')]/following-sibling::div[starts-with(@class, 'Input_ErrorMessage')]");


    /**
     * Поле для ввода фамилии
     */
    private final By surnameInput = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Фамилия')]");

    /**
     * Поле отображения ошибки ввода в поле фамилии
     */
    private final By surnameInputError = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Фамилия')]/following-sibling::div[starts-with(@class,'Input_ErrorMessage')]");

    /**
     * Поле для ввода адреса
     */
    private final By addressInput = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Адрес')]");

    /**
     * Поле отображения ошибки ввода в поле адрес
     */
    private final By addressInputError = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Адрес')]/following-sibling::div[starts-with(@class,'Input_ErrorMessage')]");

    /**
     * Поле для ввода станции метро
     */
    private final By metroInput = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Станция метро')]");

    /**
     * Поле отображения ошибки ввода в поле метро
     */
    private final By metroInputError = By.xpath(".//div[starts-with(@class, 'Order_UnderError')]/div[starts-with(@class,'Order_MetroError')]");

    /**
     * Список станций метро
     */
    private final By metroSelectedItems = By.className("select-search__select");

    /**
     * Поле для ввода телефона
     */
    private final By phoneInput = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Телефон')]");

    /**
     * Поле отображения ошибки ввода в поле телефон
     */
    private final By phoneInputError = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Телефон')]/following-sibling::div[starts-with(@class,'Input_ErrorMessage')]");

    /**
     * Поле для ввода даты доставки
     */
    private final By dateInput = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Когда привезти самокат')]");

    /**
     * Поле для выбора срока аренды
     */
    private final By durationInput = By.xpath(".//div[starts-with(@class, 'Order_Form')]//div[@class='Dropdown-placeholder']");

    /**
     * Элементы выпадающего списка для выбора срока аренды
     */
    public final By durationItems = By.xpath(".//div[starts-with(@class, 'Order_Form')]//div[@class='Dropdown-option']");

    /**
     * Чекбокс для выбора черного скутера
     */
    public final By blackScooter = By.id("black");

    /**
     * Чекбокс для выбора серого скутера
     */
    public final By greyScooter = By.id("grey");

    /**
     * Поле для ввода комментария
     */
    public final By commentInput = By.xpath(".//div[starts-with(@class, 'Order_Form')]//input[contains(@placeholder,'Комментарий для курьера')]");

    /**
     * Кнопка "Далее"
     */
    private final By nextButton = By.xpath(".//div[starts-with(@class, 'Order_NextButton')]/button");

    /**
     * Кнопка "Заказать"
     */
    private final By orderButton = By.xpath(".//div[starts-with(@class, 'Order_Buttons')]/button[not(contains(@class,'Button_Inverted'))]");

    /**
     * Кнопка "Да" в окне с подтверждением заказа
     */
    private final By acceptOrderButton = By.xpath(".//div[starts-with(@class, 'Order_Modal')]//button[not(contains(@class,'Button_Inverted'))]");

    /**
     * Текст об успешном оформлении заказа во всплывающем окне
     */
    private final By newOrderSuccessMessage = By.xpath(".//div[starts-with(@class, 'Order_Modal')]//div[(starts-with(@class,'Order_ModalHeader'))]");

    /**
     * Заголовок первого шага формы заказа самоката
     */
    private final By firstStepHeader = By.xpath(".//div[starts-with(@class, 'Order_Content')]/div[(starts-with(@class,'Order_Header'))]");

    /**
     * Конструктор класса OrderPage
     *
     * @param webDriver веб-драйвер
     */
    public OrderPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    /**
     * Метод для установки значения в поле "Имя"
     *
     * @param name имя
     */
    public void setName(String name) {
        webDriver.findElement(nameInput).sendKeys(name);
    }

    /**
     * Метод для установки значения в поле "Фамилия"
     *
     * @param surname фамилия
     */
    public void setSurname(String surname) {
        webDriver.findElement(surnameInput).sendKeys(surname);
    }

    /**
     * Метод для установки значения в поле "Адрес"
     *
     * @param address адрес
     */
    public void setAddress(String address) {
        webDriver.findElement(addressInput).sendKeys(address);
    }

    /**
     * Метод для установки значения в поле "Станция метро"
     *
     * @param metro станция метро
     */
    public void setMetro(String metro) {
        webDriver.findElement(metroInput).sendKeys(metro);
        webDriver.findElements(metroSelectedItems).get(0).click();
    }

    /**
     * Метод для установки значения в поле "Телефон"
     *
     * @param phone номер телефона
     */
    public void setPhone(String phone) {
        webDriver.findElement(phoneInput).sendKeys(phone);
    }

    /**
     * Метод для установки значения в поле "Когда привезти самокат"
     *
     * @param date дата в формате dd.MM.yyyy
     */
    public void setDate(String date) {
        webDriver.findElement(dateInput).sendKeys(date);
        // скрыть календарь
        Actions action = new Actions(webDriver);
        action.sendKeys(Keys.ESCAPE).perform();
    }

    /**
     * Метод для установки значения в поле "Срок аренды"
     *
     * @param duration срок аренды
     */
    public void setDuration(String duration) {
        webDriver.findElement(durationInput).click();
        clickItemInDurationDropdownList(duration);
    }

    /**
     * Выбор значения в выпадающем списке
     *
     * @param selectedText текст, который нужно выбрать
     */
    public void clickItemInDurationDropdownList(String selectedText) {
        List<WebElement> items = webDriver.findElements(durationItems);
        for (WebElement item : items) {
            if (item.getText().equals(selectedText)) {
                item.click();
                break;
            }
        }
    }

    /**
     * Метод для установки значения в поле "Цвет самоката"
     *
     * @param colour цвет самоката
     */
    public void setColor(String colour) {
        webDriver.findElement(colour.equals("чёрный жемчуг") ? blackScooter : greyScooter).click();
    }

    /**
     * Метод для нажатия на кнопку "Далее" для продолжения оформления заказа
     */
    public void clickNextButton() {
        webDriver.findElement(nextButton).click();
    }

    /**
     * Метод для установк значения в поле "Комментарий для курьера"
     *
     * @param comment комментарий
     */
    public void setComment(String comment) {
        webDriver.findElement(commentInput).sendKeys(comment);
    }

    /**
     * Метод для нажатия на кнопку "Заказать"
     */
    public void clickOrderButton() {
        webDriver.findElement(orderButton).click();
    }

    /**
     * Метод для нажатия на кнопку "Да" в окне подтверждения заказа
     */
    public void clickAcceptButton() {
        webDriver.findElement(acceptOrderButton).click();
    }

    /**
     * Метод для получения сообщения об успешном оформлении заказа
     *
     * @return сообщение о заказе
     */
    public boolean checkNewOrderSuccessMessage() {
        return webDriver.findElement(newOrderSuccessMessage).getText().startsWith("Заказ оформлен");
    }

    /**
     * Метод для получения текста о неверном значении в поле "Имя"
     */
    public String getNameInputErrorMessage() {
        return webDriver.findElement(nameInputError).getText();
    }

    /**
     * Метод для получения текста о неверном значении в поле "Фамилия"
     */
    public String getSurnameInputErrorMessage() {
        return webDriver.findElement(surnameInputError).getText();
    }

    /**
     * Метод для получения текста о неверном значении в поле "Адрес"
     */
    public String getAddressInputErrorMessage() {
        return webDriver.findElement(addressInputError).getText();
    }

    /**
     * Метод для получения текста о неверном значении в поле "Метро"
     */
    public String getMetroInputErrorMessage() {
        return webDriver.findElement(metroInputError).getText();
    }

    /**
     * Метод для получения текста о неверном значении в поле "Номер телефона"
     */
    public String getPhoneInputErrorMessage() {
        return webDriver.findElement(phoneInputError).getText();
    }

    /**
     * Метод для проверки того, что кнопка "Далее" заблокирована (нет возможности перейти ко второму шагу заполнения формы)
     */
    public boolean isNextButtonBlocked() {
        webDriver.findElement(nextButton).click();
        return webDriver.findElement(firstStepHeader).isDisplayed();
    }
}
