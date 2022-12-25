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
        FILTERS.$(withText(text)).shouldHave(Condition.visible);

        return this;
    }

    /**
     * виджет "напишите нам", на странице https://career.habr.com/ , перекрывает элементы,
     * когда размер окна браузера маленький (например, 1092x720)
     * из-за этого  падает с исключением ElementClickInterceptedException
     * как этого избежать? этот виджет не исчезает после его закрытия.
     * одно из решений - передвинуть его на другую сторону от элемента который закрывает
     * как можно сделать так, чтобы вызывался этот метод тогда, когда виджет закроет любой элемент?
     * можно, например, через try-catch, но во-первых нежелательно строить логику через исключения
     * во-вторых как вернутся к тому месту, на котором выпало исключение?
     */
    @Step("Close popup")
    public static void closePopup() {
        POPUP.click();
        CLOSE_POPUP.click();
    }
}
