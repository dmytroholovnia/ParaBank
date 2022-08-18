package api.positive;

import core.Config;
import org.junit.Test;

import static constants.Constants.Actions.GET_TRANSACTIONS;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class ApiGetTransactionsTest extends Config {

    @Test
    public void getTransactionsTest() {

        given()
                .when()
                .pathParam("accountId", user.getAccountId())
                .get(GET_TRANSACTIONS)
                .then()
                .spec(responseSpecification)
                .body(matchesJsonSchemaInClasspath("getTransactions.json"));
    }
}
