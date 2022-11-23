package guru.qa.ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    private static final SelenideElement FILTERS = $(byXpath("//*[text()='Выбранные вами фильтры:']/parent::span"));
    private static final SelenideElement POPUP = $(".hoverl_f1bd");
    private static final SelenideElement CLOSE_POPUP = $(".closeIcon_b30f");

    @Step("Check selected filters")
    public BasePage checkSelectedFilters(String text) {
        FILTERS.$(withText(text)).shouldHave(Condition.text(text));

        return this;
    }

    /**
     * виджет на странице "напишите нам" перекрывается элементы, когда размер браузера маленький
     * из-за этого при маленьком размере окна (например, 1092x720) падает с исключением ElementClickInterceptedException
     * как этого избежать? этот виджет не исчезает после его закрытия.
     * одно из решений - передвинуть его на другую сторону от элемента который закрывает
     * как можно сделать так, чтобы вызывался этот метод тогда, когда виджет закроет любой элемент?
     */
    @Step("Close popup")
    public static void closePopup() {
        POPUP.click();
        CLOSE_POPUP.click();
    }
}
