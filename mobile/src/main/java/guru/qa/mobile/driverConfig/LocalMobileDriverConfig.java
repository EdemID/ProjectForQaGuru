package guru.qa.mobile.driverConfig;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.AutomationName;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import static guru.qa.mobile.interfaces.Props.PROPS;
import static org.apache.commons.io.FileUtils.copyInputStreamToFile;

public class LocalMobileDriverConfig implements WebDriverProvider {
    
    public static URL getAppiumServerUrl() {
        try {
            return new URL(PROPS.mobileServerRemoteUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        File app = getApp();

        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);
        options.setApp(app.getAbsolutePath());
        options.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);

        options.setAppPackage(PROPS.appPackage());
        options.setAppActivity(PROPS.appActivity());
        options.setDeviceName(PROPS.mobileDeviceName());
        options.setPlatformName(PROPS.mobilePlatformName());
        options.setPlatformVersion(PROPS.mobileDeviceOsVersion());

        options.setCapability("unicodeKeyboard", true);
        options.setCapability("resetKeyboard", true);

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private File getApp() {
        String appUrl = null;
        String appPath = guru.qa.mobile.driverConfig.LocalMobileDriverConfig.class.getClassLoader().getResource("apps/" + PROPS.appName()).getPath();
//        String appPath = "apps/todoist.apk";
        File app = new File(appPath);
        if (!app.exists()) {
            try (InputStream in = new URL(appUrl).openStream()) {
                copyInputStreamToFile(in, app);
            } catch (IOException e) {
                throw new AssertionError("Failed to download application", e);
            }
        }
        return app;
    }
}
