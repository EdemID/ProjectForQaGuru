package guru.qa.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SpecialistsPage extends BasePage {

    private SelenideElement location = $("*[placeholder = 'Введите город, область или страну']");
    private SelenideElement suggestionResult = $(".suggestion-results");
    @Step("Select a location")
    public SpecialistsPage selectLocation(String loc) {
        location.sendKeys(loc);
        suggestionResult.$(withText(loc)).click();

        return this;
    }

    @Step("Select a additionally")
    public SpecialistsPage selectAdditionally(String values) {
        $x("//*[contains(text(), '" + values + "')]/parent::label").click();

        return this;
    }
}
