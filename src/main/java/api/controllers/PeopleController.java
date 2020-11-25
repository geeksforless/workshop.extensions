package api.controllers;

import api.AssertableResponse;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class PeopleController extends BaseController {


    @Step("Get list of people aka characters")
    public static AssertableResponse getListOfPeople() {
        Response response = prepareRequest().when().get(PEOPLE_BASE_URL).then().extract().response();
        return new AssertableResponse(response);
    }

    @Step("Get person by id {id}")
    public static AssertableResponse getPersonById(int id) {
        Response response = prepareRequest().when().get(PEOPLE_BASE_URL + id).then().extract().response();
        return new AssertableResponse(response);
    }


}
