package functionality;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;


public class Sliders {
    Integer sliderL;
    Integer sliderR;

    @And("^Opened through the left menu Service -> Dates$")
    public void openedServiceAndDatesPages() {
        $(By.xpath("//a/span[contains(text(),'Service')]")).shouldBe(visible).click();
        $(By.xpath("//a/p/span[contains(text(),'Dates')]")).shouldBe(visible).click();
    }

    @When("User clicked on the left slider and drag it to {int}")
    public void movingTheLeftSlider(int sliderLeft) {
        sliderL = sliderLeft;
        SelenideElement left = $("div:nth-child(2) > div > a:nth-child(1)");
        left.scrollIntoView(true);
        actions().dragAndDropBy(left, -276, 0).build().perform();
        actions().dragAndDropBy(left, (int) ((sliderLeft * 2.64)), 0).build().perform();
    }

    @And("On the right slider and drag it to {int} user clicked")
    public void movingTheRightSlider(int sliderRight) {
        sliderR = sliderRight;
        SelenideElement right = $("div:nth-child(2) > div > a:nth-child(3)");
        right.scrollIntoView(true);
        int currentPercentage = Integer.parseInt(right.getText());
        int diff = currentPercentage - sliderRight;
        actions().dragAndDropBy(right, (int) ((-(diff) * 2.64)), 0).build().perform();
        int newCurrentPercentage = Integer.parseInt(right.getText());
        if (newCurrentPercentage > sliderRight) {
            while (newCurrentPercentage > sliderRight) {
                actions().dragAndDropBy(right, -5, 0).build().perform();
                int finalNewCurrentPercentage = Integer.parseInt(right.getText());
                if (finalNewCurrentPercentage == sliderRight) break;
            }
        } else if (newCurrentPercentage < sliderRight) {
            while (newCurrentPercentage < sliderRight) {
                actions().dragAndDropBy(right, 5, 0).build().perform();
                int finalNewCurrentPercentage = Integer.parseInt(right.getText());
                if (finalNewCurrentPercentage == sliderRight) break;
            }
        }
    }

    @Then("The \"([^\"]*)\" slider has been successfully moved$")
    public void leftSliderHasBeenSuccessfullyMoved(String slider) {
        SelenideElement left = $("div:nth-child(2) > div > a:nth-child(1)");
        SelenideElement right = $("div:nth-child(2) > div > a:nth-child(3)");

        switch (slider) {
            case "left":
                left.shouldHave(matchText(Integer.toString(sliderL)));
                break;
            case "right":
                right.shouldHave(matchText(Integer.toString(sliderR)));
                break;
        }
    }
}