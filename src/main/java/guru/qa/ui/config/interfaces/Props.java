package guru.qa.ui.config.interfaces;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({"file:src/test/resources/system.properties"})
public interface Props extends Config{

    Props props = ConfigFactory.create(Props.class);

    @Key("automation-practice-form.url")
    String automationPracticeFormURL();
}
