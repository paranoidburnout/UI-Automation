package functionality;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static junit.framework.TestCase.assertTrue;


public class CheckboxesFunctionalityOnServicePage {

    @And("^Checkbox \"([^\"]*)\" elements have been selected$")
    public void selectEarthElement(String element) {
        List<SelenideElement> list = $$(By.xpath("//*[@class = 'label-checkbox']"));
        SelenideElement water = list.stream().filter(e -> e.getText().contains(element)).findFirst().get();
        water.shouldBe(Condition.visible).click();
    }

    @And("^Radio \"([^\"]*)\" element has been selected$")
    public void selectRadio(String radio) {
        List<SelenideElement> list = $$(By.xpath("//*[@class = 'label-radio']"));
        SelenideElement selen = list.stream().filter(e -> e.getText().contains(radio)).findFirst().get();
        selen.shouldBe(Condition.visible).click();

    }

    @And("^In dropdown Yellow element has been selected$")
    public void selectDropdown() {
        $(By.xpath("//select[@class = 'uui-form-element']")).shouldBe(Condition.visible).click();
        $(By.xpath("//*[@class = 'uui-form-element']/option[contains(., 'Yellow')]")).shouldBe(Condition.visible).click();
    }

    @Then("^In logs panel \"([^\"]*)\" status changed to \"([^\"]*)\"$")
    public void inLogsPanelWaterStatusChangedToTrue(String water, boolean status) {
        assertTrue(status);
        status = $$(By.xpath("//*[@class='panel-body-list logs']/li"))
                .stream()
                .map(SelenideElement::getText)
                .anyMatch(s -> s.contains(water));
    }

    @And("^Panel \"([^\"]*)\" status changed to \"([^\"]*)\" in logs$")
    public void inLogsPanelWindStatusChangesToTrue(String wind, boolean status) {
        assertTrue(status);
        status = $$(By.xpath("//*[@class='panel-body-list logs']/li"))
                .stream()
                .map(SelenideElement::getText)
                .anyMatch(s -> s.contains(wind));
    }

    @And("^In logs panel \"([^\"]*)\" value changed to \"([^\"]*)\"$")
    public void inLogsPanelMetalsValueChangedToBronze(String bronze, String typeValue) {
        typeValue = String.valueOf($$(By.xpath("//*[@class='panel-body-list logs']/li"))
                .stream()
                .map(SelenideElement::getText)
                .anyMatch(s -> s.contains(bronze)));
    }

    @And("^Panel \"([^\"]*)\" value changed to \"([^\"]*)\" in logs$")
    public void inLogsPanelColorsValueChangedToYellow(String yellow, String typeValue) {
        typeValue = String.valueOf($$(By.xpath("//*[@class='panel-body-list logs']/li"))
                .stream()
                .map(SelenideElement::getText)
                .anyMatch(s -> s.contains(yellow)));
    }

}
