package api;

import core.Config;
import org.junit.Test;

import static constants.Constants.Actions.LOGIN;
import static constants.Constants.Statuses.REDIRECT;
import static io.restassured.RestAssured.given;

public class ApiLoginTest extends Config {

    @Test
    public void login() {
                given()
                .when()
                .formParams(getCredentials())
                .post(LOGIN)
                .then()
                .statusCode(REDIRECT)
                .log().all();
    }

}
