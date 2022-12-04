package guru.qa.mobile;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.BrowserPerTestStrategyExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.mobile.driverConfig.BrowserstackMobileDriverConfig;
import guru.qa.mobile.driverConfig.LocalMobileDriverConfig;
import guru.qa.mobile.helpers.CustomAttachments;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sessionId;
import static guru.qa.mobile.interfaces.Props.PROPS;
import static guru.qa.mobile.utils.MobileEnvironment.BROWSERSTACK;
import static guru.qa.mobile.utils.MobileEnvironment.EMULATION;

@ExtendWith({BrowserPerTestStrategyExtension.class})
public class BaseTest {

    @BeforeAll
    static void config() throws RuntimeException{
        Configuration.baseUrl = PROPS.baseUrl();
        RestAssured.baseURI = PROPS.apiUrl();
        if (PROPS.mobileEnv().equals(BROWSERSTACK)) {
            Configuration.browser = BrowserstackMobileDriverConfig.class.getName();
        } else if(PROPS.mobileEnv().equals(EMULATION)) {
            Configuration.browser = LocalMobileDriverConfig.class.getName();
        } else {
            throw new RuntimeException("Unrecognised mobileEnvironment");
        }
        Configuration.browserSize = null;
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @BeforeEach
    public void startDriver() {
        open();
    }

    @AfterEach
    public void addAttachments() {
//        CustomAttachments.screenshotAs("Last screenshot");
//        CustomAttachments.pageSource();
        if (PROPS.mobileEnv().equals(BROWSERSTACK))
            CustomAttachments.video(sessionId().toString());

        Selenide.closeWebDriver();
    }
}
