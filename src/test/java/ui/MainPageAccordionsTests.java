package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.MainPage;
import static org.junit.Assert.*;

/**
 * Тесты для проверки работы блока "Вопросы о важном"
 */
@RunWith(Parameterized.class)
public class MainPageAccordionsTests {
    /**
     * Веб-драйвер
     */
    private WebDriver webDriver;

    /** Ожидаемый текст в заголовке раскрывающегося блока */
    private  final String expectedHeaderText;

    /** Ожидаемый текст в раскрывающемся блоке */
    private final String expectedItemText;

    /** Индекс элемента */
    private final int indexOfElement;

    /**
     * Конструктор класса MainPageAccordionsTests
     * @param IndexOfElement Порядковый номер элемента в раскрывающемся блоке
     * @param expectedHeaderText Ожидаемый текст в заголовке раскрывающегося блока
     * @param expectedItemText Ожидаемый текст в раскрывающемся блоке
     */
    public MainPageAccordionsTests(int IndexOfElement, String expectedHeaderText, String expectedItemText) {
        this.indexOfElement = IndexOfElement;
        this.expectedHeaderText = expectedHeaderText;
        this.expectedItemText = expectedItemText;
    }

    /**
     * Параметры теста
     * @return массив параметров
     */
    @Parameterized.Parameters(name = "Текст в блоке\"Вопросы о важном\". Проверяем элемент: {1}")
    public static Object[][] setTestData() {
        return new Object[][] {
                {0, "Сколько это стоит? И как оплатить?", "Сутки — 400 рублей. Оплата курьеру — наличными или картой."},
                {1, "Хочу сразу несколько самокатов! Так можно?", "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."},
                {2, "Как рассчитывается время аренды?", "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."},
                {3, "Можно ли заказать самокат прямо на сегодня?", "Только начиная с завтрашнего дня. Но скоро станем расторопнее."},
                {4, "Можно ли продлить заказ или вернуть самокат раньше?", "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."},
                {5, "Вы привозите зарядку вместе с самокатом?", "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."},
                {6, "Можно ли отменить заказ?", "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои."},
                {7, "Я живу за МКАДом, привезёте?", "Да, обязательно. Всем самокатов! И Москве, и Московской области." }, // bug here з -> в
        };
    }

    /**
     * Действия перед запуском теста
     */
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru");
    }

    /**
     * Тест для проверки работы раскрывающегося блока и соответствия текста в заголовках и в самих раскрывающихся блоках
     */
    @Test
    public void CheckAccordionIsCorrect() {
        MainPage mainPage = new MainPage(webDriver);
        mainPage.clickOnCookieAcceptButton();
        mainPage.clickAccordionHeader(indexOfElement);
        assertEquals("Не пройден тест отображения текста в заголовке раскрывающегося блока № " + indexOfElement,
                expectedHeaderText,
                mainPage.getAccordionHeaderText(indexOfElement));
        assertEquals("Не пройден тест отображения текста в раскрывающемся блоке № " + indexOfElement,
                expectedItemText,
                mainPage.getAccordionItemText(indexOfElement));
    }

    /**
     * Действия после окончания теста
     */
    @After
    public void tearDown() {
        webDriver.quit();
    }
}
