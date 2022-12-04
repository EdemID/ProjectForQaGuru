package guru.qa.mobile.interfaces;

import com.codeborne.selenide.Browser;
import guru.qa.mobile.utils.MobileEnvironment;
import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/authorizationData.properties",
        "classpath:config/${env}.properties",
        "classpath:config/mobile.${deviceHost}.properties",
        "file:~/${env}.properties",
        "file:./${env}.properties"
})
public interface Props extends Config {

    Props PROPS = ConfigFactory.create(Props.class);

    @Key("email")
    String email();

    @Key("password")
    String password();

    @Key("browser")
    @DefaultValue("CHROME")
    Browser browser();

    @Key("browser.version")
    String browserVersion();

    @Key("browser.size")
    @DefaultValue("1280x1080")
    String browserSize();

    @Key("base_url")
    @DefaultValue("https://todoist.com/")
    String baseUrl();

    @Key("api_url")
    @DefaultValue("https://api.todoist.com/rest/v2/")
    String apiUrl();

    @Key("token")
    String token();

    @Key("isRemote")
    @DefaultValue("false")
    boolean isRemote();

    @Key("remote.url")
    @DefaultValue("http://localhost:4444")
    String remoteUrl();

    @Key("video.storage")
    String videoStorage();

    @Key("timezone")
    @DefaultValue("Europe/Moscow")
    String timezone();

    @Key("browserstack.user_name")
    String browserstackUserName();

    @Key("browserstack.password")
    String browserstackPassword();

    @Key("browserstack.project")
    String browserstackProject();

    @Key("browserstack.build")
    String browserstackBuild();

    @Key("browserstack.tests_name")
    String browserstackTestsName();

    @Key("browserstack.sessionsUrl")
    String browserstackSessionsUrl();

    @Key("app.app_url")
    String appUrl();

    @Key("app.package")
    @DefaultValue("com.todoist")
    String appPackage();

    @Key("app.activity")
    @DefaultValue("com.todoist.alias.HomeActivityDefault")
    String appActivity();

    @Key("app.name")
    @DefaultValue("todoist.apk")
    String appName();

    @Key("device.device_name")
    @DefaultValue("Pixel_4_API_30")
    String mobileDeviceName();

    @Key("device.platform_name")
    @DefaultValue("Android")
    String mobilePlatformName();

    @Key("device.os_version")
    @DefaultValue("11.0")
    String mobileDeviceOsVersion();

    @Key("server.remoteUrl")
    @DefaultValue("http://localhost:4723/wd/hub")
    String mobileServerRemoteUrl();

    @Key("mobileEnvironment")
    @DefaultValue("EMULATION")
    MobileEnvironment mobileEnv();
}
