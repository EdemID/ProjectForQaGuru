package guru.qa.ui.config;

import com.codeborne.selenide.Configuration;
import guru.qa.ui.config.interfaces.Props;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverConfig {

    public static Props config = ConfigFactory.create(Props.class, System.getProperties());
    private static DesiredCapabilities capabilities = new DesiredCapabilities();
    private static ChromeOptions chromeOptions = new ChromeOptions();

    public static void driverSetup() {
        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");  // "https://demoqa.com"
        Configuration.browser = config.browser();
        Configuration.browserSize = config.browserSize();
        String browserName = config.browser();
        String remote = config.remoteDriverUrl();
        if (remote != null) {
            Configuration.remote = remote; // "https://user1:1234@selenoid.autotests.cloud/wd/hub"
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
        }
        if ("chrome".equals(browserName)){
            chromeOptions.addArguments("lang=ru-ru");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

            if (config.browserMobileView() != null) {
                Map<String, Object> mobileDevice = new HashMap<>();
                mobileDevice.put("deviceName", config.browserMobileView());
                chromeOptions.setExperimentalOption("mobileEmulation", mobileDevice);
            }
        }
        Configuration.browserCapabilities = capabilities;
    }
}
