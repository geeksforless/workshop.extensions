package api;

import io.qameta.allure.Step;
import io.restassured.response.Response;

import java.util.List;

public class AssertableResponse {

    private Response response;

    public AssertableResponse(Response response) {
        this.response = response;
    }

    @Step("Verify status code")
    public AssertableResponse verifyRequestStatus(int statusCode) {
        response.then().assertThat().statusCode(statusCode);
        return this;
    }

    @Step("Map response to object")
    public <T> T mapResponseToObject(Class<T> klazz) {
        return response.getBody().jsonPath().getObject("",klazz);
    }

    @Step("Map response to list of objects")
    public <T> List<T> getListResponseBodyFromWrapper(Class<T> klazz) {
        return response.getBody().jsonPath().getList("results", klazz);
    }

}
