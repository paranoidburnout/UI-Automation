package steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void close() {
        Selenide.clearBrowserCookies();
        Selenide.refresh();
    }
}
