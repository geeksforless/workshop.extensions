package ui.pages;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.*;

@Getter
public class HomePage extends NavHeader {

    public HomePage() {
        verifyPageHeader();
        verifyYearInFooter();
    }


    @Step("Send test request via UI to {partialUrl} endpoint")
    public HomePage enterRequestAndTryNow(String partialUrl) {
        $("#interactive").sendKeys(partialUrl);
        $(".input-group-btn > button").click();
        return this;
    }

    @Step("Verify page content on current page")
    public HomePage verifyPageContent() {
        $(".row > .center").shouldHave(
                Condition.text("All the Star Wars data you've ever wanted:"),
                Condition.text("Planets, Spaceships, Vehicles, People, Films and Species"),
                Condition.text("From all"),
                Condition.text("From all"),
                Condition.text("SEVEN"),
                Condition.text(" Star Wars films"),
                Condition.text("Now with The Force Awakens data!")
        );
        return this;
    }

    @Step("Verify data headers on page")
    public HomePage verifyDataHeaders() {
        $$("h4[class='center']")
                .shouldHave(CollectionCondition.texts("What is this?",
                        "How can I use it?",
                        "What happened with old swapi.co?"));
        return this;
    }

    @Step("Open About page")
    public AboutPage openAboutPage() {
        $$(".nav * a")
                .filter(Condition.text("About"))
                .first()
                .click();
        return page(AboutPage.class);
    }


}
