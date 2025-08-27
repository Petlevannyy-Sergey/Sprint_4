package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import page.objects.MainPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/***
 * Класс тестов для корректности ссылок на главной странице
 */

public class MainPageLinksTests {
    /**
     * Web-драйвер
     */
    private WebDriver webDriver;

    /**
     * Действия перед запуском теста
     */
    @Before
    public void startUp() {
        webDriver = Utils.run();
    }

    /**
     * Тест для проверки корректности ссылки в логотипе "Яндекс" на главной странице
     */
    @Test
    public void checkYandexLinkIsCorrect() {
        MainPage mainPage = new MainPage(webDriver);
        String yandexUrl = "yandex.ru";
        assertTrue("Ссылка в логотипе яндекс не соответствует " + yandexUrl, mainPage.getYandexLogoLink().contains(yandexUrl));
    }

    /**
     * Тест для проверки корректности ссылки в логотипе "Самоката" на главной странице
     */
    @Test
    public void checkScooterLinkIsCorrect() {
        MainPage mainPage = new MainPage(webDriver);
        assertEquals("Ссылка в логотипе Самокат не соответствует " + MainPage.url, MainPage.url, mainPage.getScooterLogoLink());
    }

    /**
     * Действия после окончания теста
     */
    @After
    public void tearDown() {
        Utils.quit(webDriver);
    }
}

