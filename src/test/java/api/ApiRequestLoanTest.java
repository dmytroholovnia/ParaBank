package api;

import constants.Constants;
import core.Config;
import helper.Helper;
import io.restassured.RestAssured;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiRequestLoanTest extends Config {

    private final int amount = Helper.getRandomNumber(1, 100);
    private final int downPayment = Helper.getRandomNumber(1, 70);

    @Test
    public void requestLoanTest() {
        RestAssured.given()
                .queryParams(getQueryParamsForLoan())
                .when()
                .post(Constants.Actions.REQUEST_LOAN)
                .then()
                .spec(responseSpecification)
                .body(matchesJsonSchemaInClasspath("loanRequest.json"));
    }

    private Map<String, Integer> getQueryParamsForLoan() {
        Map<String, Integer> params = new HashMap<>();

        params.put("customerId", user.getCustomerId());
        params.put("amount", amount);
        params.put("downPayment", downPayment);
        params.put("fromAccountId", user.getAccountId());

        return params;
    }
}
