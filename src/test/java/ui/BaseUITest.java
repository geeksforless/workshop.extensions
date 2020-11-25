package ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.junit5.BrowserStrategyExtension;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import properties.TestProperties;
import ui.pages.HomePage;

import java.util.Locale;

/**
 * Add existing extension: ScreenShooterExtensions, TextReportExtension.
 * <p>
 * Write extensions:
 * 1 - that parses input parameters to parameterized test
 * 2 - the one which decides to not launch tests without annotation @TmsLink
 * 3 - the one that writes to console detailed result of test - name, status (PASSED, FAILED), time, and exception if FAILED
 */

@ExtendWith(BrowserStrategyExtension.class)
public class BaseUITest {

    private static final TestProperties PROPS = ConfigFactory.create(TestProperties.class, System.getProperties());
    protected static final Faker FAKER = new Faker(Locale.FRANCE);
    protected final SoftAssertions SA = new SoftAssertions();

    @BeforeAll
    static void beforeAll() {

        Configuration.browser = PROPS.browser();
        Configuration.timeout = 8000L;

        AllureSelenide allureSelenide = new AllureSelenide()
                .includeSelenideSteps(true)
                .screenshots(true)
                .savePageSource(true);

        SelenideLogger.addListener("allure-selenide", allureSelenide);
    }

    @Step("Open Home Page")
    protected HomePage openWebsite() {
        return Selenide.open(PROPS.baseUrl(), HomePage.class);
    }
}
