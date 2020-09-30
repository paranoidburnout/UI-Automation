package functionality;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.actions;



public class Sliders {
    @And("^Opened through the left menu Service -> Dates$")
    public void openedServiceAndDatesPages() {
        $(By.xpath("//a/span[contains(text(),'Service')]")).shouldBe(visible).click();
        $(By.xpath("//a/p/span[contains(text(),'Dates')]")).shouldBe(visible).click();
    }

    @When("User clicked on the left slider and drag him to {int}")
    public void movingTheLeftSlider(int sliderLeft) {

        SelenideElement left = $("div:nth-child(2) > div > a:nth-child(1)");
        left.scrollIntoView(true);
        actions().dragAndDropBy(left, -276, 0).build().perform();
        actions().dragAndDropBy(left, (int) ((sliderLeft * 2.64)), 0).build().perform();
        left.shouldHave(Condition.matchText(Integer.toString(sliderLeft)));
    }

    @And("On the right slider and drag him to {int} user clicked")
    public void movingTheRightSlider(int sliderRight) {

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

        right.shouldHave(Condition.matchText(Integer.toString(sliderRight)));

    }
//    @Then("The \"([^\"]*)\" slider has been successfully moved$")
//    public void leftSliderHasBeenSuccessfullyMoved(String right, int percent){
//        percent=Integer.valueOf($$("div:nth-child(2) > div > a:nth-child(1)"))
//    }
//    @Then("^In logs panel  status changed to \"([^\"]*)\"$")
//    public void inLogsPanelWaterStatusChangedToTrue(String water, boolean status) {
//        assertTrue(status);
//        status = $$(By.xpath("//*[@class='panel-body-list logs']/li"))
//                .stream()
//                .map(SelenideElement::getText)
//                .anyMatch(s -> s.contains(water));
//    }
}