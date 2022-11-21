package guru.qa.ui;

import com.codeborne.selenide.Condition;
import guru.qa.ui.config.DriverConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

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
}
