package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import page.objects.MainPage;
import page.objects.OrderPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPageNegativeTests {
    /**
     * Веб-драйвер
     */
    private WebDriver webDriver;

    /**
     * Переменные для данных оформления заказа
     */
    private final String name, surname, address, metro, phone;

    /**
     * Конструктор класса OrderPageTests
     *
     * @param name    имя
     * @param surname фамилия
     * @param address адрес
     * @param metro   станция метро
     * @param phone   номер телефона
     */
    public OrderPageNegativeTests(
            String name,
            String surname,
            String address,
            String metro,
            String phone
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
    }

    /**
     * Параметры теста
     *
     * @return массив параметров
     */
    @Parameterized.Parameters(name = "Оформление заказа. Позитивный сценарий. Пользователь: {0} {1}")
    public static Object[][] setDataForOrder() {
        return new Object[][]{
                {"aaaabbb", "aaaavvvvv", "asdfsafsdaf", "sdfsfsdf", "111111"},
                {"Сеpгейsdf", "Пeтлевaнныйsdf", "sdfocквa, ул.Фpaнко д.61, кв. 22", "sdfВыхинo", "111111"},
        };
    }

    /**
     * Действия перед запуском теста
     */
    @Before
    public void startUp() {
        webDriver = Utils.run();
    }

    /**
     * Тест для проверки негативного сценария заполнения первой страницы формы заказа после нажатия на кнопку "Заказать" в хедере сайта
     */
    @Test
    public void firstOrderStageWithHeaderButtonWhenFailure() {
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);

        mainPage.clickOnCookieAcceptButton();
        mainPage.clickOrderButtonInHeader();

        makeFirstStepOrder(orderPage);
        assertFirstStepOrder(orderPage);
    }

    /**
     * Тест для проверки негативного сценария заполнения первой страницы формы заказа после нажатия на кнопку "Заказать" в теле сайта
     */
    @Test
    public void firstOrderStageWithBodyButtonWhenFailure() {
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);

        mainPage.clickOnCookieAcceptButton();
        mainPage.clickOrderButtonInBody();

        makeFirstStepOrder(orderPage);
        assertFirstStepOrder(orderPage);
    }

    /**
     * Действия после окончания теста
     */
    @After
    public void tearDown() {
        Utils.quit(webDriver);
    }

    /**
     * Метод для заполнения первого шага формы
     */
    private void makeFirstStepOrder(OrderPage orderPage) {
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setMetro(metro);
        orderPage.setPhone(phone);
        orderPage.clickNextButton();
    }

    /**
     * Методы проверки assert
     */
    private void assertFirstStepOrder(OrderPage orderPage) {
        assertEquals("Не отображается сообщение об ошибке в поле имя", "Введите корректное имя", orderPage.getNameInputErrorMessage());
        assertEquals("Не отображается сообщение об ошибке в поле фамилия", "Введите корректную фамилию", orderPage.getSurnameInputErrorMessage());
        assertEquals("Не отображается сообщение об ошибке в поле адрес", "Введите корректный адрес", orderPage.getAddressInputErrorMessage());
        assertEquals("Не отображается сообщение об ошибке в поле станция метро", "Выберите станцию", orderPage.getMetroInputErrorMessage());
        assertEquals("Не отображается сообщение об ошибке в поле номер телефона", "Введите корректный номер", orderPage.getPhoneInputErrorMessage());
        assertTrue("Кнопка далее не заблокирована, позволяет перейти к следующему шагу формы", orderPage.isNextButtonBlocked());
    }
}
