package presence;

import com.codeborne.selenide.ElementsCollection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;



public class ElementsOnTheServicePage {
    @When("^User opened through the header menu Service -> Different Elements Page$")
    public void openDifferentElementsPage() {
        $(By.cssSelector(".sidebar-menu .sub-menu")).shouldBe(visible).click();
        $(By.cssSelector(".sub-menu [href = 'page8.htm']")).shouldBe(visible).click();
    }

    @Then("^Interface on Service page contain 4 checkboxes was displayed$")
    public void check4CheckboxesOnServicePage() {
        ElementsCollection checkboxes =
                $$(By.xpath("//label[@class= 'label-checkbox']"))
                        .shouldHaveSize(4);
        checkboxes.forEach(checkbox -> checkbox.should(visible));
    }

    @And("^4 radios was displayed$")
    public void check4RadiosOnServicePage() {
        ElementsCollection radios =
                $$(By.xpath("//label[@class= 'label-radio']"))
                        .shouldHaveSize(4);
        radios.forEach(radio -> radio.should(visible));
    }

    @And("^Dropdown was displayed$")

    public void checkDropdownOnServicePage() {
        $(By.xpath("//select[@class='uui-form-element']")).shouldBe(visible);
    }

    @And("^2 - buttons was displayed$")
    public void buttons2OnServicePage() {
        ElementsCollection buttons =
                $$(By.cssSelector(".main-content .uui-button"))
                        .shouldHaveSize(2);
        buttons.forEach(button -> button.should(visible));
    }

    @And("^Left section was displayed$")
    public void leftSectionOnServicePage() {
        $(By.xpath("//div[@id='mCSB_1']")).shouldBe(visible);
    }

    @And("^Right section was displayed$")
    public void rightSectionOnServicePage() {
        $(By.xpath("//div[@id='mCSB_2']")).shouldBe(visible);
    }
}
