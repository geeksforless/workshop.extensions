package api;

import api.controllers.PeopleController;
import api.models.Person;
import extensions.execution.condition.TypeExecutionDefinitionExtension;
import extensions.parameter.resolver.ParameterResolverExtension;
import io.qameta.allure.Description;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

//@ExtendWith(TypeExecutionDefinitionExtension.class)
@ExtendWith(ParameterResolverExtension.class)
public class PeopleControllerTests extends BaseAPITest {

    @Test
    @DisplayName("Verify Proper People Controller Work")
    @Description("Verify Proper People Controller Work")
    @Tag("API")
    void verifyProperPeopleControllerWork() {
        PeopleController.getListOfPeople().verifyRequestStatus(200);
    }

    @Test
    @DisplayName("Verify person with ID = 1")
    @Description("Verify person with ID = 1")
    @Tag("API")
    @TmsLink("HOME-101")
    void verifyPersonById() {
        Person firstPerson = PeopleController.getPersonById(1).verifyRequestStatus(200)
                .mapResponseToObject(Person.class);

        SA.assertThat(firstPerson.getGender()).isEqualTo("male");
        SA.assertThat(firstPerson.getName()).isEqualTo("Luke Skywalker");
        SA.assertThat(firstPerson.getVehicles()).hasSize(2);

        SA.assertAll();
    }

    @ParameterizedTest(name = "{displayName}.")
    @MethodSource("verifyNameById")
    @DisplayName("Verify person's name by provided id")
    @Description("Verify person's name by provided id")
    @Tag("API")
    @TmsLink("HOME-101")
    void verifyPersonNameById(Integer id, String name) {
        assertThat(PeopleController
                .getPersonById(id)
                .verifyRequestStatus(200)
                .mapResponseToObject(Person.class)
                .getName())
                .isEqualTo(name);
    }

    private static Stream<Arguments> verifyNameById() {
        return Stream.of(Arguments.of(1, "Luke Skywalker"),
                Arguments.of(7, "Beru Whitesun lars"),
                Arguments.of(9, "Biggs Darklighter"),
                Arguments.of(4, "Darth Vader")
        );
    }
}
