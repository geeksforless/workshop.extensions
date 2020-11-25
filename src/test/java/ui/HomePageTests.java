package ui;

import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.widgets.JSONMapper;

public class HomePageTests extends BaseUITest {

    @Test
    @DisplayName("Verify proper output for invalid request")
    @Description("Verify proper output for invalid request")
    @Tag("UI")
    void verifyInvalidRequestOnHomePageInteractiveSection() {
        openWebsite()
                .enterRequestAndTryNow(FAKER.overwatch().quote());
        JSONMapper.verifyInvalidRequest();
    }

    @Test
    @DisplayName("Verify page layout")
    @Description("Verify page layout")
    @Tag("UI")
    void verifyPageLayout() {
        openWebsite()
                .verifyPageContent()
                .verifyDataHeaders();

    }
}
