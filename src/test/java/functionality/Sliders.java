package functionality;

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
        pageService.shouldBe(visible).click();
        pageDates.shouldBe(visible).click();
    }

    @When("User clicked on the left slider and drag it to {int}")
    public void movingTheLeftSlider(int sliderLeft) {
        sliderL = sliderLeft;
        leftSlider.scrollIntoView(true);
        actions().dragAndDropBy(leftSlider, -276, 0).build().perform();
        actions().dragAndDropBy(leftSlider, (int) ((sliderLeft * 2.64)), 0).build().perform();
    }

    @And("On the right slider and drag it to {int} user clicked")
    public void movingTheRightSlider(int sliderRight) {
        sliderR = sliderRight;
        rightSlider.scrollIntoView(true);
        int currentPercentage = Integer.parseInt(rightSlider.getText());
        int diff = currentPercentage - sliderRight;
        actions().dragAndDropBy(rightSlider, (int) ((-(diff) * 2.64)), 0).build().perform();
        int newCurrentPercentage = Integer.parseInt(rightSlider.getText());
        if (newCurrentPercentage > sliderRight) {
            while (true) {
                actions().dragAndDropBy(rightSlider, -5, 0).build().perform();
                int finalNewCurrentPercentage = Integer.parseInt(rightSlider.getText());
                if (finalNewCurrentPercentage == sliderRight) break;
            }
        } else if (newCurrentPercentage < sliderRight) {
            while (true) {
                actions().dragAndDropBy(rightSlider, 5, 0).build().perform();
                int finalNewCurrentPercentage = Integer.parseInt(rightSlider.getText());
                if (finalNewCurrentPercentage == sliderRight) break;
            }
        }
    }

    @Then("The \"([^\"]*)\" slider has been successfully moved$")
    public void leftSliderHasBeenSuccessfullyMoved(String slider) {
        switch (slider) {
            case "left":
                leftSlider.shouldHave(matchText(Integer.toString(sliderL)));
                break;
            case "right":
                rightSlider.shouldHave(matchText(Integer.toString(sliderR)));
                break;
        }
    }

    SelenideElement pageService = $(By.xpath("//a/span[contains(text(),'Service')]"));
    SelenideElement pageDates = $(By.xpath("//a/p/span[contains(text(),'Dates')]"));
    SelenideElement leftSlider = $("div:nth-child(2) > div > a:nth-child(1)");
    SelenideElement rightSlider = $("div:nth-child(2) > div > a:nth-child(3)");
}