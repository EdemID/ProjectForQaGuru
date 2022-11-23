package guru.qa.ui.pages;

import com.codeborne.selenide.SelenideElement;
import guru.qa.ui.helpers.LocatorGenerator;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withTagAndText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class VacanciesPage extends BasePage {

    private SelenideElement specialization = $(".specs-picker__specs");
    private SelenideElement buttonApply = $(withTagAndText("button","Применить"));
    private SelenideElement qualification = $x("//*[contains(text(), 'Квалификация')]/ancestor::div[@class='content-section content-section--appearance-form-section']//select");
    private String qualityAssuranceSelector = "//*[contains(text(), '%s')]/ancestor::div[@class= 'specs-selector__group-wrapper']//*[@type='checkbox']/../span";

    @Step("Select a specialization")
    public VacanciesPage selectSpecialization(String spec) {
        SelenideElement qualityAssurance = LocatorGenerator.getLocatorFromString(qualityAssuranceSelector, spec);
        specialization.click();
        qualityAssurance.click();
        buttonApply.click();

        return this;
    }

    @Step("Select a qualification")
    public VacanciesPage selectQualification(String qual) {
        qualification.selectOptionContainingText(qual);

        return this;
    }
}
