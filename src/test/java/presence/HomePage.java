package presence;

import com.codeborne.selenide.ElementsCollection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage {

    @When("^User open the home page$")
    public void openHomePage() throws Throwable {
        open("https://jdi-framework.github.io/tests/index.htm");
    }

    @Then("^4 images was displayed$")
    public void checkImagesExistence() {
        $(By.xpath("//span[contains(@class,'icon-practise')]")).shouldBe(visible).click();
        $(By.xpath("//span[contains(@class,'icon-custom')]")).shouldBe(visible).click();
        $(By.xpath("//span[contains(@class,'icon-multi')]")).shouldBe(visible).click();
        $(By.xpath("//span[contains(@class, 'icon-base')]")).shouldBe(visible).click();
    }

    @And("^4 text was displayed below 4 Icons$")
    public void checkTextBelowIcons() {
        ElementsCollection texts =
                $$(By.xpath("//span[contains(@class, 'benefit-txt')]"))
                        .shouldHaveSize(4);
        texts.forEach(element -> element.should(visible));
    }

    @And("^Main title text center was displayed$")
    public void checkMainTitleTextCenter() {
        $(By.xpath(" //h3[contains(@class, 'main-title text-center')]")).shouldBe(visible).click();
    }

    @And("^Below main title text center was displayed$")
    public void checkBelowMainTitleTextCenter() {
        $(By.xpath("//p[contains(@class, 'main-txt text-center')]")).shouldBe(visible).click();
    }

}
