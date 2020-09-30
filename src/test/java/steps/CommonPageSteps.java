package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CommonPageSteps {
    @Given("^Page opened$")
    public void openLink() throws Throwable {
        open("https://jdi-framework.github.io/tests/index.htm");
    }

    @And("^Pressed button with user icon$")
    public void pressIcon() {
        $(By.xpath("//*[@class='fa fa-user']")).shouldBe(visible).click();
    }

    @And("^Entered text \"([^\"]*)\" to the field \"([^\"]*)\"$")
    public void login(String value, String fieldName) {
        $(By.xpath("//*[@id='" + fieldName + "']")).shouldBe(visible).setValue(value);
    }

    @And("^Pressed element with value 'Enter'$")
    public void pressEnter() {
        $(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button")).shouldBe(visible).click();
    }

}
