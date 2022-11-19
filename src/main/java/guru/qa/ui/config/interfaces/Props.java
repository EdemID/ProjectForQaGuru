package guru.qa.ui.config.interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "classpath:config/local.properties",
        "system:properties"
})
public interface Props extends Config {

    @DefaultValue("chrome")
    String browser();
    String browserVersion();
    @DefaultValue("1920x1080")
    @Key("browserSize")
    String browserSize();
    String browserMobileView();
    String remoteDriverUrl();
    String videoStorage();
}