package guru.qa.ui.helpers;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LocatorGenerator {

    public static SelenideElement getLocatorFromString(String element, String value) {
        String selector = String.format(element, value);
        return $x(selector);
    }

    public static String getSelectorFromString(String element, String value) {
        return String.format(element, value);
    }
}
