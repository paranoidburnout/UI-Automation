package authorization;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;


public class LoginPage {
    @When("^User pressed button with user icon$")
    public void pressIcon() {
        $(By.xpath("//*[@class='fa fa-user']")).shouldBe(visible).click();
    }

    @And("^Type to input with name \"([^\"]*)\" text: \"([^\"]*)\"$")
    public void typeToInputWithNameText(String input, String text) {
        $(By.xpath("//*[@id='" + input + "']")).shouldBe(visible).setValue(text);
    }

    @And("^User pressed element with value 'Enter'$")
    public void pressEnter() {
        $(By.xpath("//button/i[@class='fa fa-sign-in']")).shouldBe(visible).click();
    }

    @Then("^PITER CHAILOVSKII is displayed$")
    public void youCanSeeResult() {
        $(By.xpath("//*[contains(text(),'Piter Chailovskii')]")).shouldBe(visible).click();
    }
}

