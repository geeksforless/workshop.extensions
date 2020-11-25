package ui;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.widgets.JSONMapper;

public class HomePageTests extends BaseUITest {

    @Test
    @DisplayName("Verify proper output for invalid request")
    @Description("Verify proper output for invalid request")
    @Tag("UI")
    @TmsLink("HOME-1")
    void verifyInvalidRequestOnHomePageInteractiveSection() {
        openWebsite()
                .enterRequestAndTryNow(FAKER.overwatch().quote());
        JSONMapper.verifyInvalidRequest();
    }

    @Test
    @DisplayName("Verify page layout")
    @Description("Verify page layout")
    @Tag("UI")
    @TmsLink("HOME-2")
    void verifyPageLayout() {
        openWebsite()
                .verifyPageContent()
                .verifyDataHeaders();

    }
}
