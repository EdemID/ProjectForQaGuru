package guru.qa.ui;

import com.codeborne.selenide.Condition;
import guru.qa.ui.config.DriverConfig;
import guru.qa.ui.pages.MainPage;
import guru.qa.ui.pages.VacanciesPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Tag("UI")
public class CareerHabrTest extends BaseTest {

    private String url = DriverConfig.config.baseUrl();

    @Test
    @DisplayName("Go to the tab \"Salaries in IT\"")
    void goToTabITSalaries() {
        step(String.format("Open url: %s", url), () -> open(url));
        step("Go to the tab \"Salaries in IT\"", () -> $("*[href='https://career.habr.com/salaries']").click());
        step("\"Salaries in IT\" should be on the page", () -> $("#users_list_title").shouldBe(Condition.visible));
    }

    @ParameterizedTest(name = "Choose the specialization {0} and the qualification {1}")
    @MethodSource("guru.qa.ui.helpers.TestData#chooseSpecAndQualification")
    void chooseSpecAndQualification(String spec, String qual, String expectedSpec) {
        MainPage mainPage = new MainPage();
        mainPage.openPage(url);
        VacanciesPage vacanciesPage = mainPage.openVacanciesPage();
        vacanciesPage
                .selectSpecialization(spec)
                .selectQualification(qual)
                .checkSelectedFilters(expectedSpec)
                .checkSelectedFilters(qual);
    }
}
