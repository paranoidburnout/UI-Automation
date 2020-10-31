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

public class ElementsOnTheServicePage {
    @When("^User opened through the header menu Service -> Different Elements Page$")
    public void openDifferentElementsPage() {
        pageService.click();
        differentElementPage.click();
    }

    @Then("^Interface on Service page contain 4 checkboxes was displayed$")
    public void check4CheckboxesOnServicePage() {
        labelCheckboxes.forEach(checkbox -> checkbox.shouldBe(visible));
        assertEquals(labelCheckboxes.size(), 4);
    }

    @And("^4 radios was displayed$")
    public void check4RadiosOnServicePage() {
        labelRadios.forEach(radio -> radio.shouldBe(visible));
        assertEquals(labelRadios.size(), 4);
    }

    @And("^Dropdown was displayed$")
    public void checkDropdownOnServicePage() {
        uuiFormElement.shouldBe(visible);
    }

    @And("^2 - buttons was displayed$")
    public void buttons2OnServicePage() {
        uuiButtons.forEach(button -> button.shouldBe(visible));
        assertEquals(uuiButtons.size(), 2);
    }

    @And("^Left section was displayed$")
    public void leftSectionOnServicePage() {
        leftSection.shouldBe(visible);
    }

    @And("^Right section was displayed$")
    public void rightSectionOnServicePage() {
        rightSection.shouldBe(visible);
    }

    SelenideElement pageService = $(".sidebar-menu .sub-menu");
    SelenideElement differentElementPage = $(".sub-menu [href = 'page8.htm']");
    ElementsCollection labelCheckboxes = $$(By.xpath("//label[@class= 'label-checkbox']"));
    ElementsCollection labelRadios = $$(By.xpath("//label[@class= 'label-radio']"));
    SelenideElement uuiFormElement = $(By.xpath("//select[@class='uui-form-element']"));
    ElementsCollection uuiButtons = $$(".main-content .uui-button");
    SelenideElement leftSection = $(By.xpath("//div[@id='mCSB_1']"));
    SelenideElement rightSection = $(By.xpath("//div[@id='mCSB_2']"));

}
