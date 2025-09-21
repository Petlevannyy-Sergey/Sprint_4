package ui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Утилиты, общие для всех тестов
 */
public class Utils {
    /**
     * Запуск браузера и переход на главную страницу
     */
    public static WebDriver run() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.get(page.objects.MainPage.url);
        return webDriver;
    }

    /**
     * Завершение работы браузера
     */
    public static void quit(WebDriver webDriver) {
        webDriver.quit();
    }
}
