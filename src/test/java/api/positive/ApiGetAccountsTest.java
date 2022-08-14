package api.positive;

import core.Config;
import org.junit.Test;

import static constants.Constants.Actions.GET_ACCOUNTS;
import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;



public class ApiGetAccountsTest extends Config {

    @Test
    public void getAccountsTest() {

        given()
                .when()
                .pathParam("customerId", user.getCustomerId())
                .get(GET_ACCOUNTS)
                .then()
                .spec(responseSpecification)
                .body(matchesJsonSchemaInClasspath("getAccounts.json"))
                .body("type", notNullValue())
                .body("type[0]", equalTo("CHECKING"));
    }

}
