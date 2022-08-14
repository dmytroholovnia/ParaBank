package api.positive;

import core.Config;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.Test;

import static constants.Constants.Actions.LOGIN;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static constants.Constants.Statuses.REDIRECT;
import static io.restassured.RestAssured.given;

public class ApiLoginTest extends Config {

    private final RequestSpecification loginRequestSpec = new RequestSpecBuilder()
            .setBaseUri(server)
            .setBasePath(path)
            .build();

    private final ResponseSpecification loginResponseSpec = new ResponseSpecBuilder()
            .expectStatusCode(REDIRECT)
            .build();

    @Test
    public void login() {
        given()
                .spec(loginRequestSpec)
                .when()
                .formParams(getCredentials())
                .post(LOGIN)
                .then()
                .spec(loginResponseSpec);
    }

}
