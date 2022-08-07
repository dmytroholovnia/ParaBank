package api;

import core.Config;
import org.junit.Test;

import static constants.Constants.Actions.GET_TRANSACTIONS;
import static io.restassured.RestAssured.given;

public class ApiGetTransactionsTest extends Config {

    @Test
    public void getTransactionsTest() {
        final String accountId = Integer.toString(13122);

        given()
                .when()
                .pathParam("accountId", accountId)
                .log().ifValidationFails()
                .get(GET_TRANSACTIONS)
                .then()
                .spec(responseSpecification)
                .log().all();
    }
}
