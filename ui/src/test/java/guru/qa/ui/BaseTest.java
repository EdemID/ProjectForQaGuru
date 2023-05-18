package guru.qa.ui;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.ui.config.DriverConfig;
import guru.qa.ui.helpers.CustomAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

public abstract class BaseTest {

    @BeforeAll
    static void config() {
        DriverConfig.driverSetup();
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

