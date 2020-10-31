package presence;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertEquals;

public class HomePage {
    public static final String URL = "https://jdi-framework.github.io/tests/index.htm";

    @When("^User open the home page$")
    public void openHomePage() throws Throwable {
        open(URL);
    }

    @Then("^4 images was displayed$")
    public void checkImagesExistence() {
        images.forEach(image -> image.shouldBe(visible));
        assertEquals(images.size(), 4);
    }

    @And("^4 text was displayed below 4 Icons$")
    public void checkTextBelowIcons() {
        texts.forEach(text -> text.shouldBe(visible));
        assertEquals(texts.size(), 4);
    }

    @And("^Main title text center was displayed$")
    public void checkMainTitleTextCenter() {
        mainTitleTextCenter.click();
    }

    @And("^Below main title text center was displayed$")
    public void checkBelowMainTitleTextCenter() {
        belowMainTitleTextCenter.click();
    }

    ElementsCollection images = $$(".benefit-icon span");
    ElementsCollection texts = $$(By.xpath("//span[contains(@class, 'benefit-txt')]"));
    SelenideElement mainTitleTextCenter = $(By.xpath("//h3[contains(@class, 'main-title text-center')]"));
    SelenideElement belowMainTitleTextCenter = $(By.xpath("//p[contains(@class, 'main-txt text-center')]"));
}
