package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.objects.OrderStatusPage;

import static org.junit.Assert.assertTrue;

/**
 * Тесты для проверки корректности ссылки на заказ
 */
@RunWith(Parameterized.class)
public class OrderStatusPageTests {
    /**
     * Web-драйвер
     */
    private WebDriver webDriver;

    /**
     * Номер заказа
     */
    private final String orderNumber;

    /**
     * Конструктор класса OrderStatusPageLinkTests
     */
    public OrderStatusPageTests(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    /**
     * Действия перед запуском теста
     */
    @Before
    public void startUp() {
        webDriver = Utils.run();
    }

    /**
     * Параметры теста
     *
     * @return массив параметров
     */
    @Parameterized.Parameters(name = "Номер заказа: {0}")
    public static Object[][] setTestData() {
        return new Object[][]{
                {"1234556"},
                {"12345"},
                {"1234567"}
        };
    }

    /**
     * Тест проверки отсутствия заказов
     */
    @Test
    public void checkOrderStatusWhenFailure() {
        OrderStatusPage page = new OrderStatusPage(webDriver);
        page.clickOrderStatusButton();
        page.waitForOrderStatusInput();
        page.setOrderNumber(orderNumber);
        page.clickGoButton();
        assertTrue("Негативный сценарий проверки статуса заказа", page.isOrderNotFound());
    }

    /**
     * Действия после окончания теста
     */
    @After
    public void tearDown() {
        Utils.quit(webDriver);
    }
}
