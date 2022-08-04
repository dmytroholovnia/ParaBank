package api;

import core.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;

import static constants.Constants.Actions.LOGIN;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Statuses.REDIRECT;
import static io.restassured.RestAssured.given;

public class ApiLoginTest extends Config {

    private final RequestSpecification loginSpec = new RequestSpecBuilder()
            .setBaseUri(server)
            .setBasePath(path)
            .build();

    @Test
    public void login() {
                given()
                .spec(loginSpec)
                .when()
                .formParams(getCredentials())
                .post(LOGIN)
                .then()
                .statusCode(REDIRECT)
                .log().all();
    }

}
