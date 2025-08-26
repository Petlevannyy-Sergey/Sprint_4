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
import pageObjects.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderPagePositiveTests {
    /**
     * Веб-драйвер
     */
    private WebDriver webDriver;

    /**
     * Переменные для данных оформления заказа
     */
    private final String name, surname, address, metro, phone, date, duration, colour, comment;

    /**
     * Конструктор класса OrderPageTests
     * @param name имя
     * @param surname фамилия
     * @param address адрес
     * @param metro станция метро
     * @param phone номер телефона
     * @param date дата доставки
     * @param duration срок аренды
     * @param colour цвет самоката
     * @param comment комментарий для курьера
     * */
    public OrderPagePositiveTests(
            String name,
            String surname,
            String address,
            String metro,
            String phone,
            String date,
            String duration,
            String colour,
            String comment
    ) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.duration = duration;
        this.colour = colour;
        this.comment=comment;
    }

    /**
     * Параметры теста
     *
     * @return массив параметров
     */
    @Parameterized.Parameters(name = "Оформление заказа. Позитивный сценарий. Пользователь: {0} {1}")
    public static Object[][] setDataForOrder() {
        return new Object[][]{
                {"Сергей", "Петлеванный", "Москва, ул. Франко, д.22, кв.61", "Выхино", "89261234567", "01.09.2025", "сутки", "чёрный жемчуг","Позвонить за полчаса"},
                {"Иван ", "Иванов", "Москва, ул. Кремль, д. 1, кв. 1", "Театральная", "89261112233", "03.09.2025", "семеро суток", "серая безысходность", "Крикнуть по прибытию"},
        };
    }

    /**
     * Действия перед запуском теста
     */
    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        this.webDriver.get("https://qa-scooter.praktikum-services.ru");
    }

    /**
     * Тест для проверки процесса оформления заказа после нажатия на кнопку "Заказать" в хедере сайта
     */
    @Test
    public void orderWithHeaderButtonWhenSuccess() {
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);

        mainPage.clickOnCookieAcceptButton();
        mainPage.clickOrderButtonInHeader();
        makeOrder(orderPage);

        assertTrue("Проблема создания нового заказа", orderPage.checkNewOrderSuccessMessage());
    }

    /**
     * Тест для проверки процесса оформления заказа после нажатия на кнопку "Заказать" в теле сайта
     */
    @Test
    public void orderWithBodyButtonWhenSuccess(){
        MainPage mainPage = new MainPage(webDriver);
        OrderPage orderPage = new OrderPage(webDriver);

        mainPage.clickOnCookieAcceptButton();
        mainPage.clickOrderButtonInBody();
        makeOrder(orderPage);

        assertTrue("Проблема создания нового заказа", orderPage.checkNewOrderSuccessMessage());
    }

    /**
     * Действия после окончания теста
     */
    @After
    public void tearDown() {
        this.webDriver.quit();
    }

    /**
     * Метод оформления заказа
     * @param orderPage экземпляр объекта страницы заказа
     * */
    private void makeOrder(OrderPage orderPage) {
        orderPage.setName(name);
        orderPage.setSurname(surname);
        orderPage.setAddress(address);
        orderPage.setMetro(metro);
        orderPage.setPhone(phone);

        orderPage.clickNextButton();

        orderPage.setDate(date);
        orderPage.setDuration(duration);
        orderPage.setColor(colour);
        orderPage.setComment(comment);

        orderPage.clickOrderButton();
        orderPage.clickAcceptButton();
    }
}
