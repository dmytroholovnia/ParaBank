package api.positive;

import core.Config;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static constants.Constants.Actions.LOGIN;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Statuses.REDIRECT;
import static io.restassured.RestAssured.given;

public class ApiLoginTest extends Config {

    @Before
    @Override
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void login() {

        given()
                .when()
                .formParams(getCredentials())
                .post(LOGIN)
                .then()
                .statusCode(REDIRECT);
    }

}
