package ui;

import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ui.models.Contributor;

import java.util.List;
import java.util.stream.Stream;

//@ExtendWith(ParameterResolver.class)
public class AboutPageTests extends BaseUITest {

    @Test
    @DisplayName("Verify list of contributors")
    @Description("Verify list of contributors")
    @Tag("UI")
    void verifyListOfContributors() {
        List<Contributor> listOfContributors = openWebsite().openAboutPage().getListOfContributors();

        SA.assertThat(listOfContributors).hasSize(5);

        listOfContributors.forEach(contributor -> {
            SA.assertThat(contributor.getGithubLink()).isNotEmpty();
            SA.assertThat(contributor.getName()).isNotEmpty();
        });

        SA.assertAll();
    }

    @ParameterizedTest(name = "{displayName}. Name = {0}, Expected amount = {1}.")
    @MethodSource
    @DisplayName("Verify amount of test entities on the website")
    @Description("Verify amount of test entities on the website")
    @Tag("UI")
    @TmsLink("HOME-3")
    void verifyAmountOfEntites(String type, Integer amount) {
        openWebsite().openAboutPage().verifyAmountOfObjects(type, amount);
    }

    private static Stream<Arguments> verifyAmountOfEntites() {
        return Stream.of(Arguments.of("People", 82),
                Arguments.of("Planets", 60),
                Arguments.of("Films", 6),
                Arguments.of("Species", 37),
                Arguments.of("Vehicles", 40));
    }
}
