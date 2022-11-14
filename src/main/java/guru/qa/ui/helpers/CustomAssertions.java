package guru.qa.ui.helpers;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

public class CustomAssertions {

    public static void assertShouldHave(SelenideElement element, Condition expectedCondition) {
        element.shouldHave(expectedCondition);
    }
}
