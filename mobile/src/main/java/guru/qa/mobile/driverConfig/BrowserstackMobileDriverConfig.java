package guru.qa.mobile.driverConfig;

import com.codeborne.selenide.WebDriverProvider;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static guru.qa.mobile.interfaces.Props.PROPS;

public class BrowserstackMobileDriverConfig implements WebDriverProvider {

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", PROPS.browserstackUserName());
        mutableCapabilities.setCapability("browserstack.key", PROPS.browserstackPassword());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", PROPS.appUrl());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", PROPS.mobileDeviceName());
        mutableCapabilities.setCapability("os_version", PROPS.mobileDeviceOsVersion());

        // Set other BrowserStack capabilities
        mutableCapabilities.setCapability("project", PROPS.browserstackProject());
        mutableCapabilities.setCapability("build", PROPS.browserstackBuild());
        mutableCapabilities.setCapability("name", PROPS.browserstackTestsName());

        // Set timezone for device
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("browserstack.timezone", PROPS.timezone());
        desiredCapabilities.merge(mutableCapabilities);

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        return new RemoteWebDriver(getAppiumServerUrl(), desiredCapabilities);
    }

    public static URL getAppiumServerUrl() {
        try {
            return new URL(PROPS.mobileServerRemoteUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
