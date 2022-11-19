package guru.qa.ui.utils;

import org.openqa.selenium.remote.RemoteWebDriver;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class Util {

    public static String getSessionId(){
        return ((RemoteWebDriver) getWebDriver()).getSessionId().toString();
    }
}
