package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.MainPage;

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
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.get("https://qa-scooter.praktikum-services.ru/");
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
        String scooterUrl = "https://qa-scooter.praktikum-services.ru/";
        assertTrue("Ссылка в логотипе Самокат не соответствует " + scooterUrl,mainPage.getScooterLogoLink().equals(scooterUrl));
    }

    /**
     * Действия после окончания теста
     */
    @After
    public void tearDown() {
        webDriver.quit();
    }

}

