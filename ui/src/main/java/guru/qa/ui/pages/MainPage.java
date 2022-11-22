package guru.qa.ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {

    private SelenideElement vacancies = $(".header__top_main_menu").$("*[href $= 'vacancies']");

    @Step("Open home page")
    public BasePage openPage(String url) {
        open(url);
        return this;
    }

    @Step("Go to the tab 'Vacancies'")
    public VacanciesPage openVacanciesPage() {
        vacancies.click();
        return new VacanciesPage();
    }
}
