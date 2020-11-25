package ui.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.page;

public class NavHeader implements BasePage {

    @Step("Open About page")
    public AboutPage openAboutPage() {
        $$(".nav * a")
                .filter(Condition.text("About"))
                .first()
                .click();
        return page(AboutPage.class);
    }

    @Step("Open Documentation page")
    public DocumentationPage openDocumentationPage() {
        $$(".nav * a")
                .filter(Condition.text("Documentation"))
                .first()
                .click();
        return page(DocumentationPage.class);
    }

}
