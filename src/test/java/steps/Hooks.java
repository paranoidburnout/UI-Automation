package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

import io.cucumber.java.Before;


public class Hooks {
//    WebDriver driver;

    @Before
    public void setUp() {
//        System.setProperty("webdriver.chrome.driver", "/Users/Liza/IdeaProjects/UITestAutomation/src/test/resources/chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://www.freecrm.com");
    }

    @After
    public void close() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
//        driver.close();
    }

}
