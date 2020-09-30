package service_page;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ButtonsForServicePage {
    @When("^Clicked on Service in the header$")
    public void clickServiceHeader() {
        $(By.cssSelector("a[href*='page1.htm'].dropdown-toggle")).shouldBe(visible).click();
    }

    @Then("^Drop down contains option in the header$")
    public void headerDropdownElementsDisplayed() {
        $(By.cssSelector(".dropdown-menu>li")).shouldBe(visible);
    }

    @When("^Clicked on Service in the left$")
    public void clickServiceLeft() {
        $(By.cssSelector(".sidebar-menu .sub-menu")).shouldBe(visible).click();
    }

    @Then("^Drop down contains option in the left$")
    public void leftDropdownElementsDisplayed() {
        $(By.cssSelector(".sub>li")).shouldBe(visible);
    }
}
