package api.controllers;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.filter.log.ErrorLoggingFilter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class BaseController {

    private static final String API_SUFFIX = "api/";

    protected static final String FILMS_BASE_URL = API_SUFFIX + "films/";
    protected static final String PEOPLE_BASE_URL = API_SUFFIX + "people/";
    protected static final String PLANETS_BASE_URL = API_SUFFIX + "planets/";
    protected static final String SPECIES_BASE_URL = API_SUFFIX + "species/";
    protected static final String STARSHIPS_BASE_URL = API_SUFFIX + "starships/";
    protected static final String VEHICLES_BASE_URL = API_SUFFIX + "vehicles/";

    protected static RequestSpecification prepareRequest() {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .filters(new RequestLoggingFilter(),
                        new ResponseLoggingFilter(),
                        new ErrorLoggingFilter(),
                        new AllureRestAssured());
    }

    protected static RequestSpecification prepareRequest(Map<String, Object> queryParams) {
        return prepareRequest().params(queryParams);
    }


}
