package guru.qa.ui;

import com.codeborne.selenide.Condition;
import guru.qa.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class CareerHabrTest extends BaseTest {

     String url = "https://career.habr.com/";

    @Test
    @DisplayName("Go to the tab \"Salaries in IT\"")
    void goToTabITSalaries() {
        step(String.format("Open url: %s", url), () -> open(url));
        step("Go to the tab \"Salaries in IT\"", () -> $("*[href='https://career.habr.com/salaries']").click());
        step("\"Salaries in IT\" should be on the page", () -> $("#users_list_title").shouldBe(Condition.visible));
    }
}
