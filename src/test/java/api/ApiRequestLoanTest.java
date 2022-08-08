package api;

import constants.Constants;
import core.Config;
import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiRequestLoanTest extends Config {

    @Test
    public void requestLoanTest() {
        RestAssured.given()
                .queryParams(getQueryParamsForLoan())
                .when()
                .post(Constants.Actions.REQUEST_LOAN)
                .then()
                .spec(responseSpecification)
                .body(matchesJsonSchemaInClasspath("jsonSchemaForLoanRequest.json"));
    }

    private Map<String, Integer> getQueryParamsForLoan() {
        Map<String, Integer> params = new HashMap<>();

        params.put("customerId", 12212);
        params.put("amount", 100);
        params.put("downPayment", 50);
        params.put("fromAccountId", 13344);

        return params;
    }
}
