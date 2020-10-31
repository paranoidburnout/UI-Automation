package steps;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CommonPageSteps {
    public static final String URL = "https://jdi-framework.github.io/tests/index.htm";

    @Given("^Page opened$")
    public void openLink() throws Throwable {
        open(URL);
    }

    @And("^Pressed button with user icon$")
    public void pressIcon() {
        userIcon.shouldBe(visible).click();
    }

    @And("^Entered text \"([^\"]*)\" to the field \"([^\"]*)\"$")
    public void login(String value, String fieldName) {
        $(By.xpath(String.format("//*[@id='%s']", fieldName))).shouldBe(visible).setValue(value);
    }

    @And("^Pressed element with value 'Enter'$")
    public void pressEnter() {
        enterButton.shouldBe(visible).click();
    }

    SelenideElement userIcon = $(By.xpath("//*[@class='fa fa-user']"));
    SelenideElement enterButton = $(By.xpath("//button/i[@class='fa fa-sign-in']"));
}
