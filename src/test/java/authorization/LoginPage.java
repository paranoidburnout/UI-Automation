package authorization;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {

    public static final String INPUT_ID_LOCATOR = "//*[@id='%s']";

    @When("^User pressed button with user icon$")
    public void pressIcon() {
        userIcon.shouldBe(visible).click();
    }

    @And("^Type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String input, String text) {
        $(By.xpath(String.format(INPUT_ID_LOCATOR, input))).shouldBe(visible).setValue(text);
    }

    @And("^User pressed element with value 'Enter'$")
    public void pressEnter() {
        enterButton.shouldBe(visible).click();
    }

    @Then("^PITER CHAILOVSKII is displayed$")
    public void youCanSeeResult() {
        userName.shouldBe(visible);
    }

    SelenideElement userIcon = $(By.xpath("//*[@class='fa fa-user']"));
    SelenideElement enterButton = $(By.xpath("//button/i[@class='fa fa-sign-in']"));
    SelenideElement userName = $(By.xpath("//*[contains(text(),'Piter Chailovskii')]"));
}

