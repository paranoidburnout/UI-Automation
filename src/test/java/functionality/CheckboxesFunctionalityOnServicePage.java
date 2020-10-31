package functionality;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static junit.framework.TestCase.assertTrue;
import static com.codeborne.selenide.Condition.visible;

public class CheckboxesFunctionalityOnServicePage {
    @And("^Checkbox \"([^\"]*)\" elements have been selected$")
    public void selectEarthElement(String element) {
        SelenideElement water = labelCheckboxes.stream().filter(e -> e.getText().contains(element)).findFirst().get();
        water.shouldBe(Condition.visible).click();
    }

    @And("^Radio \"([^\"]*)\" element has been selected$")
    public void selectRadio(String radio) {
        SelenideElement selen = labelRadios.stream().filter(e -> e.getText().contains(radio)).findFirst().get();
        selen.shouldBe(Condition.visible).click();
    }

    @And("^In dropdown Yellow element has been selected$")
    public void selectDropdown() {
        uuiFormElement.shouldBe(visible).click();
        yellow.shouldBe(visible).click();
    }

    @Then("^In logs panel \"([^\"]*)\" status changed to \"([^\"]*)\"$")
    public void inLogsPanelWaterStatusChangedToTrue(String water, boolean status) {
        assertTrue(status);
        status = panelBodyListLogs
                .stream()
                .map(SelenideElement::getText)
                .anyMatch(s -> s.contains(water));
    }

    @And("^Panel \"([^\"]*)\" status changed to \"([^\"]*)\" in logs$")
    public void inLogsPanelWindStatusChangesToTrue(String wind, boolean status) {
        assertTrue(status);
        status = panelBodyListLogs
                .stream()
                .map(SelenideElement::getText)
                .anyMatch(s -> s.contains(wind));
    }

    @And("^In logs panel \"([^\"]*)\" value changed to \"([^\"]*)\"$")
    public void inLogsPanelMetalsValueChangedToBronze(String bronze, String typeValue) {
        typeValue = String.valueOf(panelBodyListLogs
                .stream()
                .map(SelenideElement::getText)
                .anyMatch(s -> s.contains(bronze)));
    }

    @And("^Panel \"([^\"]*)\" value changed to \"([^\"]*)\" in logs$")
    public void inLogsPanelColorsValueChangedToYellow(String yellow, String typeValue) {
        typeValue = String.valueOf(panelBodyListLogs
                .stream()
                .map(SelenideElement::getText)
                .anyMatch(s -> s.contains(yellow)));
    }

    ElementsCollection labelCheckboxes = $$(By.xpath("//*[@class = 'label-checkbox']"));
    ElementsCollection labelRadios = $$(By.xpath("//*[@class = 'label-radio']"));
    SelenideElement uuiFormElement = $(By.xpath("//select[@class = 'uui-form-element']"));
    SelenideElement yellow = $(By.xpath("//*[@class = 'uui-form-element']/option[contains(., 'Yellow')]"));
    ElementsCollection panelBodyListLogs = $$(By.xpath("//*[@class='panel-body-list logs']/li"));
}
