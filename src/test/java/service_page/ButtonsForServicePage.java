package service_page;

import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ButtonsForServicePage {
    @When("^Clicked on Service in the header$")
    public void clickServiceHeader() {
        serviceHeader.shouldBe(visible).click();
    }

    @Then("^Drop down contains option in the header$")
    public void headerDropdownElementsDisplayed() {
        dropdownInTheHeader.shouldBe(visible);
    }

    @When("^Clicked on Service in the left$")
    public void clickServiceLeft() {
        leftService.shouldBe(visible).click();
    }

    @Then("^Drop down contains option in the left$")
    public void leftDropdownElementsDisplayed() {
        dropdownInTheLeft.shouldBe(visible);
    }
    SelenideElement serviceHeader= $("a[href*='page1.htm'].dropdown-toggle");
    SelenideElement dropdownInTheHeader = $(".dropdown-menu>li");
    SelenideElement leftService = $(".sidebar-menu .sub-menu");
    SelenideElement dropdownInTheLeft = $(".sub>li");
}
