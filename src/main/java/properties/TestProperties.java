package properties;

import org.aeonbits.owner.Config;

/**
 * browser - chrome, firefox
 */
public interface TestProperties extends Config {

    @Key("base.url")
    String baseUrl();

    @DefaultValue("chrome")
    @Key("browser")
    String browser();

}
