package ui.widgets;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import io.qameta.allure.Step;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$;

public class JSONMapper {

    private static final SelenideElement JSON_CONTAINER = $("#interactive_output");
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Step("Verify invalid request")
    public static void verifyInvalidRequest() {
        JSON_CONTAINER.shouldHave(Condition.text("404 error"));
    }

    @Step("Convert String output to list of objects")
    @SneakyThrows
    public static <T> List<T> convertOutputToListOfObjects(Class<T> objectKlazz) {
        CollectionType listType = OBJECT_MAPPER.getTypeFactory()
                .constructCollectionType(ArrayList.class, objectKlazz);
        return OBJECT_MAPPER.readValue(JSON_CONTAINER.getText(), listType);
    }

    @Step("Convert String output to list of objects")
    @SneakyThrows
    public static <T> T convertOutputToObject(Class<T> objectKlazz) {
        return OBJECT_MAPPER.readValue(JSON_CONTAINER.getText(), objectKlazz);
    }

}
