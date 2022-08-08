package api;

import core.Config;
import org.junit.Test;

import static constants.Constants.Actions.GET_ACCOUNTS;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class ApiGetAccountsTest extends Config {

    @Test
    public void getAccountsTest() {
        final String customerId = Integer.toString(12212);

        given()
                .when()
                .pathParam("customerId", customerId)
                .get(GET_ACCOUNTS)
                .then()
                .spec(responseSpecification)
                .log().body()
                .body("type", notNullValue())
                .body("type[0]", equalTo("CHECKING"));
    }

}
