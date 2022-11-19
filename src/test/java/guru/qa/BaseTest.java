package guru.qa;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.ui.config.DriverConfig;
import guru.qa.ui.helpers.CustomAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {

    @BeforeAll
    static void config() {
        DriverConfig.driverSetup();
    }

    @BeforeEach
    void beforeEachTest() {
        // Добавляет сценарий - не шаги, а действия над элементами
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void afterEachTest() {
        CustomAttachments.screenshotAs("Скриншот последней страницы");
        CustomAttachments.pageSource();
        if (DriverConfig.config.remoteDriverUrl() != null) {
            CustomAttachments.addVideoAsHtml();
            CustomAttachments.addVideoAsInputStream();
        }
        Selenide.closeWebDriver();
    }
}

