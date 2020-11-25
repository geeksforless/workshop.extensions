package ui.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import java.time.LocalDate;

import static com.codeborne.selenide.Selenide.$;

public interface BasePage {

    SelenideElement HEADER_CONTAINER = $(".jumbotron");

    @Step("Verify page header")
    default void verifyPageHeader() {
        HEADER_CONTAINER.$(By.tagName("h1")).shouldHave(Condition.text("SWAPI"));
        HEADER_CONTAINER.$(".lead").shouldHave(Condition.text("The Star Wars API"));
        HEADER_CONTAINER.$(".lead > a").shouldHave(Condition.text("(what happened to swapi.co?)"));

    }

    @Step("Verify year in footer")
    default void verifyYearInFooter() {
        $(".footer").shouldHave(Condition.text(String.valueOf(LocalDate.now().getYear())));
    }

}
