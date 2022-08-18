package api.negative;

import core.Config;
import io.restassured.RestAssured;
import models.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static constants.Constants.Actions.LOGIN;
import static constants.Constants.RunVariable.path;
import static constants.Constants.RunVariable.server;
import static io.restassured.RestAssured.given;
import static org.junit.runners.Parameterized.Parameter;
import static org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class InvalidCredentialsTests extends Config {

    private static final User user = new User();

    @Parameters(name = "{0}")
    public static Iterable<Object[]> testCases() {
        return Arrays.asList(new Object[][]{
                {"Invalid password", user.getLogin(), user.getPassword(), "The username and password could not be verified."},
                {"Empty password", user.getLogin(), "", "Please enter a username and password."},
                {"Empty login", "", user.getPassword(), "Please enter a username and password."},
                {"Empty password and login", "", "", "Please enter a username and password."}
        });
    }

    @Parameter
    public String testCase;

    @Parameter(1)
    public String login;

    @Parameter(2)
    public String password;

    @Parameter(3)
    public String message;

    @Before
    @Override
    public void setUp() {
        RestAssured.baseURI = server;
        RestAssured.basePath = path;

        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();
    }

    @Test
    public void login() {

        String actualMessage = given()
                .cookie("JSESSIONID")
                .when()
                .formParam("username", login)
                .formParam("password", password)
                .post(LOGIN)
                .then()
                .extract()
                .response()
                .body()
                .htmlPath()
                .getString("html.body.div.div.div.p.text()");

        Assert.assertEquals("Message is invalid!", message, actualMessage);
    }

}
