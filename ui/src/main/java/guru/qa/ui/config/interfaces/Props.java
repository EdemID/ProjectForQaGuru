package guru.qa.ui.config.interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/local.properties"
})
public interface Props extends Config {

    String baseUrl();

    @DefaultValue("chrome")
    @Key("browser.name")
    String browser();

    @Key("browser.version")
    String browserVersion();

    @DefaultValue("1920x1080")
    @Key("browser.size")
    String browserSize();

    String browserMobileView();

    @Key("remote")
    String remoteDriverUrl();

    String videoStorage();
}