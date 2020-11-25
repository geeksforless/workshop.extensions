package ui.pages;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ui.models.Contributor;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AboutPage extends NavHeader {

    public AboutPage() {
        verifyPageHeader();
        verifyYearInFooter();
    }

    @Step("Get list of contributors to SWAPI.DEV project")
    public List<Contributor> getListOfContributors() {
        return $$(".row * ul > li > a")
                .stream()
                .map(infoLine -> Contributor.builder()
                        .name(infoLine.getText())
                        .githubLink(infoLine.getAttribute("href"))
                        .build())
                .collect(Collectors.toList());
    }

    @Step("Verify amount of available objects")
    public AboutPage verifyAmountOfObjects(String type, int amountOfObjects) {
        $(By.tagName("h4")).parent().$$(By.tagName("p"))
                .find(Condition.text(type))
                .shouldHave(Condition.text(String.valueOf(amountOfObjects)));

        return this;
    }
}
