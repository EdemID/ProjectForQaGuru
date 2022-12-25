package guru.qa.ui.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage extends BasePage {


    private SelenideElement topMainMenu = $(".header__top_main_menu");
    private SelenideElement vacancies = topMainMenu.$("*[href $= 'vacancies']");

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

    @Step("Go to the tab '{page}'")
    public <T extends BasePage> T goPageFromTopMainMenu(String page, Class<T> nextPageClass) {
        topMainMenu.$(byText(page)).click();
        return nextPageClass.cast(Selenide.page(nextPageClass));
    }
}
