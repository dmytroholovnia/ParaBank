package api;

import core.Config;
import org.junit.Test;

import static constants.Constants.Actions.GET_ACCOUNTS;
import static constants.Constants.Statuses.SUCCESS;
import static io.restassured.RestAssured.given;

public class ApiGetAccountsTest extends Config {

    @Test
    public void getAccountsTest() {
        final String customerId = Integer.toString(12212);

        given()
                .when()
                .cookie("JSESSIONID", getAuthCookieValue())
                .pathParam("customerId", customerId)
                .log().uri()
                .get(GET_ACCOUNTS)
                .then()
                .statusCode(SUCCESS)
                .log().all();
    }

}
