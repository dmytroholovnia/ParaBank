package api;

import core.Config;
import org.junit.Test;

import static constants.Constants.Actions.GET_TRANSACTIONS;
import static io.restassured.RestAssured.given;

public class ApiGetTransactionsTest extends Config {

    @Test
    public void getTransactionsTest() {

        given()
                .when()
                .pathParam("accountId", user.getAccountId())
                .get(GET_TRANSACTIONS)
                .then()
                .spec(responseSpecification);
    }
}
