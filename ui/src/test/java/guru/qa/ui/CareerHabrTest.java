package guru.qa.ui;

import com.codeborne.selenide.Condition;
import guru.qa.ui.config.DriverConfig;
import guru.qa.ui.pages.MainPage;
import guru.qa.ui.pages.SpecialistsPage;
import guru.qa.ui.pages.VacanciesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("UI")
public class CareerHabrTest extends BaseTest {

    private String url = DriverConfig.config.baseUrl();
    MainPage mainPage = new MainPage();

    @Test
    @DisplayName("Go to the tab \"Salaries in IT\"")
    void goToTabITSalaries() {
        step(String.format("Open url: %s", url), () -> open(url));
        step("Go to the tab \"Salaries in IT\"", () -> $("*[href='https://career.habr.com/salaries']").click());
        step("\"Salaries in IT\" should be on the page", () -> $("#users_list_title").shouldBe(Condition.visible));
    }

    @ParameterizedTest(name = "Select specialization {0} and qualification {1}")
    @MethodSource("guru.qa.ui.helpers.TestData#selectSpecAndQualificationInVacancies")
    void selectSpecAndQualificationInVacancies(String spec, String qual, String expectedSpec) {
        mainPage.openHomePage(url);
        VacanciesPage vacanciesPage = mainPage.openVacanciesPage();
        vacanciesPage
                .selectSpecialization(spec)
                .selectQualification(qual)
                .checkSelectedFilters(expectedSpec)
                .checkSelectedFilters(qual);
    }

    @ParameterizedTest(name = "Select location {0} and additionally {1}")
    @CsvSource(value = {"Ростов-на-Дону, С дополнительным образованием, С доп. образованием", "Москва, Указана зарплата, Указана зарплата"})
    void selectLocationAndAdditionally(String city, String value, String expectedValue) {
        mainPage.openHomePage(url);
        mainPage.goToSection("Специалисты", SpecialistsPage.class)
                .selectLocation(city)
                .selectAdditionally(value)
                .checkSelectedFilters(city)
                .checkSelectedFilters(expectedValue);
    }
}
